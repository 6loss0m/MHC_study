package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    dfs 로 탐색하였습니다.
    하나의 노드에서 8방향으로 갈수있는 곳을 탐색합니다.
    더이상 탐색 할 수 없다면, 아직 방문하지않은 다음 노드를 기준으로 연결된 섬을 탐색합니다.

    문제풀이
    1. 방문하지않은 노드에서 8방향으로 연결된 땅을 방문처리하며 탐색합니다.
        더이상 갈곳이 없다면 다음 노드에서부터 시작합니다.
    2. 다음 노드를 방문할 때도 아직 방문하지않고, 갈수있는 노드를 찾아 섬을 하나 늘리고
        1 번으로 되돌아갑니다.

 */

public class boj4963_Island {
    static int W,H;
    static int[][] map = new int[50][50];
    static int[][] visit = new int[50][50];
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,-1,-1,-1,0,1,1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String in;
        String[] input;
        while(!(in=br.readLine()).equals("0 0")){
            input = in.split(" ");
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);
            for(int i=0; i<H; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<W; j++){
                    map[i][j]=Integer.parseInt(input[j]);
                }
            }
            init();
            int cnt=0;
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j]==1 && visit[i][j]==0){
                        cnt+=1;
                        dfs(j,i);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int nowX, int nowY){
        visit[nowY][nowX]=1;
        for(int i=0; i<8;i++){
            int nextX = dx[i]+nowX;
            int nextY = dy[i]+nowY;
            if(isRange(nextX,nextY) && visit[nextY][nextX]==0 && map[nextY][nextX]==1){
                dfs(nextX,nextY);
            }
        }
    }
    static boolean isRange(int x, int y){ return 0<=x && x<W && 0<=y && y<H; }
    static void init(){
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){ visit[i][j]=0; }
        }
    }
}
