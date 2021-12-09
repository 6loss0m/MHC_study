
/*

    크루스칼 알고리즘을 이용하였습니다.
    크루스칼 알고리즘은 최소 신장 트리를 구하기위한 알고리즘 입니다.
    1. 신장 트리란 ?
        1-1. 그래프에서 모든 정점을 포함해야합니다.
        1-2. 정점 간 서로 연결되며 싸이클이 존재하지 않는 그래프 입니다.
    2. 최소 신장 트리란?
        최소 신장 트리란 가중치의 합이 최소가 되는 신장 트리를 가리키는 말입니다.

    크루스칼 알고리즘 핵심
    1. Union-Find
    * 서로 다른 두 집합을 병합하는 Union 연산
    * 각 원소가 어느 집합에 속해있는지 찾기 위한 Find 연산

    2. 싸이클이 생기지않는 조건
    * 서로 다른 집합이면 싸이클이 생기지않고, 같은 집합이면 싸이클이 생깁니다.

    3. 가중치가 낮은 간선부터 선택

    크루스칼 알고리즘 작동방식
    1. 가중치를 기준으로 오름차순으로 정렬합니다.
    2. 가장 낮은 가중치부터 연결하려는 두 노드가 같은 집합인지 확인합니다 (find 연산)(집합의 부모노드를 확인)
    3. 두 노드가 다른 집합이라면 하나의 집합으로 만듭니다. (union 연산)
        3-1. 두 노드가 같은 집합이라면 싸이클이 생기기때문에 합치지않습니다.
    4. 위의 동작 방식을 간선의 수가 전체노드 - 1 이 될때까지 반복합니다. (신장트리는 정점의 갯수가 n일 때, 간선의 수는 n-1이 됩니다.)

    시간복잡도 : O(nlog n)
 */

import java.util.Arrays;
import java.util.Comparator;

public class IslandConnection {
    static int[] root;

    public static void main(String args[]){
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int n = 4;
        root = new int[n];
        int bridge=0;
        int answer=0;

        Arrays.sort(costs, new Comparator<int[]>() {            // 가중치를 기준으로 정렬합니다.
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for(int i =0; i<n; i++)                                 // 맨 처음 시작할때는 부모노드는 자기자신을 가리킵니다.
            root[i]=i;

        for(int i=0; i<costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])){         // 부모노드가 다르다면,
                union(costs[i][0],costs[i][1]);                 // 두 집합을 합쳐줍니다.
                answer += costs[i][2];                          // 가중치를 더해줍니다.
                bridge++;                                       // 간선의 수를 증가시킵니다.
            }
            if(bridge == n-1) {break;}                          // 정점이 n 일 경우 간선의 수는 n-1 이기 때문입니다.
        }
        System.out.println(answer);
    }

    public static int find(int x){                              // 집합을 확인 하기위한 find 연산
        if(root[x] == x) { return x; }                          // 자신의 부모노드를 반환합니다.
        else { return find(root[x]); }
    }
    public static void union(int x, int y){                     // 집합을 합치는 union 연산
        x=find(x);
        y=find(y);
        root[y]=x;                                              // 최상위 부모노드를 합쳐줍니다.
    }
}