package BOJ.PS_0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
    일반적인 bfs 로 풀이하기 어려운 문제입니다.
    기본적인 bfs 는 도착지점까지 이동 칸 수(가중치)가 적은 길을 찾습니다.
    하지만 이 문제에서의 가중치는 이동 칸 수가 아닌 벽의 갯수입니다.

    여태 그래프 문제에서만 다익스트라 방식으로 접근을 했는데
    이런 배열문제에서도 다익스트라로 접근 할 수 있다는것을 알게되었습니다.

    각 칸은 동서남북 그래프 형식으로 연결되어있다고 생각하고,
    0,0 부터 가장 가중치가 적은 칸부터 연결해 나갑니다.
    우선순위 큐때문에 가장 가중치가 적은 길이 도착점에 먼저 도착하게됩니다.

 */

public class boj1261_AlgoSpot {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[100][100];
        int[][] dist = new int[100][100];
        PriorityQueue<Point> queue = new PriorityQueue<>();     // sum 기준 오름차순.

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        for(int i=0;i<M;i++){
            String in = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j]=in.charAt(j)-'0';
                dist[i][j]=INF;
            }
        }

        queue.add(new Point(0,0,0));
        dist[0][0]=0;
        while (!queue.isEmpty()){
            Point point = queue.poll();
            if(point.x==N-1 && point.y==M-1){break;}
            for(int i=0; i<4; i++){
                int nx = point.x+dx[i];
                int ny = point.y+dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    int nSum = point.sum + map[ny][nx];     // 가중치 + 다음칸의 가중치
                    if(dist[ny][nx]>nSum){                  // 기존의 가중치 보다 적다면
                        dist[ny][nx]=nSum;                  // 최신화
                        queue.add(new Point(nx,ny,nSum));
                    }
                }
            }
        }
        System.out.println(dist[M-1][N-1]);


    }
    static class Point implements Comparable<Point> {
        int x,y,sum;
        public Point(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        @Override
        public int compareTo(Point o) {
            return this.sum-o.sum;
        }
    }
}
