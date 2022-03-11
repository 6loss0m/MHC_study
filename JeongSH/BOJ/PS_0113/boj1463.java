package BOJ.PS_0113;

/**
 *
 *  dp 문제라고 생각하여 풀이해보았습니다.
 *  bottom-up 으로
 *  2 ~ n 까지 모든 숫자의 연산 최소값을 적어가면서 올라갔습니다.
 *  문제 아이디어 :
 *      1. n을 입력받으면 2부터 ~ n 까지의 연산의 최소값을 계속 저장해 나갑니다.
 *      2. dp[i-1]+1 과 dp[i/2]+1 과 dp[i/3]+1 을 비교하여 최소값을 저장합니다.
 *
 *  주의점:
 *      i 가 2로도 나누어 떨어지고 3으로도 나누어 떨어진다면,
 *      i 를 2로 나눈 값과 i를 3으로 나눈값 둘 다 비교를 해봐야합니다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1]=0;
        for(int i=2; i<n+1; i++){
            dp[i]=dp[i-1]+1;                                // dp[i-1]+1 값을 미리 저장하고
            if(i%2==0){ dp[i]=Math.min(dp[i],dp[i/2]+1); }  // dp[i-1]+1 값과 dp[i/2]+1
            if(i%3==0){ dp[i]=Math.min(dp[i],dp[i/3]+1); }  // dp[i-1]+1 값과 dp[i/3]+1 값을 비교합니다.
        }                                                   // if else 가 아닌이유는 2,3 으로 나누어 떨어지는 숫자는 둘 다 체크해야 함.
        System.out.println(dp[n]);
    }
}
