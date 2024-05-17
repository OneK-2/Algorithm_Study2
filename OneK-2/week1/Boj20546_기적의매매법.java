import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //주어진 현금
        int[] arr = new int[14];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //(현금 + 1월 14일의 주가 × 주식 수)
        int bnp = cirBNP(arr, n);
        int curTim = cirTim(arr, n);

        if (bnp>curTim){
            System.out.println("BNP");
        } else if (bnp<curTim) {
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }

    }

    private static int cirTim(int[] arr, int money) {
        int tmp[] = arr.clone();
        int stCnt = 0;
        int upCnt = 0;
        int downCnt = 0;

        for (int i = 1; i < 14; i++) {
            if (tmp[i - 1] < tmp[i]) {
                upCnt++;
                downCnt = 0;
            } else if (tmp[i - 1] > tmp[i]) {
                downCnt++;
                upCnt = 0;
            } else {
                upCnt = 0;
                downCnt = 0;
            }

            if (upCnt == 3) { //3일째 상승하면 매도
                money += stCnt * tmp[i];
                stCnt = 0;
            }
            if (downCnt >= 3) { //3일째 하락하면 매수
                if (money >= tmp[i]) {
                    stCnt += money / tmp[i];
                    money %= tmp[i];
                }
            }
        }
        int res = money + tmp[13] * stCnt;
        return res;
    }

    private static int cirBNP(int[] arr, int money) {
        int[] tmp = arr.clone();
        int cnt = 0;
        for (int i = 0; i < 14; i++) {
            int canBuy = money / tmp[i];
            if (canBuy > 0) {
                cnt += canBuy;
                money %= tmp[i];
            }
        }
        int res = money + tmp[13] * cnt;
        return res;
    }

}
