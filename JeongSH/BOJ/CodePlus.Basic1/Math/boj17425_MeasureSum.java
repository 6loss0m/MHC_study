package CodePlus.Basic1.Math;

import java.io.*;

public class boj17425_MeasureSum {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        long dp[] = new long[1000001];
        dp[1]=1;
        for(int i=2; i<1000001; i++){
            for(int j=1; i*j<1000001; j++){
                dp[i*j] += i;
            }
            dp[i]+=dp[i-1]+1;
        }
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
