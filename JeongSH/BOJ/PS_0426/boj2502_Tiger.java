package BOJ.PS_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어
    문제를 보면 피보나치 수열문제라는 것을 알 수 있습니다.

    구해야 할 건
    A: 첫째 날 준 떡
    B: 둘째 날 준 떡

    시간의 흐름으로 보면
    D1. A
    D2. B
    D3. A+B
    D4. A+2B
    D5. 2A+3B
    D6. 3A+5B
    ....

    D=6 / K=41
    6번째 날은 3A + 5B 이므로
    3A + 6B = 41
    이를 만족하는 A,B 를 구하면됩니다.

 */

public class boj2502_Tiger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int D = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int[] A = new int[31];
        int[] B = new int[31];
        A[1] = 1;
        B[2] = 1;
        for(int i=3; i<=D; i++){
            A[i]=A[i-1]+A[i-2];
            B[i]=B[i-1]+B[i-2];
        }

        for(int i=1; i<=K; i++){
            int riceCake = K-(A[D]*i);      // ex) 3A + 6B =41
                                            // 6B = 41-3A
            if(riceCake % B[D]==0){         // 나누어떨어지면
                System.out.println(i);
                System.out.println(riceCake/B[D]);  // (41-3A)/B
                return;
            }
        }
    }
}
