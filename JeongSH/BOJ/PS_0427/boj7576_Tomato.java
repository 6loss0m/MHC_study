package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj7576_Tomato {
    static int M,N;
    static int[][] box = new int[1000][1000];
    static int[][] date = new int[1000][1000];
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                box[i][j]=Integer.parseInt(input[j]);
            }
        }
        for(int i=0;i<N; i++){
            for(int j=0; j<M; j++){
                if(box[i][j]==1) {
                    bfs(j,i,1);
                }
            }
        }

        for(int i=0; i<N; i++){
            for (int j = 0; j < M; j++) {
                if(max<date[i][j]) {max = date[i][j];}
                if(date[i][j]==0 && box[i][j]==0) { System.out.println(-1); return; }
            }
        }
        System.out.println(max-1);
    }
    static void bfs(int nowX, int nowY, int day){
        q.offer(new int[]{nowX,nowY,day});
        date[nowY][nowX] = day;
        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nextX = now[0]+dx[i];
                int nextY = now[1]+dy[i];
                int nextDate = now[2]+1;
                if(isRange(nextX,nextY) && box[nextY][nextX]==0){
                    if(date[nextY][nextX]==0 || date[nextY][nextX]>nextDate){
                        date[nextY][nextX]=nextDate;
                        q.offer(new int[]{nextX,nextY,nextDate});
                    }
                }
            }
        }
    }
    static boolean isRange(int x,int y){ return 0<=x&&x<M && 0<=y&&y<N; }
}
