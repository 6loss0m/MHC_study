package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
    문제는 크게 두 가지로 나누어 볼 수있습니다.
    1. 섬 구분하기
    2. 섬에서 섬까지의 최소거리

    첫번째, 문제는
        - 각섬을 구분하기위해 동서남북 네 방향으로 dfs 탐색을 통하면 해결할 수 있습니다.

    두번쨰, 문제는
        - 모든 땅을 돌면서 첫번쨰 방법의 결과인 각 섬번호를 이용하여 자기자신 섬을 제외한 다른섬과의 최소거리를 구합니다.
        - 최소거리를 구하기위해 bfs 를 사용합니다.
        - 이미 갔던 길은 방문 처리를 하여 메모리 초과를 방지합니다.

 */

public class boj2146_Bridge {
    static int[][] map = new int[100][100];
    static int[][] Island = new int[100][100];
    static int[][] visit = new int[100][100];
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0;i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0;j<N;j++){ map[i][j]=Integer.parseInt(input[j]); }
        }
        int num = 1;
        for(int i=0;i<N; i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && Island[i][j]==0){ dfs(j,i,num++); }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0;j<N; j++){
                if(map[i][j]!=0){
                    int dist = bfs(j,i);
                    for(int k=0; k<N;k++){ Arrays.fill(visit[k],0,N,0); }
                    if(dist!=-1){ min = Math.min(min,dist); }
                }
            }
        }
        System.out.println(min-1);
    }
    static void dfs(int x,int y,int num){   //각 섬 구분하여 번호 매기기
        Island[y][x]=num;
        for(int i=0; i<4; i++){
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(isRange(nx,ny) && Island[ny][nx]==0 && map[ny][nx]==1){ dfs(nx,ny,num); }
        }
    }
    static int bfs(int x, int y){
        queue.add(new int[]{x,y,0});
        visit[y][x]=1;
        int nx,ny,nDist;
        int[] tmp;
        while (!queue.isEmpty()){
            tmp = queue.poll();
            if(Island[tmp[1]][tmp[0]] > 0 && Island[y][x]!=Island[tmp[1]][tmp[0]]){     // 섬 번호가 존재하고 = 땅이고,
                queue.clear();                                                          // 시작한 좌표와 도착한 곳이 다른 섬이라면
                return tmp[2];                                                          // 최소거리를 구했으므로 큐를 초기화 하고 최소거리를 리턴합니다.
            }
            for(int i=0;i<4;i++){
                nx = tmp[0]+dx[i];
                ny = tmp[1]+dy[i];
                nDist = tmp[2];
                if(isRange(nx,ny) && Island[y][x]!=Island[ny][nx] && visit[ny][nx]==0){ // 같은 섬이 아니고, 아직 방문하지 않았다면
                    visit[ny][nx]=1;                                                    // 방문처리를 해주고
                    queue.add(new int[]{nx,ny,nDist+1});                                // 큐에 거리+1 을하여 넣습니다.
                }
            }
        }
        return -1;
    }
    static boolean isRange(int x, int y){ return 0<=x&&x<N && 0<=y&&y<N; }
}
