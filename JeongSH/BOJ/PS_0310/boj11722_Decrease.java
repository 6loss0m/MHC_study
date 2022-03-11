package BOJ.PS_0310;

/*
    문제 11053 문제와 같음.
    부등호만 바꾸면 해결..

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11722_Decrease {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){ arr[i] = Integer.parseInt(input[i]); }

        int max;
        int ret=0;
        for(int i=0; i<N; i++){
            max = 0;
            for(int j=0; j<i; j++){
                if(arr[i]<arr[j]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
            ret = Math.max(ret,dp[i]);
        }
        System.out.println(ret);
    }
}
