package BOJ.PS_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*

    그래프 문제입니다.
    결국 1번 컴퓨터와 연결된 그래프의 노드의 수를 구하는 문제라
    dfs 탐색을 하던 bfs 탐색을 하던 상관없습니다.

    저는 구현이 편한 재귀식으로 dfs 탐색을 구현했습니다.

 */

public class Virus {
    static ArrayList<Integer>[] graph;
    static int N;
    static boolean[] visit;
    static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visit = new boolean[N+1];

        for(int i=0;i<M;i++){
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            if(graph[from]==null){ graph[from]= new ArrayList<>(); }
            if(graph[to]==null){ graph[to]= new ArrayList<>(); }
            graph[from].add(to);
            graph[to].add(from);
        }
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int now){
        visit[now] = true;
        for(Integer next : graph[now]){
            if(!visit[next]){ cnt++; dfs(next); }
        }
    }
}
