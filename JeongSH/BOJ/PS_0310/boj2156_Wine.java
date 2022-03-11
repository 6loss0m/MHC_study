package BOJ.PS_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    와인을 마시는 경우는 크게 세가지로 볼 수있습니다.
    xoo 마지막 잔과, 전 잔을 마실 경우.
    oxo 전전 잔과 , 마지막 잔을 마실 경우.
    oox 전전 잔과 , 전 잔을 마실 경우.

    dp[N] : N 번 잔까지 봤을 때 마실 수 있는 최대의 양.
    W[N]  : N 번째 잔의 양.

    dp[N] = dp[N-3] + W[N] + W[N-1] -> ?xoo 경우.
          = dp[N-2] + W[N] -> ?xo 경우.
          = dp[N-1] -> ??x 경우.

    이 세가지 경우 중 가장 큰 값이 dp[N] 이 됩니다.

 */


public class boj2156_Wine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] W = new int[N+1];
        int[] dp = new int[N+1];
        for(int n=1; n<=N; n++){ W[n] = Integer.parseInt(br.readLine()); }

        dp[1] = W[1];
        if(N==1) { System.out.println(dp[1]);return; }      // 예외처리를 꼭해줍니다..
        dp[2] = W[1]+W[2];
        if(N==2) { System.out.println(dp[2]); return; }

        for(int n=3; n<=N; n++){
            dp[n]=Math.max( Math.max(dp[n-2]+W[n], dp[n-3]+W[n-1]+W[n]), dp[n-1]);
        }
        System.out.println(dp[N]);
    }
}
