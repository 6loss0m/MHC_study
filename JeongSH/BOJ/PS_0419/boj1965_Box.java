package BOJ.PS_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*

    최대 상자가 1000개 이므로 O(N^2) 해도 시간초과가 나지않습니다.

    아이디어
    dp[i] : i 번째에 담을 수 있는 최대 상자 갯수

    i : 현재 상자 / j : i 이전의 상자들
    i 상자에 담을 수 있는 j 상자들 중 가장 큰 dp[j]값을 dp[i]에 합해줍니다.

 */

public class boj1965_Box {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000];
        int[] dp = new int[1000];
        Arrays.fill(dp,1);
        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }

        int ret=0;
        for (int i = 0; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){          // 상자에 담을 수 있다면
                    max = Math.max(dp[j],max);  // 이전 상자들 중 가장 많이 담을 수 있는 상자 갯수파악
                }
            }
            dp[i]+=max;                     // dp[i] 에 합해줍니다.
            ret = Math.max(dp[i],ret);      // 최대값을 구하기 위해
        }
        System.out.println(ret);
    }
}
