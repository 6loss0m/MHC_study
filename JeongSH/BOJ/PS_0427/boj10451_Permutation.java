package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    dfs 를 이용하여 하나의 정점에서 연결된 모든 정점을 방문합니다.
    방문할수 없는 노드는 다른 그룹이기때문에,
    카운트를 하나 늘려주고
    다음 정점부터 탐색을 합니다.

 */

public class boj10451_Permutation {
    static int[][] graph = new int[1001][1];    // 모든 노드는 최대 1개의 간선을 가지기 때문에
    static int[] visit = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        String[] input;

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");

            for(int i=0; i<N; i++){
                int to = Integer.parseInt(input[i]);
                graph[i+1][0]=to;
                visit[i+1]=0;               // 방문 초기화
            }

            int ret = 0;
            for(int i=1; i<=N; i++) {
                if(visit[i]==0) { ret+=1; dfs(i); }     // 방문하지 않은 노드가있다면 방문합니다.
            }
            sb.append(ret).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int v){
        if(visit[v]==1){return;}    // 이미 방문했다면 return
        visit[v]=1;
        if(graph[v][0]!=0){ dfs(graph[v][0]);}  // 연결된 간선이 있다면
    }
}
