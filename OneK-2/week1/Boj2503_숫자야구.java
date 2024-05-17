import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][][] chk = new int[10][10][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // 모든 3자리 가능성 비교 체크
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String res = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            checkAns(res, s, b);
        }
        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (chk[i][j][k] == n) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void checkAns(String res, int s, int b) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || i == k) continue;
                    String tmp = "";
                    tmp += i;
                    tmp += j;
                    tmp += k;

                    int sCnt = 0;
                    int bCnt = 0;
                    for (int f = 0; f < 3; f++) {
                        for (int e = 0; e < 3; e++) {
                            if (f == e && tmp.charAt(f) == res.charAt(e)) {
                                sCnt++;
                            } else if (tmp.charAt(f) == res.charAt(e)) {
                                bCnt++;
                            }
                        }
                    }
                    if (sCnt == s && bCnt == b) {
                        chk[i][j][k] += 1;
                    }
                }
            }
        }
    }

    private static boolean isSame(String tmp, String target, int strike, int ball) {
        int sCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && tmp.charAt(i) == tmp.charAt(j)) {
                    sCnt++;
                } else if (tmp.charAt(i) == tmp.charAt(j)) {
                    bCnt++;
                }
            }
        }
        if (sCnt == strike && bCnt == ball) {
            return true;
        } else {
            return false;
        }
    }
}
