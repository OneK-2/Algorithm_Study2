import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());
        Long c = Long.parseLong(st.nextToken());

        System.out.println(circ(a, b, c));
    }

    private static long circ(Long a, Long b, Long c) {
        if (b == 1) { //지수가 1일 경우 a 리턴
            return a % c;
        }
        //지수의 절반 해당하는 값 구하기
        long tmp = circ(a, b / 2, c);

        //홀수면 a한번 더 곱해준다
        if (b % 2 == 1) {
            return (tmp * tmp % c) * a % c;
        }
        return tmp * tmp % c;
    }
}
