/**
 *  문제 아이디어:
 *      0. BFS 탐색을 기본
 *      1. 상태를 세 가지를 두어 큐에 저장.
 *          - 방문, 미방문, 닫힘.  (닫힘은 선행 동굴을 아직 안간상태)
*       2. <선행동굴 ,후행동굴> 로 조회를 할 수 있어야 함.    (현재 탐색한 동굴이 어딘가의 선행 동굴일 수 있기때문 )
 *      3. <후행동굴 ,선행동굴> 로도 조회를 할 수 있어야 함.   (현재 탐색한 동굴이 선행 동굴을 필요할 수 있기때문 )
 *      4. 문제에서 제시한 임의 두 동굴이 서로 가지못하는 경우는 없다.
 *          = 임의의 두 동굴은 반드시 연결되어있다.         ( 어디가의 선행동굴을 탐험했다면, 후행 동굴은 반드시 갈 수 있음)
 *          = 즉 선행 동굴을 탐험 했다면, 후행 동굴은 바로 방문 상태로 바꾸어도 된다. ( 굳이 노드를 타고 위로 다시 올라가서 탐색할 이유X )
 *
 */

import java.util.*;

public class Caving {
    public static void main(String args[]){
        int[][] p1 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] o1 = {{8,5},{6,7},{4,1}};
        System.out.println(solution(9,p1,o1));

        int[][] p2 = {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}};
        int[][] o2 = {{4,1},{5,2}};
        System.out.println(solution(9,p2,o2));

        int[][] p3 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] o3 = {{4,1},{8,7},{6,5}};
        System.out.println(solution(9,p3,o3));
    }
    static int VISIT = 1;
    static int NOT_VISIT = 0;
    static int CLOSE = -1;
    public static boolean solution(int n, int[][] path, int[][] order){
        int[] visit =new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer>[] conCave = new ArrayList[n];    // 동굴의 연결 정보
        HashMap<Integer,Integer> i_o = new HashMap<>();     // key-value <선행,후행>
        HashMap<Integer,Integer> o_i = new HashMap<>();     // key_value <후행,선행>

        for(int i=0; i<n; i++){
            conCave[i]= new ArrayList<>();
        }

        for(int[] p: path){
            conCave[p[0]].add(p[1]);                        // 동굴은 양방향 연결이기 때문에
            conCave[p[1]].add(p[0]);
        }
        for(int[] o: order){
            i_o.put(o[0],o[1]);                             // 선행,후행 동굴
            o_i.put(o[1],o[0]);
        }

        if(o_i.keySet().contains(0)){return false;}         // 테스트 케이스 30번 0번 동굴이 후행이고, 선행동굴을 필요하면 바로 false 반환
        q.add(0);
        visit[0]=1;

        while (!q.isEmpty()){
            int pq = q.poll();
            for(int i=0; i<conCave[pq].size(); i++){    //연결된 동굴 탐색
                int next = conCave[pq].get(i);
                if(visit[next]==NOT_VISIT){            // 탐색하지않았고
                    if(o_i.keySet().contains(next)){
                        if(visit[o_i.get(next)]== VISIT){   // 선행 동굴을 탐색했으면
                            q.add(next);                    // 큐에 넣어 줌.
                            visit[next]=VISIT;
                        }
                        else{ visit[next]=CLOSE;}            // 아직 선행동굴에 안갔으므로.
                    }
                    else{
                        if(i_o.keySet().contains(next) && visit[i_o.get(next)]==CLOSE){ // 어딘가의 선행 동굴이라면
                            q.add(i_o.get(next));                                       // 선행 조건을 충족했기 떄문에 바로 넣어줌.
                            visit[i_o.get(next)]=VISIT;                                 // 제한사항에서 임의의 두 동굴끼리 이동 불가능한 경우는 없다고 제시.
                        }
                        q.add(next);
                        visit[next]=VISIT;
                    }
                }

            }
        }
        for(int v : visit){
            if(v!=VISIT) return false;
        }
        return true;
    }
}
