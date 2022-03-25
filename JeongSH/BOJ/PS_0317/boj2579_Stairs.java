import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    계단은 최대 한칸을 건너 뛸 수 있습니다.
    그리고 연속된 세칸을 밟을 수 없습니다.

    즉 N번 째 계단을 밟는 경우의 수는
    1. N-1, N 번을 밟는 경우. (N-2 는 밟을 수 없음.)
    2. N-2, N 번을 밟는 경우 입니다.

    점화식
    dp[N][0] : N번 째 계단을 밟고, 이전 계단을 "밟지않았을" 때, 최대 값.
    dp[N][1] : N번 째 계단을 밝고, 이전 계단을 "밟았을" 때, 최대 값.

    dp[N][0] = max(dp[N-2][1], dp[N-2][0]) + arr[N]
               (N-2 를 밟았을 경우 최대값.) + N
               2번 경우.

    dp[N][1] = dp[N-1][0] + arr[N];
               (N-1 를 밟았을 경우.) + N
                1번 경우.


    + 추가.
    식으로 쓰다보니, 2차원 배열을 1차원 배열로 줄일 수 있었습니다.
    dp[N][1] 에 N-2 를 대입 ->
    dp[N-2][1] = dp[N-3][0] + arr[N-2]
    ...
    dp[N][0] = max(dp[N-3][0]+arr[N-2], dp[N-2][0]) + arr[N]
    ->
    dp[N] = max(dp[N-3]+arr[N-2], dp[N-2]) + arr[N]


 */


public class boj2579_Stairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[][] dp = new int[N][2];

        for(int i=0; i<N; i++){ arr[i]=Integer.parseInt(br.readLine()); }

        dp[0][0]=dp[0][1]=arr[0];
        if(N==1){ System.out.println(arr[0]); return;}

        dp[1][0]=arr[1];
        dp[1][1]=arr[0]+arr[1];
        if(N==2){ System.out.println(dp[1][1]); return; }

        for(int i=2; i<N; i++){
            dp[i][0]=Math.max(dp[i-2][1],dp[i-2][0]) + arr[i];
            dp[i][1]=dp[i-1][0] + arr[i];
        }
        System.out.println(Math.max(dp[N-1][0],dp[N-1][1])); // 결과는 마지막 계단 전 계단을 밟는경우와
                                                             // 안 밟는 경우 둘 다 고려해야 함.
    }
}
