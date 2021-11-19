/*

    dfs 문제라고 생각해서 dfs로 풀었습니다.
    dfs로 하나의 컴퓨터(노드)가 연결할 수 있는 모든 가지를 탐색하여 1을 반환합니다.
    다른 네트워크가 더 있을 수 있으므로 다른 컴퓨터 기준으로도 dfs탐색을 합니다.

    시간복잡도 : O(V^2)

 */

public class Network {
    static boolean[] visit;
    public static void main(String args[]){
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer=0;
        visit = new boolean[n];

        for(int i=0; i<n; i++){                         //모든 컴퓨터 기준으로 탐색해야합니다.
            answer += dfs(i,computers);
        }
        System.out.println(answer);
    }

    public static int dfs(int nowComp,int[][] computers){
        if(visit[nowComp]==true){return 0;}             //이미 방문한 컴퓨터라면
        visit[nowComp]=true;
        for(int i=0; i<computers.length; i++){
            if(nowComp!= i && computers[nowComp][i]==1)  //nowComp 과 i가 같다면 자기 자신의 연결
                dfs(i,computers);                        //computers[nowComp][i]==1 이면 컴퓨터끼리 연결되어있는 것.
        }
        return 1;                                       //하나의 네트워크는 1만 반환합니다.
    }
}
