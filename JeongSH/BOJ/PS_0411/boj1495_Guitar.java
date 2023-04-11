package BOJ.PS_0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    dp[n][k] : n 번째 곡을 연주 할때 k 볼륨이 될수있는가
    메모리제이션을 사용하여 n 번째 곡을 연주했을 때 가능한 볼륨을 boolean 값으로 저장합니다.

    볼륨의 최대값이 1000 이고, 곡 수가 50 곡이므로 최악의 경우
    50 * 1000 의 시간 복잡도를 가집니다.

    1. 볼륨(k)을 1~1000 까지 돕니다.

    2. n-1 곡에서 가능한 볼륨 k 중 0<= ( k + arr[i] ) <= M 만족한다면,
        dp[n][k + arr[i]] = true 가 됩니다.

    3. n-1 곡에서 가능한 볼륨 k 중 0<= ( k - arr[i] ) <= M 만족한다면,
        dp[n][k - arr[i]] = true 가 됩니다.

    4. dp[n][k] == true 인 가장 큰 수를 구합니다.

 */

public class boj1495_Guitar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[51][1001];
        int[] arr = new int[51];

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int S = Integer.parseInt(inputs[1]);
        int M = Integer.parseInt(inputs[2]);


        inputs = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(inputs[i-1]);
        }

        dp[0][S] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j] == 1) {
                    if (0 <= j + arr[i] && j + arr[i] <= M) {
                        dp[i][j+arr[i]] = 1;
                    }

                    if (0 <= j-arr[i] && j-arr[i] <= M) {
                        dp[i][j-arr[i]] = 1;
                    }
                }
            }
        }
        int ret = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[N][i] == 1) {
                ret = i;
            }
        }
        System.out.println(ret);
    }
}
