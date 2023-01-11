package BOJ.PS_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    0번째 줄에서 무조건 전류가 시작되므로 탐색은 0번째 줄부터 시작하면됩니다.
    탐색은 bfs,dfs 모두 상관없습니다.
    하지만 최소값을 구하는 문제가 아니고 전류가 흐르는지를 판단하는 문제이기때문에 dfs 가 효율적이라고 생각합니다.

    flag 를 두어 이미 전류가 흐를수있다면 더이상 탐색하지 않습니다.

    아이디어
    1. 0번째 줄부터 dfs 탐색을 합니다.
    2. 탐색을하다가 N-1 번째 줄에 도착한다면 전류가 안쪽까지 닿은것이므로 더이상 탐색할 필요가없습니다.



 */

public class Penetration {
    static int[][] map;
    static int N;
    static int M;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];

        for(int i=0;i<N;i++){
            String in = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=in.charAt(j)-'0';
            }
        }

        for(int i=0;i<M;i++){
            if(flag){ break; }                      // 이미 전류가 흐르므로
            if(map[0][i]==0){ dfs(0,i); }
        }

        if(flag){ System.out.println("YES"); return;}
        System.out.println("NO");
    }

    static void dfs(int y,int x){

        if(map[y][x]==-1){ return; }        // 0: 방문x / 1:벽 / -1: 이미방문
        if(y==N-1){ flag=true; }             // 안쪽까지 닿았다면 flag 를 바꿔줍니다.
        if(flag){ return; }                  // 더이상 탐색x

        map[y][x]=-1;                       // 방문처리
        for(int i=0;i<4;i++){
            int ny = dy[i]+y;
            int nx = dx[i]+x;
            if(0<=ny && ny<N && 0<=nx && nx<M){
                if(map[ny][nx]==0){ dfs(ny,nx); }
            }
        }
    }

}
