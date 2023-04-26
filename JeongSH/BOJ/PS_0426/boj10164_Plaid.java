package BOJ.PS_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어
    오른쪽 아래로만 이동하므로
    이동하는 경우의 수는
    dp[i][j] = dp[i-1][j]+ dp[i][j-1] + dp[i][j] 입니다.

    격자를 지나는 경우의수는
    (0,0) 부터 (격자y,격자x) 까지의 경우의 수
    (격자y,격자x) 부터 (N,M) 까지의 경우의 수를 곱해주면 됩니다.


 */

public class boj10164_Plaid {
    static int[][] dp = new int[16][16];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int mark = Integer.parseInt(input[2]);
        int y = ((mark-1)/M)+1;
        int x = ((mark-1)%M)+1;

        go(1,1,N,M);
        if(mark == 0){
            System.out.println(dp[N][M]);
            return;
        }
        System.out.println(dp[y][x]*dp[N-y+1][M-x+1]);

    }

    static int go(int startY, int startX, int endY, int endX){
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if(i==startY || j==startX){ dp[i][j]=1; continue;}
                dp[i][j]+=dp[i-1][j];
                dp[i][j]+=dp[i][j-1];
            }
        }
        return dp[endY][endX];
    }
}
