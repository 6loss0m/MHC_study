package BLIND_2022;

import java.util.ArrayList;
/*
    시간초과를 해결하지못하였습니다.

    검색을 통해 알게된 점.
    다른 노드를 방문할 때, 부모노드를 거쳐야할 필요가 없기때문에
    매 노드 방문 시 마다 갈 수 있는 노드를 체크해놓고 바로 이동하는 방식으로 풀이해야합니다.

    풀이 방법
    루트 노드부터 탐색 할 수 있는 노드(양>늑대)를 방문합니다.
    방문과 동시에 현재 방문한 노드를 다음 탐색 리스트에서 삭제하므로서
     0
  1     2
3  4   5  6

    [0번 방문]
    탐색리스트에서 0번 삭제. {}
    1번,2번 추가. {1,2}
    [1번 방문]
    1번 삭제. {2}
    3,4번 모두 늑대가 양의 숫자보다 많다고 가정하면 X {2}
    이후에 방문할 리스트를 통해서 루트 노드를 거치는것이 아닌 바로 2번 노드를 방문하면 됩니다.


 */

public class Sheep_Wolf {
    static int maxSheep;
    static ArrayList<Integer>[] nodes;
    static int[] infos;

    public static void main(String[] args) {
        int[] info ={0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges ={{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
        // 0:양,  1:늑대
        infos = info;
        nodes = new ArrayList[info.length];
        for(int[] arr: edges){
            int parent = arr[0];
            int child = arr[1];
            if(nodes[parent]==null){
                nodes[parent]=new ArrayList<>();
            }
            nodes[parent].add(child);
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0,0,0,list);
        System.out.println(maxSheep);

    }
    static void dfs(int index, int sheep, int wolf, ArrayList<Integer> next){
        if(infos[index]==0) { sheep++; }
        else { wolf++; }
        if(wolf>= sheep){ return; }
        maxSheep = Math.max(sheep,maxSheep);

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(next);  // 기존에 방문해야 할 노드들 전부 추가
        list.remove(Integer.valueOf(index));    // 현재 방문 노드는 삭제.
        if(nodes[index]!=null){                 // 다음에 방문할 노드가 있다면
            for(int node: nodes[index]){
                list.add(node);
            }
        }

        for(int n: list){
            dfs(n,sheep,wolf,list);     // 다음에 방문할 노드로 탐색
        }
    }

}
