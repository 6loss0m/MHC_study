package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제 접근
    dp[20][2] = 21 입니다.
    첫번째 숫자 / 두번째 숫자.
    [20] + [0]
    [19] + [1]
    [18] + [2]
    ..

    그럼 dp[20][3] 구할 때,
    앞의 두 숫자를 한 덩어리로 보고 뒤를 한 덩어리로 보게되면
    [][] / [0] 뒤를 0로 고정
        == dp[20][2]
    [][] / [1] 뒤를 1로 고정
       == dp[19][2]
   [][] / [2] 뒤를 2로 고정
       == dp[18][2]
   .. 들의 합과 같습니다.
   즉,
   dp[N][K] = dp[N][K-1] + dp[N-1][K-1] + dp[N-2][K-1] + dp[N-3][K-1] ... dp[0][K-1]
   그리고
                          |                                                        |
                      여기서 부터                                                여기 까지
   dp[N-1][K] = dp[N-1][K-1] + dp[N-2][K-1] + dp[N-3][K-1] ... 위의 표시된 부분과 같습니다.
   식을 간단히 바꾸면
   dp[N][K] = dp[N][K-1] + dp[N-1][K] 가 됩니다.

 */
public class boj2225_Sum {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[201][201];
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        for(int i=0; i<=N; i++){ dp[i][1]=1; }
        for(int i=0; i<=K; i++){ dp[0][i]=1; }
        for(int k=2; k<=K; k++){
            for(int n=1; n<=N; n++){
                dp[n][k] = (dp[n-1][k] + dp[n][k-1])%MOD;
            }
        }
        System.out.println(dp[N][K]);
    }
}
