package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    기준을 먼저 잡고 기준에 따라서
    재귀식으로 별을 찍습니다.
    N=24
    총 높이는 24 총 가로 길이는 47이 됩니다. (높이 N, 가로 2N - 1)
    가장 큰 삼각형은 나누어 보면 (N=24)
    1. 왼쪽 아래의 작은 삼각형 (N=12 일 경우 만들어지는 삼각형)
    2. 오른쪽 아래의 작은 삼각형 (N=12 일 경우 만들어지는 삼각형)
    3. 가운데 위의 작은 삼각형 (N=12 일 경우 만들어지는 삼각형)

    이렇게 세 개로 볼 수 있습니다.
    이 삼각형들도 또 나누어보면 n/2 의 삼각형들로 이루어져있습니다.
    ...
    ..
    가장 작은 삼각형은 N=3 의 삼각형으로 이루어져있습니다.

    저는 가장 큰 삼각형의 왼쪽 아래의 좌표를 기준으로 재귀식으로 구현하였습니다.

 */

public class boj2448_Star {
    static int[][] stars = new int[3072][6144];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        draw(0,N-1,N);

        for(int i=0;i<N; i++){
            for(int j=0; j<2*N; j++){
                if(stars[i][j]==1){ sb.append("*"); }
                else{ sb.append(" "); }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void draw(int x, int y, int n){  // 별의 가장 왼쪽 아래를 기준으로 그리기
        if(n == 3){ // 가장 작은 삼각형
            for(int i=0; i<5; i++){ stars[y][x+i]=1;}   // 삼각형의 가장 아랫 줄
            stars[y-1][x+1]=1;                          // 삼각형의 중간 줄
            stars[y-1][x+3]=1;                          // 삼각형의 중간 줄
            stars[y-2][x+2]=1;                          // 삼각형의 가장 윗 줄
            return;
        }
        draw(x,y,n/2);  //왼쪽아래
        draw(x+n,y,n/2);  // 오른쪽아래
        draw(x+n/2,y-n/2,n/2);    // 가운데 위
    }
}
