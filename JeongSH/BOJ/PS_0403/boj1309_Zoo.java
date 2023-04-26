package BOJ.PS_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    아이디어
    사자가 몇 마리 일 때 경우의 수를 생각 하는게 아니라,
    사자를 어떻게 배치했을 때의 경우의 수를 파악해야 하는 문제입니다.

    1. [i-1] 줄에 아무 사자를 배치 하지않았다면
        [i] 줄에 올 수 있는 사자의 경우의 수는 3개 입니다. (사자 x, 왼쪽에 사자, 오른쪽에 사자)

    2. [i-1] 줄 왼쪽에 사자를 배지 했다면
        [i] 줄에 올 수 있는 사자의 경우의 수는 2개 입니다. (사자 x, 오른쪽 사자)

    3. [i-1] 줄 오른쪽에 사자를 배치 했다면
        [i] 줄에 올 수 있는 사자의 경우의 수는 2개 입니다. (사자 x, 왼쪽 사자)

    그러므로 점화식은
    dp[i][k] : i번째 줄의 k 상태
             [i][0]: 사자 없음 / [i][1]: 왼쪽에 사자 / [i][2]: 오른쪽에 사자

    dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
    dp[i][1] = dp[i-1][0] + dp[i-1][2]
    dp[i][2] = dp[i-1][0] + dp[i-1][1]

 */

public class boj1309_Zoo {

    public static final int MOD = 9901;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][3];
        dp[0][0]=1; dp[0][1]=1; dp[0][2]=1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])% MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])% MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])% MOD;
        }
        System.out.println((dp[N-1][0]+dp[N-1][1]+dp[N-1][2])%MOD);

    }
}
