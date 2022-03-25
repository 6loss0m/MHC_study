package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제접근
    dp[N] : N을 만드는 최소 제곱 항의 갯수

    1. dp[N] 의 최대 항의 갯수는 N 과 같습니다.
    2. dp[N]= dp[N-j^2]+1 과 같습니다.

    시행착오
    처음 생각한 방법은 N보다 작은 가장 큰 제곱항을 빼주식으로 반복문을 돌리는 방법이었습니다.
    그리디하게 접근을하면 안되는 이유.
       : 무조건 큰 수부터 빼고보면 안되는 이유.
            98 = 81 + 16 + 1 -> 3
            98 = 49 + 49 -> 2

 */


public class boj1699_Squared {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            dp[i]=i;
            for(int j=1; j*j<=i; j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
