import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int left = max;
        int right = 100000 * 10000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (m >= getMCount(mid, arr)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static int getMCount(int mid, int[] arr) {
        int cnt = 1;
        int money = mid;
        for (int a : arr) {
            money -= a;
            if (money < 0) {
                cnt++;
                money = mid - a;
            }
        }
        return cnt;
    }

}