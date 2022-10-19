package TECH_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
    dfs 문제점.
    그리디하게 동작하게 하더라도 예외적인 부분이 있기때문에...
          3    1
         -> 2 ->
gate  1          4  summit
         -> 3 ->
         1    4

      경우 intensity 가 4가 됨.

      이를 방지하고자 백트래킹을 사용하면 시간초과 발생

 */

public class HikingTrail_dfs_Fail {

    public static void main(String[] args) {
        int n = 6;
        int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates ={1,3};
        int[] summits = {5};
//        System.out.println(Arrays.toString(solution(n,paths,gates,summits)));

        paths = new int[][]{{1, 2, 5}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
        n = 7;
        gates=new int[]{3,7};
        summits = new int[] {1,5};

        System.out.println(Arrays.toString(solution(n,paths,gates,summits)));
    }


    static boolean[] visit;
    static ArrayList<Edge>[] edge;
    static int[] nodes;
    static int N;
    static final int GATE = 1;
    static final int SUMMIT = 2;
    static int min= Integer.MAX_VALUE;
    static int minNum=Integer.MIN_VALUE;

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        visit = new boolean[N+1];
        edge = new ArrayList[N+1];
        nodes = new int[N+1];

        for(int i=0;i<N;i++){ nodes[i+1]=0; }
        for(int g : gates){ nodes[g] =GATE; }
        for(int s : summits){ nodes[s] = SUMMIT; }

        Arrays.sort(paths, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2]==o2[2]){ return o1[1]-o2[1]; }
                return o1[2]-o2[2];
            }
        });


        for(int[] p : paths){
            int from = p[0];
            int to = p[1];
            int cost = p[2];
            if(edge[from]==null){ edge[from]= new ArrayList<>(); }
            if(edge[to]==null){ edge[to]= new ArrayList<>(); }
            edge[from].add(new Edge(to, cost));
            edge[to].add(new Edge(from, cost));
        }

        for(int g :  gates){
            visit = new boolean[N+1];
            dfs(g,0);
        }
        int [] answer = {minNum,min};

        return answer;
    }

    static void dfs(int now, int maxCost){
        if(maxCost>0 && nodes[now]==GATE){ return; }
        if(maxCost>0 && nodes[now]==SUMMIT){
            if(maxCost<min){ min=maxCost; minNum = now; }
            else if(maxCost==min){ minNum=Math.min(minNum,now); }
            return;
        }

        visit[now]=true;

        for(Edge e : edge[now]){
            if(visit[e.to]){ continue; }
            if(min<e.cost){ continue; }
            dfs(e.to,Math.max(maxCost,e.cost));
            visit[e.to]=false;
        }
    }

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
