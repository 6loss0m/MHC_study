package BLIND_2021;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
    문제 아이디어 접근
    시작노드에서 다익스트라 알고리즘을 사용하여 모든 노드의 최소거리를 구한 뒤,
    임의의 노드 C 까지 합승을 한 다고 가정. (C는 출발 노드가 될 수 있음.)
    S - C - A
          - B
    C 에서 다익스트라 알고리즘으로 모든 노드의 최소거리를 구한다.

    * 임의의 C를 정하는 반복은 노드 갯수만큼이므로 N,
    * C 에서 모든 노드의 최소거리를 구하면 Nlog(N) // 우선순위큐를 사용하는 다익스트라 알고리즘 시간복잡도

    시간복잡도 O(n^2log(n))
    O(n^3) > O(n^2log(n)) 고,
    n=200, n^3=8000000 이기때문에 효율성을 통과한다고 생각하고 풀이함.



    +
    풀고나서 다른사람의 풀이를 보니
    S,A,B 세번의 다익스트라 알고리즘을 사용하여 각각의 최소 비용을 구하고
    반복문을 통해 임의의 노드 C를 선택하여 값을 계산하는 방법을 알게됨.
    시간복잡도 Nlog(n)


 */
public class Taxi {

    static ArrayList<Node>[] map;
    static int[] costs;
    static int N;

    public static void main(String[] args) {
        int n=6;  // 노드갯수
        int s=4;
        int a=5;
        int b=6;
        int[][] fares = {{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}};

        N = n;
        map = new ArrayList[n+1];
        for(int i=0; i<fares.length;i++){
            int from = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];
            if(map[from]==null){ map[from]=new ArrayList<>();}
            if(map[to]==null){ map[to]= new ArrayList<>(); }
            map[from].add(new Node(to,cost));
            map[to].add(new Node(from,cost));
        }

        costs = new int[n+1];
        setINF();
        dijkstra(s);

        int minCost = Integer.MAX_VALUE;
        int cost=0;
        int[] shareCosts = costs.clone();
        for(int i=1; i<=N;i++){
            if(map[i]==null){continue;}
            setINF();
            cost = shareCosts[i];
            dijkstra(i);
            cost+=costs[a];
            cost+=costs[b];
            minCost = Math.min(minCost,cost);
        }
        System.out.println(minCost);
    }
    static void setINF(){
        for(int i=0;i<costs.length;i++){ costs[i]=Integer.MAX_VALUE; }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        costs[start]=0;

        while (!pq.isEmpty()){
            int cur = pq.peek().n;
            int cost = pq.peek().cost;
            pq.poll();

            if(cost > costs[cur]){ continue; }
            for(Node node : map[cur]){
                int next = node.n;
                int nextCost = cost + node.cost;
                if(nextCost < costs[next]){
                    costs[next]=nextCost;
                    pq.offer(new Node(next,nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) { return this.cost-o.cost; }
    }
}
