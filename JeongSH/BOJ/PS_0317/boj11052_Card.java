package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제접근
    dp[N] : N 장의 카드를 사기위해 지불하기 위한 최대비용.

    N = 4
    p[] = {1, 5, 6, 7}
    dp[1] = 1   : 1장의 카드를 사기위한 최대 비용.
    dp[2] = 5   : 2장의 카드를 사기위한 최대 비용.
        비교를 해야하는것은,
        1. 2장짜리 팩을 하나 살것인지
        2. 1장을 사기위한 최대비용 + 1장을 사기위한 최대비용
        비교해야합니다.
        p[2] vs (dp[1]+dp[1])

    dp[3] = 6   : 3장의 카드를 사기위한 최대 비용.
        비교해야하는것.
        1. 카드 2장을 살때 최대비용 + 카드 1장을 살때 최대비용.
        p[3] vs (dp[2] + dp[1])

    dp[4] = 10  : 4장의 카드를 사기위한 최대 비용.
        비교해야하는것
        1. 카드 3장 최대비용 + 카드 1장 최대비용.
        2. 카드 2장 최대비용 + 카드 2장 최대비용.
        p[4] vs (dp[3]+dp[1]) vs (dp[2]+dp[2])

 */


public class boj11052_Card {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        input = br.readLine().split(" ");
        for (int i=0; i<N; i++){ arr[i+1] = Integer.parseInt(input[i]); }
        dp[1] = arr[1];
        for(int n=2; n<=N; n++){
            dp[n] = arr[n];         // arr[n] 이 N장을 사기위한 최대비용일수 있으므로
            for(int k=1; k<=(n)/2; k++){    // n/2 까지 도는이유는 가운데를 기준으로 합이 대칭을 이루기때문.
                dp[n] = Math.max(dp[n],dp[k]+dp[n-k]); // ex) N=4, dp[1]+dp[3] 이나 dp[3]+[1] 이나 같으므로, dp[2]+dp[2] 까지만 비교
            }
        }
        System.out.println(dp[N]);
    }
}
