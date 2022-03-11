package BOJ.PS_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    50  10  100  20  40
    30  50  70   10  60

    0번째 줄의 50 스티커를 뗄 경우
    50,70 둘 중 하나의 스티커를 뗄 수 있습니다.
    이유: 50 짜리 스티커를 뗄경우 100 스티커는 당연히 뗄 수 있기때문.
         70 짜리 스티커를 뗀다면 100 스티커는 뗄 수 없음.

    1번째 줄의 30 스티커를 뗄 경우
    10,100 둘 중 하나의 스티커를 뗄 수 있습니다.

    50 (30+10) (30+100)vs(50+50+100)=200  (50+50+20)vs(120+20)=140   (120+40)vs(210+40)=250
    30 (50+50) (50+70)vs(30+10+70)=120    (30+100+10)vs(200+10)=210  (200+60)vs(140+60)=260

    점화식을 세우면,
    dp[N][0] = dp[N][0] + MAX(dp[N-1][1] , dp[N-2][1])
    dp[N][1] = dp[N][1] + MAX(dp[N-1][0] , dp[N-2][0])
    됩니다.


 */

public class boj9465_Sticker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N;
        int[][] dp = new int[100001][2];
        String[] input1;
        String[] input2;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T ; t++){
            N = Integer.parseInt(br.readLine());
            input1 = br.readLine().split(" ");
            input2 = br.readLine().split(" ");

            for(int n=1; n<=N; n++){
                dp[n][0] = Integer.parseInt(input1[n-1]);
                dp[n][1] = Integer.parseInt(input2[n-1]);
            }

            for(int n=2; n<=N; n++){
                dp[n][0]+= Math.max(dp[n-1][1], dp[n-2][1]);
                dp[n][1]+= Math.max(dp[n-1][0], dp[n-2][0]);
            }
            sb.append(Math.max(dp[N][0],dp[N][1])).append("\n");
        }
        System.out.println(sb);
    }
}
