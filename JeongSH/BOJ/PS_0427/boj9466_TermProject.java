package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    dfs로 사이클을 검사해주면 되는 문제입니다.

    1. 1->3->3
    2. 2->1->3->3
    3. 3->3
    이 문제는 어느 노드에서 시작하건 마지막엔 사이클의 순환으로 끝나게 됩니다.
    그리고 사이클에 속하지 못한 노드들은 팀 구성에서 빠지게됩니다.
    또한 이후에 다시 검사를 할 필요가 없습니다.
    중요)즉, 1번,2번 노드는 이후에 다른 노드가 가리킨다고 하더라도 절대 사이클이 생길수 없기때문입니다.

    문제풀이는
    사이클을 구성하는 모든 노드들의 갯수를 구한 뒤, 전체 노드 갯수에서 빼주는 식으로 풀이하였습니다.
    1. 사이클에 속하지 못한 노드는 이후에도 검사할필요 X
    2. 사이클을 구성하는 노드는 하나의 노드를 기준으로 계속 다음 노드를 타고 다시 원래 노드로 돌아올때까지 거친 노드의 수.

 */

public class boj9466_TermProject {
    static int[] map = new int[100001];
    static int[] visit = new int[100001];
    static int[] team = new int[100001];
    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        String[] input;

        for(int t=0; t<T; t++){
            cycle=0;
            int N = Integer.parseInt(br.readLine());
            Arrays.fill(visit,0,N+1,0);
            Arrays.fill(team,0,N+1,0);
            input = br.readLine().split(" ");
            for(int i=0; i<N; i++){
                map[i+1] = Integer.parseInt(input[i]);
            }
            for(int i=1; i<=N; i++){
                if(visit[i]==0){dfs(i);}
            }
            sb.append(N-cycle).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int n){
        visit[n]=1;
        int next = map[n];
        if(visit[next]==0){dfs(next);}  // 탐색하지 않았다면 탐색
        else{
            if(team[next]==0) {         // 탐색은 했지만, 아직 팀 구성이 되지않은 인원원은 사이클 검사
                for(int i=next; i!= n; i=map[i]){ cycle+=1; }
                cycle+=1;
            }
        }
        team[n]=1;                      // 탐색이 끝났다면 팀구성이 되건 되지않았건 다시 검사할 필요가없음
    }
}
