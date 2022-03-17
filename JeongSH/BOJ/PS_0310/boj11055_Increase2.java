package BOJ.PS_0310;

/*
    문제접근
    이전과 같은 문제.
    dp[N] : arr[N] 을 최대값으로하는 수열의 최대 합.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11055_Increase2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) { arr[i] = Integer.parseInt(input[i]); }

        int ret =0;
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i]= Math.max(dp[i],dp[j]+arr[i]);
                }
            }
            ret = Math.max(ret,dp[i]);
        }
        System.out.println(ret);
    }
}
