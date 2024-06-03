import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n, m, cnt = 0;
    static int[] dy = {-1, 0, 1, 0};    //북동남서 -> 0,1,2,3
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //방크기
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        //청소기 좌표
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        //방정보
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(cnt);
    }

    public static void clean(int r, int c, int d) {
        boolean check = false;
        if (arr[r][c] == 0) {
            arr[r][c] = -1;
            cnt++;
        }
        int od = d;
        //청소확인
        for (int i = 0; i < 4; i++) {
            int nd = (d + 3) % 4;
            int nc = c + dx[nd];
            int nr = r + dy[nd];

            if (nc >= 0 && nr >= 0 && nc < m && nr < n) {
                if (arr[nr][nc] == 0) {
                    clean(nr, nc, nd);
                    check = true;
                    break;
                }
            }
            d = (d + 3) % 4;
        }

        //청소o, 벽
        if (!check) {
            int nd = (od + 2) % 4;
            int bc = c + dx[nd];
            int br = r + dy[nd];

            if (bc >= 0 && br >= 0 && bc < m && br < n) {
                if (arr[br][bc] != 1)
                    clean(br, bc, od);
            }
        }

    }
}