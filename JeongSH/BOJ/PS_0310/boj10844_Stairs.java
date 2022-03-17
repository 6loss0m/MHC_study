package BOJ.PS_0310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제접근
    bottom-up 방식으로 접근하였습니다.
    ex) 길이가 2이고, 끝자리가 3으로 끝 날 경우
    : (3-1)3,(3+1)3 -> 23, 43
    [(n-1)][n]  or [(n+1)][n] 입니다.

    점화식.
    N-1 번째 자리 숫자는 N번 째 자리의 숫자의 -1,+1 입니다.
    즉, 마지막자리의 숫자가 무엇인지가 중요하기 때문에

    dp[N][k] : 길이가 N이고, k 로 끝나는 계단 수의 갯수.
    dp[N][k] = dp[N-1][k-1] + dp[N-1][k+1]

    하지만, 마지막 자리가 0로 끝날 경우 마지막 전 자리의 숫자는 1이 와야합니다.
    또, 9로 끝날 경우 반드시 8로 와야합니다.


 */


public class boj10844_Stairs {
    static final long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long [101][10];
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<10; i++){ dp[1][i]=1; }  // 1~9 까지는 모두 계단 수

        for(int i=2; i<N+1; i++){
            for(int j=0; j<10; j++){
                if(j==0) { dp[i][0]=dp[i-1][1]%MOD; }         // 뒷자리가 0이면 앞에 1밖에 올 수 없으므로.
                else if(j==9) { dp[i][9]=dp[i-1][8]%MOD; }        // 뒷자리가 9면 앞에 8만 와야 함.
                else{ dp[i][j]=(dp[i-1][j-1] + dp[i-1][j+1])%MOD; }
            }
        }
        long ret=0;
        for(int i=0; i<10; i++){ ret += dp[N][i]; }
        System.out.println(ret%MOD);
    }
}
