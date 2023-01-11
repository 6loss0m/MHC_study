package BOJ.PS_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    예제3번을 보고 최소로 짓는 울타리문제가 아니란것을 알게되었습니다.
    즉, 늑대와 양만 서로 만나지않는다면 울타리를 어떻게 지어도 상관없는 문제입니다.

    아이디어
    처음엔 모든 늑대부터 bfs 탐색을 하며 양과만나는 경우 펜스를 설치하려했으나
    최소문제가 아니기때문에 오히려 모든 칸을 방문하는 탐색은 효율적이지 않다고 판단했습니다.

    그래서 모든 양 주변에 울타리를 세울 수 있는 만큼 세우는 방식으로 생각해보았습니다.
    1. 모든 양을 찾아 동서남북에 '.' 이 있다면 D 로 바꾸어줍니다
    2. 모든 양을 찾아 동서남북에 'W' 이 있다면 정답은 0 이 됩니다.

    2번조건에 걸리지않는다면 1을 출력하고 맵을 출력합니다.

 */

public class WolfAndSheep {
    static char[][] map;
    static boolean isFail=false;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];

        for(int i=0;i<R;i++){
            String in = br.readLine();
            for(int j=0;j<C;j++){
                map[i][j]=in.charAt(j);
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]=='S'){ setFence(i,j);}     // 모든 양을 찾아 울타리를 지어줍니다.
                if(isFail){ System.out.println(0); return; }
            }
        }
        System.out.println(1);
        print();
    }
    static void print(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void setFence(int r,int c){
        for(int i=0;i<4;i++){
            int nr = dr[i]+r;
            int nc = dc[i]+c;
            if(isRange(nr,nc)){
                if(map[nr][nc]=='W'){ isFail = true; return;}   // 늑대가있다면 fail
                if(map[nr][nc]=='.'){ map[nr][nc]='D';}
            }
        }

    }
    static boolean isRange(int r,int c){return 0<=r && r<R && 0<=c &&c<C;}
}
