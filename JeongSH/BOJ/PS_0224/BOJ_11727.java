package BOJ.PS_0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    타일을 채울 수 있는 경우의 수는
    가로가 1인 경우 : 1
    가로가 2인 경우 : 3 (but 가로가 1인 경우와 겹침.) -> 즉, 2

    가로가 N 일 경우 점화식을 세우면
    (n-1 까지의 경우)*1 + (n-2 까지의 경우)*2
    f(n) = f(n-1) + 2f(n-2)

 */


public class BOJ_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1001];

        int N = Integer.parseInt(br.readLine());

        dp[1]=1;
        dp[2]=3;
        for(int i=3; i<=N; i++){ dp[i]=(dp[i-1] + 2*dp[i-2])%10007; }

        System.out.println(dp[N]);
    }
}
