package CodeChallenge3;

import java.util.ArrayList;
import java.util.Arrays;
/*
    난이도에 비해 어려운 문제라고 생각합니다.

    1. 각 칸마다 네 방향을 체크할 visit[][][] 배열을 만듭니다.
    -> visit[][][4]

    2. 각각의 렌즈에서 동서남북으로 출발하여 이동거리를 파악해 줍니다.
        무조건 사이클이 생기기 때문에 한번이라도 방문했던 곳은 다른 사이클에 포함될수 없습니다.

    3. 들어온방향에서 L,R 를 잘 생각하여 다음 방향을 정합니다.
        R: 북동남서 -> 서북동남
        L: 북동남서 -> 동남서북
        S 는 그대로 진행하면 되기때문에 생각하지않아도 됩니다.

    4. 배열의 크기를 넘으면 같은 열과 행의 마지막이나 처음으로 돌아가기 때문에
        x = (x+dx[d]+maxX)%maxX
        y = (x+dy[d]+maxY)%maxY 로 하면 됩니다.

    주의점
    자바는 dfs 탐색시 스택오버플로가 발생합니다.

 */

public class Light {
    static boolean[][][] visit;
    static char[][] dir;
    static int cost =0;
    // 북동남서
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int maxX;
    static int maxY;

    public static void main(String[] args) {
        String[] grid = {"S"};
        maxY = grid.length;
        maxX = grid[0].length();
        dir = new char[maxY][maxX];
        visit = new boolean[maxY][maxX][4];
        for(int i=0;i<maxY;i++){
            for(int j=0;j<maxX;j++){
                dir[i][j]=grid[i].charAt(j);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<maxY;i++){
            for(int j=0; j<maxX;j++){
                for(int k=0; k<4; k++){
                    if(!visit[i][j][k]){
                        cost=0;
                        go(j,i,k);
                        list.add(cost);
                    }
                }
            }
        }
        int[] ret = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(ret);
        System.out.println(Arrays.toString(ret));
    }
    // 북 동 남 서
    // 0 1  2 3
    static void go(int x, int y, int d){
        while (true){
            if(visit[y][x][d]){break;}
            visit[y][x][d]=true;
            cost+=1;
            if(dir[y][x]=='R'){
                // 북동남서 -> 서북동남
                // 0123  -> 3012
                d = d == 0 ? 3:d-1;
            }
            if(dir[y][x]=='L'){
                // 북동남서 -> 동남서북
                // 0123 ->   1230
                d = d == 3 ? 0 : d+1;
            }
            x=(x+dx[d]+maxX)%maxX;
            y=(y+dy[d]+maxY)%maxY;
        }
    }

}
