package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    dfs 를 이용하여 색깔칠하기 유형문제와 비슷하게 풀이하였습니다.
    주의할 점은 예외적인 상황을 처리해 주는 부분 입니다.

    알고리즘
    두 색으로 인접한 노드에 다른 색을 색칠하는 문제의 유형으로 보고 풀이하였습니다.
    - dfs 탐색을 하여 연결된 노드를 방문합니다.
        현재 방문한 노드의 색깔과 다음에 방문할 노드의 색깔이 같으면 이 그래프는 이진그래프가 아닙니다.
        0 : 아직 방문하지않은상태
        1 : 1 색상
        -1 : -1 색상

    - 그래프의 그룹이 여러개 있을경우.
        문제의 제시조건을 충족한다면 맞습니다.
        ex) 1-2   3-4  5-6  이 연결된 그래프가 있을경우 각 그룹은 해당 조건을 만족하므로 YES 입니다.


 */

public class boj1707_BipartiteGraph {
    static ArrayList<Integer>[] map;
    static int[] visit;
    static boolean isTrue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int K = Integer.parseInt(br.readLine());
        int V,E ; // 정점, 간선

        for (int t = 0; t < K; t++) {
            String[] input = br.readLine().split(" ");
            V = Integer.parseInt(input[0]);
            E = Integer.parseInt(input[1]);
            map = new ArrayList[V+1];
            visit = new int[V+1];
            isTrue = true;
            for (int i = 1; i <= V ; i++) {map[i] = new ArrayList<>();}

            // 각 테스트 케이스 입력
            for(int e=0; e<E; e++){
                input = br.readLine().split(" ");
                int from = Integer.parseInt(input[0]);
                int to = Integer.parseInt(input[1]);

                map[from].add(to);
                map[to].add(from);
            }

            for(int v=1; v<V; v++) { if(visit[v]==0) dfs(v,1); }    // 그래프내에 여러 그룹이 있을 수 있으므로 모든 정점을 확인.
            sb.append(isTrue ? "YES":"NO").append("\n");
        }
        System.out.print(sb);

    }
    static void dfs(int v, int check){
        if(!isTrue) { return; }
        visit[v]=check;

        for(int n : map[v]){
            if(visit[n] == check) { isTrue = false; break; }    // 다음 방문할 노드가 현재 노드와 같은 색이라면 문제의 조건과 틀리므로 return
            if(visit[n] == 0) {dfs(n,check*-1);}         // 다음 방문할 노드를 아직 방문하지 않았다면 현재 색상과 다른 색으로 방문합니다.
        }
    }
}
