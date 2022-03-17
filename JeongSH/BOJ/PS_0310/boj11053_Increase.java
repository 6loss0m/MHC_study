package BOJ.PS_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제접근
    dp[N] : arr[N] 을 최대값으로 하는 증가 부분 수열의 길이.

 */


public class boj11053_Increase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N+1];
        int[] dp = new int[N+1];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){ arr[i]=Integer.parseInt(input[i]); }

        int max;
        int answer=0;
        for(int i=0; i<N; i++){
            max=0;
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){        // arr[i]를 최대값으로 했을 때,
                    if(max < dp[j]){ max = dp[j]; } // 그 전 까지의 가장 긴 수열이 max 값이 됨.
                }
            }
            dp[i]=max+1;                    // 가장 긴 수열+1
            answer = Math.max(answer,dp[i]);
        }

        System.out.println(answer);

    }
}
