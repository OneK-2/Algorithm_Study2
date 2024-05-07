import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr = new int[3][3];
    static boolean visited[] = new boolean[512]; //2^9

    /*
      1 0 0
      1 0 0  = > 1 0 0 1 0 0 0 1 1 => 291
      0 1 1
      */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            arr = new int[3][3];
            visited = new boolean[512];
            for (int j = 0; j < 3; j++) { //입력
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    char tmp = st.nextToken().charAt(0);
                    if (tmp == 'H') {
                        arr[j][k] = 1;
                    } else {
                        arr[j][k] = 0;
                    }
                }
            }
            System.out.println(cirCoin());
        }
    }

    private static int cirCoin() {
        Queue<int[]> q = new ArrayDeque<>();
        int first = arrToInt();
        q.offer(new int[]{first, 0});
        visited[first] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cnt = cur[1]; //변환횟수

            intToArr(now);

            if (isCorrect()) { // 모든 면이 같은지 확인
                return cnt; // 모두 같으면 변환 횟수(거리) 반환
            }

            //열 변환
            for (int i = 0; i < 3; i++) {
                colChange(i);
                int next = arrToInt();
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
                colChange(i); // 복구
            }
            //행 변환
            for (int i = 0; i < 3; i++) {
                rowChange(i);
                int next = arrToInt();
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
                rowChange(i); // 복구
            }
            //대각선
            for (int i = 0; i < 2; i++) {
                crossChange(i);
                int next = arrToInt();
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new int[]{next, cnt + 1});
                }
                crossChange(i); // 복구
            }
        }

        return -1;
    }

    private static void crossChange(int num) {
        for (int i = 0; i < 3; i++) {
            if (num == 0) {
                arr[i][i] = (arr[i][i] == 1) ? 0 : 1;
            } else {
                arr[i][2 - i] = (arr[i][2 - i] == 1) ? 0 : 1;
            }
        }
    }

    private static void rowChange(int num) {
        for (int i = 0; i < 3; i++) {
            arr[num][i] = (arr[num][i] == 1) ? 0 : 1;
        }
    }

    private static void colChange(int num) {
        for (int i = 0; i < 3; i++) {
            arr[i][num] = (arr[i][num] == 1) ? 0 : 1;
        }
    }

    private static boolean isCorrect() {
        int tmp = arr[0][0];
        for (int[] r : arr) {
            for (int c : r) {
                if (tmp != c) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void intToArr(int now) {
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                arr[i][j] = now % 2;
                now /= 2;
            }
        }
    }

    private static int arrToInt() {
        int now = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                now = now * 2 + arr[i][j];
            }
        }
        return now;
    }
}
