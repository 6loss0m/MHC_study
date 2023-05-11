package BOJ.PS_0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

    bfs 를 사용하면 중복계산되는 경우가 너무 많아 시간초과가 납니다.
    진행 방향이 오른쪽 아래 이므로 반복문을 통해 탐색 할 수 있습니다.
    O(N^2)

    dp[i][j] : i,j 칸에 도착하는 경우의 수

    아이디어
    1. 시작지점에서 갈 수 있는 칸을 구하여 줍니다.
        jump : arr[i][j]
        dp[i+jump][j] , dp[i][j+jump]

    2. 현재 칸의 경우의 수를 점프 할 수 있는 칸의 경우의 수에 합해줍니다.
        dp[i+jump][j] += dp[i][j]
        dp[i][j+jump] += dp[i][j]


 */

public class boj1890_Jump {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[100][100];
        long[][] dp = new long[100][100];

        N = Integer.parseInt(br.readLine());

        String[] inputs ;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j]=Integer.parseInt(inputs[j]);
            }
        }
        dp[0][0]=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(dp[i][j]>0){
                    if(i==N-1 && j==N-1){ break; }  // 도착했다면 arr[N-1][N-1]은 0이므로 같은 칸에서 계속 돌게됨
                    if(arr[i][j]==0){ continue; }   // 도착 안했고, jump 가 0 인경우는 탐색할 필요 x
                    int jump = arr[i][j];
                    if(isRange(i+jump, j)){ dp[i+jump][j]+=dp[i][j]; }
                    if(isRange(i, j+jump)){ dp[i][j+jump]+=dp[i][j]; }
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
    static boolean isRange(int y,int x){ return 0<= y && y<N && 0<=x && x<N; }
}
