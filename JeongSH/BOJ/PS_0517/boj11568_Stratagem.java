package BOJ.PS_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    입력값이 1000 이기때문에 O(N^2) 풀이도 가능할거라 판단하였습니다.

    점화식
    dp[i] : i번째 숫자를 마지막으로 하는 최장 수열의 길이.

    풀고 난 뒤, LIS 알고리즘을 알게되었고
    증가 수열만을 담을 배열과 이분탐색으로 O(Nlogn) 으로 풀 수 있다는걸 알았습니다.

    1. 증가 수열을 담을 배열 생성 ( LIS[] )
    2. LIS[] 의 마지막 값과 입력배열을 순서대로 비교
    3. 입력값이 현재 LIS[] 값보다 크다면, LIS[] 뒤에 입력값을 넣어줍니다.
    4. 입력값이 현재 LIS[] 값보다 작다면, 이분탐색을 통해 옳바른 LIS[] 인덱스에 값을 넣어줍니다.
    5. 2~4를 반복 한 뒤, LIS[] 배열의 크기가 최장증가 수열의 길이가 됩니다.

 */

public class boj11568_Stratagem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= new int[1000];
        int[] dp = new int[1000];

        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int now = arr[i];
            for (int j = 0; j < i; j++) {
                if(now > arr[j]){               // 현재값보다 작은 숫자가 있다면 증가수열이 됩니다.
                    dp[i]=Math.max(dp[j]+1, dp[i]);     // dp 값을 비교하여 가장 긴 수열길이를 최신화합니다.
                    max = Math.max(max,dp[i]);
                }
            }
        }
        System.out.println(max+1);
    }
}
