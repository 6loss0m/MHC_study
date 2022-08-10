package CodeChallenge2;

import java.util.ArrayList;
/*
    트리구조이기때문에 부모노드와 자식노드의 관계가 존재합니다.
    루트 노드로 모든 자손노드들의 값을 더해서 올려주면 됩니다.
    루트 노드를 어디로 정하는지에 따라 값이 변할것 같지만 결국 더하는 순서만
    달라질뿐 결과는 같습니다.

    0번 노드를 루트 노드로 정하고, dfs 를 통해 모든 노드를 방문하며,
    자식노드의 값을 부모노드에 더해주었습니다.

    주의점
    해당문제에서 자바는 시간 설정이 미묘하게 설정되어있는지
    같은 코드에서 향상된 for 문으로 문제를 풀면 런타임 에러가 나고, 일반 for 문 을 쓰면 통과됩니다.
    +
    향상된 for 문을 써도 가끔 통과는되는데 서버상태에 따라서 오락가락합니다

 */

public class Zero {
    static long[] cost;     // 각각의 노드의 값을 더하는 과정에서 오버플로가 나기때문에 새로운 long 배열을 선언
    static ArrayList<Integer>[] edge;
    static boolean[] visit;
    static long result=0;   // 절대값으로 더해 줄 변수

    public static void main(String[] args) {
        int[] a={-2, 8, -5, -5, -3, 0, 5, 2};
        int[][] edges={{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}};
        cost = new long[a.length];
        for(int i=0;i<a.length; i++){cost[i]=a[i];}
        edge = new ArrayList[a.length];
        visit = new boolean[a.length];

        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            if(edge[from]==null){edge[from]=new ArrayList<>(); }
            if(edge[to]==null){edge[to]=new ArrayList<>();}
            edge[from].add(to);
            edge[to].add(from);
        }
//        System.out.println(Arrays.toString(cost));
        dfs(0);
//        System.out.println(Arrays.toString(cost));
        System.out.println(result);
        if(cost[0]!=0){System.out.println(-1);}

    }
    static long dfs(int node){
        visit[node]=true;

        int size = edge[node].size();
        for(int i=0; i<size; i++){          // 원래는 향상된 for 문으로 풀었지만..
            int next = edge[node].get(i);
            if(!visit[next]){
                long sum = dfs(next);
                cost[node]+= sum;
                result += sum>0 ? sum:-1*sum;
            }
        }
        return cost[node];
    }
}
