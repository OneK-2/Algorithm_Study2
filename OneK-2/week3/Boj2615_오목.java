import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 1};
    static int[] dy = {0, 1, 1, 1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[20][20];
        //검정:1 흰:2
        for (int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if (arr[i][j] == 0) continue;
                else {
                    for (int k = 0; k < 4; k++) {
                        int nx = i;
                        int ny = j;
                        int cnt = 1;

                        while (true) {
                            nx += dx[k];
                            ny += dy[k];
                            if (!isInRange(nx, ny)) {
                                if (arr[i][j] == arr[nx][ny]) cnt++;
                                else break;
                            } else break;
                        }

                        nx = i;
                        ny = j;
                        while (true) {
                            nx -= dx[k];
                            ny -= dy[k];
                            if (!isInRange(nx, ny)) {
                                if (arr[i][j] == arr[nx][ny]) cnt++;
                                else break;
                            } else break;
                        }
                        if (cnt == 5) {
                            System.out.println(arr[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }

                }
            }
        }
        System.out.println(0);
    }


    private static boolean isInRange(int nx, int ny) {
        return nx <= 0 || ny <= 0 || nx > 19 || ny > 19;
    }
}