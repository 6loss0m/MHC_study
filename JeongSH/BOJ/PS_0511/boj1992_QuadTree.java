package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    종이자르기 문제와 유사합니다.
    출력값이 무엇을 의미하는지 어려웠는데,
    모든 부분을 4등분하여 보았을때, 같으면 그 숫자를 적고 다르면
    또 4등분을 하여 같은 숫자들만 존재할때까지 자르는 방식입니다.

 */

public class boj1992_QuadTree {
    static int[][] map;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        String input;
        for(int i=0; i<N; i++){
            input= br.readLine();
            for(int j=0;j<N;j++){
                map[i][j]=input.charAt(j)-'0';
            }
        }
        bf(0,0,N);
        System.out.println(sb);
    }
    static void bf(int y,int x,int cur){
        int now = map[y][x];
        for(int i=y; i<cur+y; i++){
            for(int j=x; j<cur+x; j++){
                if(map[i][j]!=now){
                    sb.append("(");                          // 같지않다면 처음에 괄호를 출력해야합니다.
                    bf(y,x,cur/2);                      // 같지 않기 떄문에 4등분
                    bf(y,x+cur/2,cur/2);
                    bf(y+cur/2,x,cur/2);
                    bf(y+cur/2,x+cur/2,cur/2);
                    sb.append(")");                         // 4등분이 끝나면 괄호를 닫습니다.
                    return;
                }
            }
        }
        sb.append(now);                                     // 모든 숫자가 같다면 해당 칸은 now 로 압축할 수 있습니다.
    }
}
