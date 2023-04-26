package BOJ.PS_0426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어
    dp[시간][이동횟수][위치] = 최대 자두갯수

    1. 움직이지 않았고, 현재 떨어진 자두가 내 위치인가
    2. 움직였고, 현재 떨어진 자두가 내 위치인가

    dp[time][move][위치] = max(dp[time-1][move][위치] + (현재위치에서 자두가 떨어지면 +1 ),
                              dp[time-1][move-1][다른위치] +(현재위치에서 자두가 떨어지면 +1))


 */

public class boj2240_Plum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] dp = new int[1001][31][2]; // dp[시간][이동횟수][위치]
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int[] arr = new int[T+1];
        for (int i = 1; i <= T; i++) {
            String in = br.readLine();
            arr[i] = Integer.parseInt(in);
        }

        // dp[이동횟수][현재위치][시간]
        for (int time = 1; time <= T; time++) {
            for (int move = 0; move <= W; move++) {
                if(move==0){
                    dp[time][move][0] = dp[time-1][move][0] + (arr[time]==1? 1:0);
                }
                else{
                    dp[time][move][0] = Math.max(dp[time-1][move][0]+(arr[time]==1? 1:0),
                            dp[time-1][move-1][1] + (arr[time]==1? 1:0));

                    dp[time][move][1] = Math.max(dp[time-1][move][1]+(arr[time]==2? 1:0),
                            dp[time-1][move-1][0] + (arr[time]==2? 1:0));
                }
            }

        }
        int ret=0;
        //  모든 시간은 고려할필요 없지만, 움직인 횟수와 끝난 위치는 모두 확인해야하기 떄문
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= W; j++) {
                ret = Math.max(ret,dp[T][j][i]);
            }
        }
        System.out.println(ret);
    }
}
