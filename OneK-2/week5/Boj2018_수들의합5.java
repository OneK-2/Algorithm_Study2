package b2018;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// (1 ≤ N ≤ 10,000,000)
		int cnt = 1;
		int stIdx = 1;
		int endIdx = 1;
		int sum = 1;
		while (endIdx != n) {
			if (sum < n) {
				endIdx++;
				sum = sum + endIdx;
			} else if (sum > n) {
				sum = sum - stIdx;
				stIdx++;
			} else { // sum == n
				endIdx++;
				sum = sum + endIdx;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
