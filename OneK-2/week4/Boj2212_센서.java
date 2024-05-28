import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dif = new int[n - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (k >= n) {
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            dif[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(dif);
        for (int i = 0; i < n - k; i++) {
            sum += dif[i];
        }
        System.out.println(sum);
    }
}
