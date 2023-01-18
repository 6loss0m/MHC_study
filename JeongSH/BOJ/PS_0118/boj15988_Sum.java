package BOJ.PS_0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    dp 문제입니다.
    dp[N] : n 을 만드는 방법
    dp[N] = dp[N-1] + dp[N-2] + dp[N-3]
    ex)
    dp[5]
    dp[4] 를 만드는 방법 뒤에 모두 +1 을 하여 만드는 경우.
    do[3] 를 만드는 방법 뒤에 모두 +2 을 하여 만드는 경우.
    do[2] 를 만드는 방법 뒤에 모두 +3 을 하여 만드는 경우.

    * 계산과정에서 int 범위를 넘길 수 있기 때문에 모든 계산과정에 나머지 연산을 해야합니다.
    dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%MOD  -> x

    dp[i]=(dp[i]+dp[i-1])%MOD       -> o
    dp[i]=(dp[i]+dp[i-2])%MOD
    ..

 */


public class boj15988_Sum {
    static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] testCase = new int[T];
        int max = -1;

        for(int i=0;i<T;i++){
            testCase[i]=Integer.parseInt(br.readLine());
            max = Math.max(testCase[i],max);
        }

        int[] dp = new int[max+1];
        dp[1]=1; dp[2]=2; dp[3]=4;

        for(int i=4;i<=max;i++){
            dp[i]=(dp[i]+dp[i-1])%MOD;
            dp[i]=(dp[i]+dp[i-2])%MOD;
            dp[i]=(dp[i]+dp[i-3])%MOD;
        }

        for(int i=0;i<T;i++){
            System.out.println(dp[testCase[i]]%MOD);
        }
    }
}
