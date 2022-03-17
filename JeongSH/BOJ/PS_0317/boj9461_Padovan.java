package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    그림을 보면
    p[4]는 p[3] 의 변을 이용하지만
    그림과같이
    p[5] 부터는 규칙적으로 크기가 증가하는 걸 볼 수 있습니다.
    p[5] = p[4] + p[0]   변을 사용하고.
    p[6] = p[5] + p[1]   변을 사용합니다.
    ..
    p[N] = p[N-1] + p[N-5]

    p[10] 까지는 그림이 그려져있어서 쉽게 풀수 있습니다.

 */


public class boj9461_Padovan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        long[] dp = new long[100];
        int T = Integer.parseInt(br.readLine());
        dp[0]=1;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        dp[4]=2;
        for(int i=5; i<100; i++){ dp[i]=dp[i-1]+dp[i-5]; }
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N-1]).append("\n");
        }
        System.out.println(sb);
    }
}
