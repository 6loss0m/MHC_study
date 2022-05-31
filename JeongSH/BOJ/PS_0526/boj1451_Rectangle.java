package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    그리디 + 완전탐색..
    직사각형은 총 6개 경우로 자를 수 있습니다.
    1. 가로로 3등분
    2. 세로로 3등분
    3.  ┌─────┬────┐
        ├─────┤    │
        │     │    │
        └─────┴────┘
    4. 3번 좌우반전
    5.  ┌───┬─────┐
        ├───┴─────│
        │         │
        └─────────┘
    6. 5번 상하반전

    모두를 구해서 최대값을 구하면됩니다..

    계산의 편리를 위해서
    sum[N][M] = [0][0]~[0][M]
                ....
                [N][0]~[N][M]   까지의 합. 즉 [0][0] 부터 시작하는 크기 NxM 직사각형의 합.

 */

public class boj1451_Rectangle {
    static int N,M;
    static long[][] sum = new long[100][100];
    static long[][] arr = new long[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N=Integer.parseInt(input[0]);
        M=Integer.parseInt(input[1]);
        String str;
        for(int i=0;i<N;i++){
             str = br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        sum[0][0]=arr[0][0];
        for(int i=1; i<N; i++){ sum[i][0]= sum[i-1][0]+arr[i][0];}  // sum[N][M] 은 사각형 N x M 의 모든 합.
        for(int i=1; i<M; i++){ sum[0][i]= sum[0][i-1]+arr[0][i];}
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i==0 || j==0) continue;
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i][j];
            }
        }

        long ret = 0;

        // 가로로 3등분
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                long a = sum[i][M-1];
                long b = sum[j][M-1] - sum[i][M-1];
                long c = sum[N-1][M-1] - sum[j][M-1];
                ret = Math.max(ret,a*b*c);
            }
        }
        // 세로로 3등분
        for(int i=0;i<M;i++){
            for(int j= i+1; j<M; j++){
                long a = sum[N-1][i];
                long b = sum[N-1][j] - sum[N-1][i];
                long c = sum[N-1][M-1] - sum[N-1][j];
                ret = Math.max(ret,a*b*c);
            }
        }

        /*
            ┌─────┬─────┐
            │  a  │     │
            ├─────┤  c  │
            │  b  │     │
            └─────┴─────┘
        */
        for(int i=0; i<N-1; i++){   // N-1 인 이유는 b 도 1줄 이상을 보장하기위해..
            for(int j=0; j<M; j++){
                long a = sum[i][j];
                long b = sum[i][M-1]-sum[i][j];
                long c = sum[N-1][M-1] - sum[i][M-i];
                ret = Math.max(ret,a*b*c);
            }
        }
        for(int i=N-1; i>0;i--){
            for(int j=0; j<M; j++){
                long a = sum[N-1][j] - sum[i-1][j];
                long b = sum[N-1][M-1]-(sum[N-1][j]+sum[i-1][M-1])+sum[i-1][j];
                long c = sum[i-1][M-1];
                ret = Math.max(ret,a*b*c);
            }
        }
        /*
            ┌───┬─────┐
            ├───┴─────│
            │         │
            └─────────┘
         */
        for(int i=0; i<M-1; i++){
            for(int j=0; j<N; j++){
                long a = sum[j][i];
                long b= sum[N-1][i] - sum[j][i];
                long c = sum[N-1][M-1]-sum[N-1][i];
                ret = Math.max(ret,a*b*c);
            }
        }

        for(int i=M-1; i>0; i--){
            for(int j=0; j<N; j++){
                long a = sum[j][M-1]-sum[j][i-1];
                long b = sum[N-1][M-1]-(sum[j][M-1]+sum[N-1][i-1])+sum[j][i-1];
                long c= sum[N-1][i-1];
                ret = Math.max(ret,a*b*c);
            }
        }
        System.out.println(ret);
    }
}
