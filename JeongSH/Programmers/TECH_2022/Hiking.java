package TECH_2022;

import java.util.*;

/*
    먼저 dfs 완전탐색으로 풀이했지만, 해결하기 어려운 문제가 생겨
    해설을 보고 아이디어를 가져왔습니다.

    1. 등산로를 오르는 편도만 생각하면 된다.
        - 되돌아 나오는길은 같은 루트를 채용하면 intensity 가 늘지않기떄문에

    2. 각 intensity[] 를 두어 intensity[i] 는 i 노드까지가는 최소 intensity
        - 다익스트라 알고리즘을 사용

    3. summit , gate 는 양방향이 아니라 단방향으로 만들기.
        - 다른 summit 을 거치거나 다른 gate 를 거치면 안되기 때문에, gate 나 summit 은 단방향으로 설정해야 됨

    이를 통하여 bfs 를 돌며 intensity[] 를 채워나가고
    마지막에 summit 을 기준으로 intensity[] 의 최소값을 찾습니다.

 */


public class Hiking {
    public static void main(String[] args) {
        solution(7,new int[][]{{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}},new int[]{1},new int[]{2,3,4});

    }

    static ArrayList<Node>[] nodes;
    static HashMap<Integer,Integer> kind;
    static final int GATE = 1;
    static final int SUMMIT = 2;

    static public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        nodes = new ArrayList[n+1];
        kind= new HashMap<>();
        for(int g: gates){ kind.put(g,GATE); }
        for(int s: summits){ kind.put(s,SUMMIT); }
        for(int i=1;i<=n;i++){ nodes[i]=new ArrayList<>(); }

        for(int[] p: paths){
            int from = p[0];
            int to = p[1];
            int cost = p[2];
            // gate -> ? 단방향만 추가
            // ? -> summit 단방향만 추가
            if(kind.getOrDefault(from,-1)==GATE || kind.getOrDefault(to,-1)==SUMMIT){
                nodes[from].add(new Node(to,cost));
            }
//
//            // ? -> gate 경우는, gate -> ? 단방향으로 바꿔주기
//            // summit -> ? 경우, ? -> summit 단방향으로 바꿔주기
            else if(kind.getOrDefault(to,-1)==GATE || kind.getOrDefault(from,-1)==SUMMIT){
                nodes[to].add(new Node(from,cost));
            }
            else{
                nodes[to].add(new Node(from,cost));
                nodes[from].add(new Node(to,cost));
            }
        }
        return dijkstra(n,gates,summits);
    }

    static int[] dijkstra(int n, int[] gates, int[] summits){
        Queue<Node> q = new LinkedList<>();
        int[] intensity = new int[n+1];
        Arrays.fill(intensity,Integer.MAX_VALUE);

        for(int g: gates){
            q.add(new Node(g,0));
            intensity[g]=0;
        }

        while (!q.isEmpty()){
            Node now = q.poll();

            if(now.cost>intensity[now.to]){ continue; }

            for(Node next : nodes[now.to]){

                int cost = Math.max(intensity[now.to],next.cost);
                if(intensity[next.to] > cost){
                    intensity[next.to]=cost;
                    q.add(new Node(next.to,cost));
                }
            }
        }
        int idx = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for(int s: summits){
            if(intensity[s]<min){
                idx = s;
                min = intensity[s];
            }
        }
        return new int[]{idx,min};
    }

    static class Node{
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
