package BOJ.PS_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*

    결국 리프노드에서 루트노드까지의 총 거리가 홀수이냐 짝수이냐에 따라 승패가 갈리게됩니다.

    아이디어
    모든 리프노드와 루트노드 까지의 거리를 구한 뒤,
    홀수면 성원이가 이기게 됩니다.
    짝수면 성원이가 지게 됩니다.

    리프노드의 level 구하기.
    1. 루트 노드에서 부터 dfs 로 depth 를 늘려가며 노드를 방문합니다.
    2. 방문한 노드의 간선이 하나밖에 존재하지않는다면 리프노드 입니다.


    + 문제를 제대로 읽자..
    YES(x) Yes(o)
    NO(x) No(o)
 */

public class boj15900_TreeEscape {
    static ArrayList<Integer>[] edge= new ArrayList[500001];
    static int[] visit = new int[500001];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N-1; i++) {
            String[] inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            if(edge[from]==null){ edge[from]= new ArrayList<>(); }
            if(edge[to]==null){ edge[to]= new ArrayList<>();}
            edge[from].add(to);
            edge[to].add(from);
        }
        dfs(1,0);
        System.out.println(cnt%2 == 1 ? "YES" : "NO");
    }

    static void dfs(int now, int depth){
        visit[now]=1;
        if(now != 1 && edge[now].size()==1){ cnt+= depth; } // 루트노드의 간선이 한 개만 존재하는 경우도 있기 때문에
        else{
            for(Integer next :edge[now]){
                if(visit[next]==0){ dfs(next, depth+1); }
            }
        }
    }
}
