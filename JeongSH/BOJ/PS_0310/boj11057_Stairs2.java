package BOJ.PS_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제접근
    dp[N][k] : 길이가 N이고, 마지막 자리가 k로 끝나는 오르막 수의 갯수.
    ex)
    dp[1][0] -> 0
    dp[1][1] -> 1
    dp[1][2] -> 2 ...

    dp[2][0] -> 00
    dp[2][1] -> 01 11
    dp[2][2] -> 02 12 22
    dp[2][3] -> 03 13 23 33
    dp[2][4] -> 04 14 24 34 44 ...

    dp[3][0] -> 000
    dp[3][1] -> 001 011 111
    dp[3][2] -> 002 012 022 112 122 222
    dp[3][3] -> 003 013 023 033 113 123 133 223 233 333


    규칙을 찾아보면,
    dp[3][3] = dp[2][3] 뒤에 3을 붙인 것.
               + dp[2][2] 뒤에 3을 붙인 것.
               ....

    dp[3][3] = dp[2][3] +          dp[2][2] +     dp[2][1] +    dp[2][0]
               (03,13,23,33)3    (02,12,22)3       (01,11)3       (00)3


    dp[N][k] = dp[N-1][k] + dp[N-1][k-1] ... dp[N-1][0] 으로 점화식을 세울 수 있습니다.

 */

public class boj11057_Stairs2 {
    public static final long MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][10];
        for(int i=0; i<10; i++){ dp[1][i]=1; }

        for(int n=2;n<=N; n++){
            for(int k=0; k<10; k++){
                for(int i=0; i<=k; i++){
                    dp[n][k]= (dp[n][k]+dp[n-1][i])%MOD;
                }
            }
        }
        long ret =0;
        for(int i=0; i<10;i++){ ret+=dp[N][i]; }
        System.out.println(ret%MOD);
    }
}
