package BOJ.PS_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    7
    3 8
    8 1 0
    2 7 4 4
    4 5 2 6 5

    점화식
    dp[n][k] : n,k 에 올 수 있는 가장 큰 수.

    dp[n][0] = dp[n-1][0] + arr[n][0]
    dp[n][n] = dp[n-1][n-1] + arr[n][n]
    가장 왼쪽 숫자는 계속 내려가면서 더해주면 되고,
    가장 오른쪽 숫자는 대각선으로 내려가며 더해주면 됩니다.

    사이에 낀 수들은
    max( dp[i-1][j-1] , dp[i-1][j] ) + arr[i][j]
    계산할 수 있습니다.

 */

public class boj1932_Triangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        dp[0][0]=arr[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0]= dp[i-1][0] + arr[i][0];
            dp[i][i]= dp[i-1][i-1] + arr[i][i];
            for (int j = 1; j < i; j++) {
                dp[i][j]= Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[N-1][i],max);
        }
        System.out.println(max);
    }
}
