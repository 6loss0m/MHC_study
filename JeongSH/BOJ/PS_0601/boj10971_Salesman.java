package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    dfs 와 백트래킹을 사용하여 풀이하였습니다.
    시작지점과 도착지점이 같은 곳이어야하고 모든 도시를 돌아야 하므로
    재귀를 빠져나오는 조건은
    start == now && N(도시의갯수) == depth(방문한 도시갯수)
    입니다.

    그리고, 다음에 방문할 도시의 코스트가 현재까지 구한 모든도시 방문코스트 보다 클 경우에는
    더이상 방문할 필요가 없으므로 돌지않습니다.

 */

public class boj10971_Salesman {
    static int[][] map = new int[10][10];
    static int[] visit = new int[10];
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j]=Integer.parseInt(input[j]);
            }
        }
        for(int i=0;i<N;i++){
            dfs(i,i,0,0);   // 임의의 도시부터 출발할수 있기때문에 모든 정점에서의 출발을 계산합니다.
        }
        System.out.println(min);
    }
    static void dfs(int start, int to, int depth, int sum){
        if(start==to && depth==N){ min = Math.min(sum,min); return;}    // 시작도시와 도착도시가 같아야하며, 모든 도시를 방문해야합니다.

        for(int i=0;i<N;i++){
            if(visit[i]==0 && map[to][i]!=0){
                visit[i]=1;
                sum+=map[to][i];
                if(min>sum){ dfs(start,i,depth+1,sum); }    // 여태까지 구한 최솟값보다 다음 방문코스트보다 크다면 계산할필요가 없습니다.
                visit[i]=0;                                        // 백트래킹
                sum-=map[to][i];
            }
        }
    }
}
