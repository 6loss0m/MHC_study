
/*

    BFS 로 풀어보았습니다.
    BFS 는 최단거리를 보장하기 때문에, DFS 보다 BFS 로 푸는게 더 맞는거같습니다.
    한 칸 이동할 때 마다 이전 칸에서 움직인 거리를 가져와 이동하는 칸에 +1 하여 최신화 합니다.
    dx, dy 는 동서남북 이동을 위한 배열이며,
    visit 은 방문 여부를 판단합니다.
    maps 배열에 움직인 횟수를 적어놓았기 때문에 도착지점을 확인하면 최단거리 이동 값이 들어가게 됩니다.
    만약 maps 배열의 도착지점이 1 인 경우는 도착점에 도착하지 못한것 이기때문에 -1 을 반환합니다.

    시간복잡도: O(V^2)

 */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortest {
    static int[] dx = {1,-1,0,0}; // 동,서,남,북 이동을 위한 배열
    static int[] dy = {0,0,1,-1}; // 동,서,남,북
    static boolean[][] visit;

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String args[]){
        System.out.println(bfs(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(bfs(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));

    }

    public static int bfs (int[][] maps){
        visit = new boolean[maps.length][maps[0].length];               // 방문을 체크할 boolean 배열
        for(int i=0; i<visit.length; i++)
            Arrays.fill(visit[i],false);                            // false 로 초기화

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        visit[0][0]=true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<dx.length; i++){
                int nx = node.x+dx[i];
                int ny = node.y+dy[i];
                if(nx>=0 && ny>=0 && nx < maps[0].length && ny < maps.length && maps[ny][nx]!=0 && visit[ny][nx]==false){   // x,y가 양수이며, 범위를 벗어나지않고,
                    maps[ny][nx]=maps[node.y][node.x]+1;                                                                    // 0(막힘)인 곳이 아니며, 방문하지 않았다면
                    visit[ny][nx] = true;                                                                                   // 이전 움직인 거리에서 +1
                    queue.add(new Node(nx,ny));                                                                             // 방문을 최신화하고 큐에 넣어줍니다.
                }
            }
        }
        if(maps[maps.length-1][maps[0].length-1] ==1){return -1;}                                                           // 도착지점의 인자가 1 이면 길이 없는 것
        return maps[maps.length-1][maps[0].length-1];                                                                       // 도착지점이 1이 아니라면 움직인 횟수를 반환.
    }
}
