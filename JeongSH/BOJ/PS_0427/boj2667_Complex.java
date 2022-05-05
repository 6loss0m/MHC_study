package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    dfs 로 풀이해보았습니다.
    4방향으로 연결된 노드는 하나의 단지를 구성하므로 dfs로 4방향을 검사합니다.
    visit[][] 으로 방문을 검사하고
    complex[] 로 각 단지의 갯수를 세어줍니다.

    문제풀이
    1. 아파트가 존재하고, 아직 방분하지않았다면 새로운 단지 번호를 부여합니다.
    2. 새 단지번호로 dfs를 탐색하며 complex[단지번호] 를 1씩 증가시켜줍니다.
    3. 더이상 연결된 아파트가 없다면 단지 번호를 1 증가 시키고 1번으로 돌아갑니다.

    문제는 다 풀어놓고 마지막에 헤맨 부분.
    - sort(arr[], start , end)
        이 메서드는 start = 시작인덱스 / end = 끝인덱스+1 입니다.
        주의점! end = 끝인덱스+1 ....

 */

public class boj2667_Complex{
    static int[][] map = new int[25][25];
    static int[][] visit = new int[25][25];
    static int[] complex = new int[314];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[] input;
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            input=br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j]=input[j]-'0';
            }
        }
        int num=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1 && visit[i][j]==0){
                    dfs(j,i,num+=1);
                }
            }
        }
        Arrays.sort(complex,1,num+1);   // 끝인덱스+1
        sb.append(num).append("\n");
        for(int i=1; i<=num; i++){
            sb.append(complex[i]).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int nowX, int nowY, int num){
        visit[nowY][nowX] = 1;
        complex[num]+=1;
        for(int d=0; d<4; d++){
            int nextX = dx[d]+ nowX;
            int nextY = dy[d]+ nowY;
            if(isRange(nextX,nextY) && map[nextY][nextX]==1 && visit[nextY][nextX]==0){
                dfs(nextX,nextY,num);
            }
        }
    }
    static boolean isRange(int x,int y){
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
