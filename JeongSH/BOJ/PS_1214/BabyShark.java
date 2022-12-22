package BOJ.PS_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
    모든 상어와 가장 멀리떨어져있는 칸의 거리를 구하는 문제입니다.

    상어 위치가 주어지므로 각각 상어위치부터 bfs 탐색을 합니다.
    그러면 모든칸에 각각 상어와의 최소거리가 들어가기때문에
    가장 큰값을 찾으면 되는 문제입니다.

 */

public class BabyShark {
    // 12시부터 시계방향 탐색
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==1){ queue.add(new int[]{i,j,0}); }    // {y,x,dist}
            }
        }

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int dist = now[2];

            for(int i=0;i<8;i++){
                int ny = now[0]+dy[i];
                int nx = now[1]+dx[i];
                if(0<=ny&& ny<N && 0<=nx&& nx<M){
                    if(map[ny][nx]!=0 && map[ny][nx]<=dist+1){ continue; }  // 방문한적있고, 현재거리+1 보다 기존값이 작다면 탐색할 이유 x
                    if(map[ny][nx]==0){ map[ny][nx]=dist+1; }               // 방문한적없다면 현재거리 +1
                    else { map[ny][nx]=Math.min(map[ny][nx],dist+1); }      // 방문한적있고, 현재거이+1 보다 기존값이 큰경우 최소값으로 최신화 합니다.
                    queue.add(new int[]{ny,nx,dist+1});                     // 다음 방문을 위해 큐에 넣어줍니다.
                }
            }
        }

        int max=-1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(max<map[i][j]){ max=map[i][j]; }
            }
        }
        System.out.println(max);
    }
}
