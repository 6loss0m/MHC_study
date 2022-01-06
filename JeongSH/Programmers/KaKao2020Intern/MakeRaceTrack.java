/**
 *
 *  처음에 2차원 배열로 풀이해봤는데 테스트케이스 2개를 통과 못하여
 *  3차원 배열을 사용해야 한다는 글을 읽고 수정하였습니다.
 *  공통 아이디어:
 *      1. BFS 탐색을하며, 기존과 같은 방향으로 가면 +100 을 기존과 다른방향이면 +600 을 해주었습니다.
 *          - 기존과 다른방향은 커브이기때문에.
 *          - 600 을 해준 이유는 문제 제시사항을 읽어보니 500이 아닌 600을 해줘야함을 알게됨.
 *   기존 아이디어:
 *      1. board 를 탐색하며 board 의 값이 0이거나 기존의 값보다 적다면 최신화 합니다.
 *   문제점:
 *      1. ex) ...[2][3][4]  [5]  [6][7][8]      직진 비용: 1  커브 비용: 5
 *             ... ◼ ◼ ◼   [11]  ◼ ◼ ◼
 *             ...[5][6][7] [8/12] ◼ ◼ ◼
 *             ...◼ ◼ ◼   [14/13] ◼ ◼ ◼
 *             해당 경우 기존 아이디어는 [8/12] 값이 8로 최신화 됩니다.
 *             하지만 바로 밑인 [14/13] 으로 가는 경우 위에서의 최소값이 다음칸의 최소값을 보장할 수 없습니다.
 *
 *      2. 개선 : 3차원 배열을 사용하여 방향 별로 비용 계산.
 *          ...[2][3][4]  [5] [6][7][8]  동쪽방향       ...[0][0][0]  [0]  [0][0][0]  남쪽방향
 *          ... ◼ ◼ ◼   [0] ◼ ◼ ◼                   ... ◼ ◼ ◼  [11]  ◼ ◼ ◼
 *          ...[5][6][7] [8] ◼ ◼ ◼                   ...[0][0][0] [12] ◼ ◼ ◼
 *          ...◼ ◼ ◼   [0] ◼ ◼ ◼                    ...◼ ◼ ◼ [14/13] ◼ ◼ ◼
 *          [14/13] 은 13이 최소값이므로 13을 저장.
 *
 *   추가 아이디어:
 *      1. 3차원 배열을 만들어 줍니다. [방향][y][x]
 *      2. 방향 별로 3차원 배열을 최신화 합니다.
 *      3. bfs 의 모든 노드를 탐색한 뒤, 도착지에서 방향 별로 최소값을 비교합니다.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class MakeRaceTrack {
    static int[] dx= {1,-1,0,0};    // 동서남북
    static int[] dy= {0,0,1,-1};    // 동서남북
    public static void main(String args[]){
//        int[][] s3={{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
//        System.out.println(solution(s3)); // 2100
        int[][] s4={{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        System.out.println(solution(s4)); //3200
    }

    public static int solution(int[][] board){
        int answer =Integer.MAX_VALUE;
        int n=board.length;
        int[][][] dirCost = new int [4][n][n];

        Queue<Road> q = new LinkedList<>();
        q.add(new Road(0,0,-1,0));      // 시작지점에서는 어느 방향을 가도 직선이기 때문에 유니크한 방향 설정.

        while(!q.isEmpty()){
            Road r = q.poll();
            for(int i=0; i<4; i++){
                int nx= r.x+ dx[i];
                int ny= r.y+ dy[i];
                int nextCost = r.cost;

                if(isRange(nx,ny,n) && board[ny][nx]!=1){   // 갈 수 있는 곳이라면
                    if(r.dir == i || r.dir == -1){nextCost += 100;}     // 기존의 방향과 지금 방향이 같거나, -1(시작지점) 일경우는 직진.
                    else{nextCost +=600;}                               // 커브

                    if(dirCost[i][ny][nx]==0 || dirCost[i][ny][nx]>nextCost){   // 해당 방향으로 첫방문이거나, 해당 방향으로 방문 시 기존의 값보다 작다면
                        q.add(new Road(nx,ny,i,nextCost));                      // 큐에 넣어줍니다.
                        dirCost[i][ny][nx]=nextCost;                            // 최신화
                    }
                }
            }
        }
        for(int i=0; i<4; i++){                                         // 도착지점은 4방향으로 도착할 수 있으므로 마지막 좌표기준
            if(dirCost[i][n-1][n-1]!= 0){                               // 4방향을 보고, 0이 아닌 최소값을 구합니다.
                answer = Math.min(answer,dirCost[i][n-1][n-1]);         // 아 근데, 생각해보니 남쪽으로 내려오거나 동쪽으로 도착하는거 밖에 도착못하네 ..
            }
        }
//        for(int i=0; i<4; i++) {                                      // 이해를 돕는 출력 문.
//            for(int j=0; j<n; j++){
//                for(int k=0; k<n; k++){
//                    System.out.printf("%5d",dirCost[i][j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
        return answer;
    }
    public static class Road{
        int x;
        int y;
        int dir;
        int cost;

        public Road(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    static boolean isRange (int x,int y, int n) {
        if(0<=x && x<n && 0<=y && y<n){return true;}
        return false;
    }
}
