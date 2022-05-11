package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
    1167 문제와 같은 문제입니다.
    크게 두 부분으로 나누어서 보면
    1. 임의의 노드(x) 에서 가장 먼 노드를 구합니다. A
    2. A에서 가장 먼 노드를 구합니다. B
    A-B 는 가장 먼 노드가 됩니다.
    즉, A-B 가 트리의 지름이 됩니다.

    dfs 탐색을 통해 거쳐가는 모든 간선의 가중치를 계산합니다.
    가장 가중치가 높은 노드를 구합니다.

 */


public class boj1967_TreeLength2 {
    static ArrayList<Edge>[] tree = new ArrayList[10001];
    static int[] visit = new int[10001];
    static int maxDist = Integer.MIN_VALUE;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        if(N==1){ System.out.println(0); return; }  // 99% 에서 null point 예외가 뜨는 이유..
                                                    // 입력이 1부터 시작하므로, 노드가 한개라면 최대 지름은 0이 됩니다.

        for(int i=1;i<N; i++){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            if(tree[from]==null){tree[from]=new ArrayList<>();}
            tree[from].add(new Edge(to,cost));
            if(tree[to]==null){tree[to]=new ArrayList<>();}
            tree[to].add(new Edge(from,cost));

        }
        dfs(1,0);   // 임의노드 x 에서 가장 먼 노드를 구합니다. target
        Arrays.fill(visit,0,N+1,0);
        dfs(target,0);  // target 에서 가장 먼 노드를 구합니다.
        System.out.println(maxDist);
    }

    static void dfs(int n, int cost){
        visit[n]=1;
        if(cost>maxDist){   // 간선을 지나오며 계산한 cost 가 최대값일 떄
            maxDist=cost;
            target=n;       // target 이 가장 먼 노드가 됩니다.
        }
        for(Edge edge :tree[n]){
            if(visit[edge.to]==0){ dfs(edge.to ,edge.cost + cost); }    // dfs 를 탐색하며 cost 를 계산합니다.
        }
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
