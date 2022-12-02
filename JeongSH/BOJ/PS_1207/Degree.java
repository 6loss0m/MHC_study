package BOJ.PS_1207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    트리탐색 문제입니다.
    두 노드사이의 거리 구하는 기본적인 문제입니다.
    탐색은 bfs,dfs 상관없습니다.
    저는 구현이 쉬운 재귀식으로 dfs 탐색을 구현하였습니다.

 */

public class Degree {
    static int N;
    static int startTarget;
    static int endTarget;
    static ArrayList<Integer>[] tree;
    static boolean[] visit;
    static int result = -1; // 두 노드가 연결되지않았다면 -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        startTarget = Integer.parseInt(input[0]);
        endTarget = Integer.parseInt(input[1]);

        tree = new ArrayList[N+1];
        visit = new boolean[N+1];

        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            if(tree[parent]==null){ tree[parent] = new ArrayList<>();}
            if(tree[child]==null){ tree[child] = new ArrayList<>();}
            tree[parent].add(child);
            tree[child].add(parent);
        }
        dfs(startTarget,0);
        System.out.println(result);
    }
    static void dfs(int now, int degree){
        visit[now] = true;
        if(now == endTarget){ result=degree; }  // 타켓 노드를 찾았다면 촌수를 저장합니다.
        for(Integer next : tree[now]){
            if(!visit[next]){ dfs(next,degree+1); }
        }
    }
}
