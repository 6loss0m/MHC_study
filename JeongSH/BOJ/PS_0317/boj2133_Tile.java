package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    N=2 일 때 경우의 수는 3 이고, 홀수는 타일을 배치할 수 없습니다.

    dp[0] = 1
    dp[2] = 3
    dp[3] = 0
    dp[4] 부터는 크게 두 덩어리로 나누어 보면 dp[2]*3 = 9 입니다.
    하지만 두 덩어리의 경계선으로 만들수있는 타일의 경우가 더 있습니다. 2개.
    dp[4] = dp[2]*3 + 2 = 11
    dp[6] = dp[4]*3 + dp[2]*2 + 2
            -> dp[4]짜리 경우의 수에 dp[2] 짜리를 두는 방식으로 생각해보면 됩니다.
            3*4 / 3*2 덩어리로 생각. (dp[4]*3)

            dp[4] 에서 본 경계선을 이용하여 만드는 타일 경우가 있으므로
            3*2 / 3*4 로 본다면 경우의 수가
            위의 경우를 제외하고
            dp[2]*2 가 됩니다. 2 인 이유는 dp[4]에서 경계선으로 만드는 경우가 2개 이므로.

            위 상황들을 제외하고 dp[6] 은 자체적으로 2개의 예외를 더 만들 수 있습니다.

   점화식
   dp[N] = dp[N-2]*3 + (dp[N-4]*2 + dp[N-6]*2 .... + 2)

 */


public class boj2133_Tile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[0]=1;
        dp[1]=0;
        dp[2]=3;

        for(int i=4; i<=N; i+=2){
            dp[i] = 3*dp[i-2];
            for(int j=0; j<i-2; j+=2){
                dp[i]+=dp[j]*2;
            }
        }
        System.out.println(dp[N]);
    }
}
