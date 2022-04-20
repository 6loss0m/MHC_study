package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    dfs 와 bfs 를 구현하면됩니다.
    그래프를 표현하는 방법은
    인접행렬 과 인접리스트가 있습니다.
    순회 시 시간복잡도는 인접행렬이 더 높습니다.

    이번엔 인접행렬을 사용하여 풀이하였습니다.

 */

public class boj1260_DFSBFS {
    static StringBuffer sb = new StringBuffer();
    static int[][] map = new int[1001][1001];
    static int[] visit = new int[1001];
    static int N,M,V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            map[from][to] = 1;
            map[to][from] = 1;
        }
        dfs(V);
        sb.append("\n");

        Arrays.fill(visit,0);
        bfs(V);
        System.out.print(sb);
    }

    public static void dfs(int v){
        visit[v]=1;
        sb.append(v).append(" ");
        for(int i=1; i<=N; i++){
            if(map[v][i]==1 && visit[i]!=1){ dfs(i); }
        }
    }

    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v]=1;

        while (!q.isEmpty()){
            v = q.poll();
            sb.append(v).append(" ");
            for(int i=1; i<=N; i++){
                if(map[v][i]==1 && visit[i]!=1){
                    q.offer(i);
                    visit[i]=1;
                }
            }
        }
    }
}