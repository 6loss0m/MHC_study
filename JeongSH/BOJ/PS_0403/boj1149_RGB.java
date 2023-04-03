package BOJ.PS_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어
    마지막으로 칠한 집의 색이 다음 칠할 집의 색 선택에 관여합니다.
    [i-1] 의 집을 R 로 칠했다면,
    [i] 집은 G,B 중 하나의 색으로 칠해야 합니다.

    그러므로
    [i] 집에 사용하지 않은 색 중 비용이 적은 값을 선택해야 합니다.

     R:0 / G:1 / B:2
     dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0]
     dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1]
     dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2]

 */

public class boj1149_RGB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j]=Integer.parseInt(inputs[j]);
            }
        }

        int[][] dp = new int[N][3];
        dp[0][0]=arr[0][0]; dp[0][1]=arr[0][1]; dp[0][2]=arr[0][2];
        for (int i = 1; i < N; i++) {
            dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
            dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1];
            dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
        }

        System.out.println(Math.min(dp[N-1][2],Math.min(dp[N-1][0],dp[N-1][1])));

    }
}
