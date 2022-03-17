package BOJ.PS_0310;
/*
    간단한 문제라고 생각해서 nlogn 시간복잡도로 문제를 풀었습니다.
    하지만, 이 문제는 nlogn 으로 풀었을 때 시간초과가 났습니다.
    (입력값이 10^5 이지만 시간초과)

    곰곰히 생각해보고 dp로 문제를 풀기로 했습니다.
    dp[N] : N번부터 0번까지의 최대 연속 합.
    즉,
    dp[n] = max( dp[n-1]+arr[n], arr[n] )
    0~n-1 번까지의 연속 합 + n 번째 수
    vs
    n번째 수

    ** dp[n] = arr[n] 이 들어간다면, 연속된 숫자를 끊는것.


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1912_ContinuousSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){ arr[i] = Integer.parseInt(input[i]); }

        dp[0]=arr[0];
        int max = dp[0];
        for(int n=1; n<N; n++){
            dp[n] = Math.max(dp[n-1]+arr[n],arr[n]);
            max = Math.max(dp[n],max);
        }
        for(int i=0; i<N; i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        System.out.println(max);
    }
}
