package BOJ.PS_0310;

/*
    문제 접근
    마지막 숫자가 0인지, 1인지에 따라 그 전 숫자가 결정됩니다.
    1[][]0 -> 1[]10
           -> 1[]00

    1[][]1 -> 1[]01

    마지막 숫자가 1로 끝나면 바로 전 숫자는 반드시 0이 와야합니다.
    마지막 숫자가 0로 끝나면 바로 전 숫자는 0,1 이 올 수 있습니다.

    즉,
    dp[N][0] = dp[N-1][0] + dp[N-1][1]
    dp[N][1] = dp[N-1][0]
    이 됩니다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2193_PinaryNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][2];
        dp[1][1] = 1;

        for(int i=2; i<=N; i++){
            dp[i][0]=dp[i-1][0]+dp[i-1][1];
            dp[i][1]=dp[i-1][0];
        }
        System.out.println(dp[N][0]+dp[N][1]);
    }
}
