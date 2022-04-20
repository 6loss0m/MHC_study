package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    이번엔 인접리스트로 dfs 를 구현하여 사용하였습니다.
    풀이법은 하나의 정점을 기준으로 갈수있는 모든 정점을 방문한 뒤,
    아직 방문하지 않은 정점이 있다면 카운트를 하나 늘려주고 방문하지않은 정점을 기준으로
    탐색을 다시 시작합니다.

 */

public class boj11724_Connected {
    static ArrayList<Integer>[] map = new ArrayList[1001];
    static int[] visit = new int[1001];
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i=1; i<=N; i++) { map[i]=new ArrayList<>();}

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            map[from].add(to);
            map[to].add(from);
        }

        int ret = 0;
        for(int i=1; i<=N; i++){
            if(visit[i]!=1){ dfs(i); ret+=1;}
        }

        System.out.println(ret);

    }
    public static void dfs(int v){
        visit[v]=1;
        for(int n : map[v]){
            if(visit[n]!=1){ dfs(n); }
        }
    }
}
