import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int left = max;
        int right = 100000 * 10000;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (m >= findMin(mid, arr, n)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static int findMin(int mid, int[] arr, int n) {
        int size = mid;
        int cnt = 1;
        int idx = 0;
        while (idx < n) {
            size -= arr[idx];
            if(size < 0){
                cnt++;
                size = mid - arr[idx];
            }
            idx++;
        }
        return cnt;
    }

}
