package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    소인수 분해를 해줍니다.
    반복분이 대칭을 이루고 있기때문에 제곱근까지만 순회하면 됩니다.
    제곱근 까지만 돌기때문에 소수같은 경우에는 반복문 범위에 들어가지않을 수 있어 따로 처리해야합니다.
    ex) 14 -> 2 * 7
    2는 순회 범위에 들어가기때문에 추가되지만
    sqrt(14) 는 약 3.xxx 이므로 7을 추가할 수 없습니다.
    그러므로 마지막 조건으로 N != 1 이 아닐경우 추가해줍니다.

 */

public class boj11653_Factorization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int maxLen = (int) Math.sqrt(N);

        for (int i = 2; i <= maxLen; i++) {
            while (N%i == 0) {
                sb.append(i).append("\n");
                N/=i;
            }
        }
        if(N!=1){sb.append(N).append("\n");}
        System.out.print(sb);
    }
}
