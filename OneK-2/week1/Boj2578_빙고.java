import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] bingo = new int[5][5];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //심판이 부르는 수
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                idx++;
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingo[k][l] == num) {
                            bingo[k][l] = 0;
                            bingoCheck();
                            if (cnt >= 3) {
                                System.out.println(idx);
                                return;
                            }
                            cnt = 0;
                        }
                    }
                }
            }
        }

    }

    public static void bingoCheck() {
        //가로
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) count++;
            }
            if (count == 5) cnt++;
        }
        //세로
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) count++;
            }
            if (count == 5) cnt++;
        }
        //대각
        int lcount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) lcount++;
            if (lcount == 5) cnt++;
        }
        int rcount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) rcount++;
            if (rcount == 5) cnt++;
        }
    }
}

