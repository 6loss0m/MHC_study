package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/*
    가장 먼 노드 둘을 고르는 방법은
    1. 한 노드(x)를 기준으로 가장 먼 노드를 구합니다.  (A)
    2. 구한 노드에서 가장 먼 노드를 구합니다.      (B)
    A-B 가 가장 먼 노드입니다.

    한 노드를 기준으로 가장 먼 노드를 구하는 방법은
    탐색을 통하여 각각의 거리만큼을 계속 늘려주며 최대값을 구하면됩니다.

    dfs를 사용하여 탐색하였습니다.

 */

public class boj1167_TreeLength {
    static ArrayList<Edge>[] tree = new ArrayList[100001];
    static int[] visit = new int[100001];
    static int maxDist = Integer.MIN_VALUE;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int V = Integer.parseInt(br.readLine());

        for(int i=0;i<V; i++){
            input=br.readLine().split(" ");
            int len = input.length-1;
            for(int j=1;j<len;j+=2){
                int from=Integer.parseInt(input[0]);
                int to=Integer.parseInt(input[j]);
                int dist=Integer.parseInt(input[j+1]);

                if(tree[from]==null){ tree[from]=new ArrayList<>(); }
                tree[from].add(new Edge(to,dist));
            }
        }
        dfs(1,0);   // x 노드를 기준으로 가장 먼 노드를 구합니다. A
        Arrays.fill(visit,0,V+1,0);
        dfs(target,0);  // A 기준으로 가장 먼노드를 구해주면 그 거리가 곧 지름이 됩니다.
        System.out.println(maxDist);
    }
    static void dfs(int now, int dist){
        visit[now]=1;
        if(maxDist<dist){       // 여태까지 지나온 dist 가 최대값이라면
            maxDist = dist;     // 최대값을 갱신해 주고
            target=now;         // 가장 먼 노드를 구합니다.
        }

        for(Edge edge: tree[now]){
            if(visit[edge.next]==0){ dfs(edge.next,dist+ edge.dist); }  // 탐색을하며 거쳐온 노드들의 거리를 더해줍니다.
        }
    }
    static class Edge{
        int next;
        int dist;

        public Edge(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }
}