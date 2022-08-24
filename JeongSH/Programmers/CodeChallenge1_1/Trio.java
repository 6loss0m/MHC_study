package CodeChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
    문제 아이디어
    이 문제는 두 노드의 거리가 지름 다음으로 큰 거리를 구하는 문제로 바꾸어 생각할 수 있습니다.
    a->c 가 트리의 지름이라고 생각한다면, 문제의 조건인 중간값을 가져오기위해
    max( dist(a,b), dist(b,c) ) 가 최대가되는 값이 정답이 됩니다.
    즉,
    트리의 각각의 정점인 a,c 을 시작으로 a,c를 제외한 가장 먼 노드의 거리를 구하면됩니다.
    a는 c 노드를 제외한 가장 먼노드와의 거리를 구하고,
    c는 a 노드를 제외한 가장 먼노드와의 거리를 구한뒤,
    둘 중 큰 값이 정답이 됩니다.

    주의점
    dfs 탐색 시 런타임 에러가 납니다.

 */

public class Trio {
    static ArrayList<Node>[] edge;
    static int N;
    public static void main(String[] args){
//        int n=4;
//        int[][] edges= {{1, 2}, {2, 3}, {3, 4}}; // result : 2
        int n =5;
        int[][] edges = {{1, 5}, {2, 5}, {3, 5}, {4, 5}};   // result : 2

        N=n;
        edge = new ArrayList[N+1];

        int len = edges.length;
        for(int i=0; i<len; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            if(edge[from]==null){ edge[from]=new ArrayList<>(); }
            if(edge[to]==null){ edge[to]=new ArrayList<>(); }
            edge[from].add(new Node(to,1));
            edge[to].add(new Node(from,1));
        }
        Node a = bfs(1,0);    // 임의의 점과 가장 멀리 떨어진 a. 지름의 한 끝 점 (a)
        Node b = bfs(a.N,0);        // a ~ b 는 트리의 지름.  지름의 다른 끝 점 (b)
        int dist_a = bfs(a.N, b.N).dist;    // a 를 기준으로 b노드를 제외한 가장 먼 노드의 거리
        int dist_b = bfs(b.N, a.N).dist;    // b 를 기준으로 a노드를 제외한 가장 먼 노드의 거리
        System.out.println(Math.max(dist_a,dist_b));
    }

    static Node bfs(int start, int except){     // except : 탐색 시, 제외할 노드 번호
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        Node maxDist = new Node(start,0);
        visit[start]=true;
        queue.add(maxDist);

        while (!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.dist > maxDist.dist && cur.N!=except ) { maxDist=cur; }

            for(Node next : edge[cur.N]){
                if(visit[next.N]) continue;
                visit[next.N] = true;
                queue.add(new Node(next.N, cur.dist+1));
            }
        }
        return maxDist;
    }

    static class Node{
        int N;
        int dist;
        public Node(int n, int dist) {
            N = n;
            this.dist = dist;
        }
    }
}
