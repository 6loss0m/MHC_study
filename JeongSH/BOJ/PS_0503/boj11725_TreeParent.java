package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    dfs 탐색을 합니다.

    현재 노드 now / 연결된 노드들 next
    탐색을하며 now 노드와 연결된 next 노드들의 부모를 now 노드로 저장합니다.
    parent[next]=now

 */

public class boj11725_TreeParent {
    static ArrayList<Integer>[] tree = new ArrayList[100001];
    static int[] parent = new int[100001];
    static int[] visit = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input;

        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<N; i++){
            input=br.readLine().split(" ");
            int from=Integer.parseInt(input[0]);
            int to=Integer.parseInt(input[1]);

            if(tree[from]==null){ tree[from] = new ArrayList<>(); }
            tree[from].add(to);
            if(tree[to]==null){ tree[to]=new ArrayList<>(); }
            tree[to].add(from);
        }
        dfs(1);
        for(int i=2;i<=N;i++){ sb.append(parent[i]).append("\n"); }
        System.out.print(sb);
    }
    static void dfs(int n){
        visit[n]=1;
        ArrayList<Integer> list = tree[n];
        for(int next: list){
            if(visit[next]==0){
                parent[next]=n;
                dfs(next);
            }
        }
    }
}
