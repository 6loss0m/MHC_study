import java.util.LinkedList;
import java.util.Queue;

/*
    
    bfs 로 풀이해봤습니다.

    시간복잡도: O(V+E)

 */


public class ChangeWords {

    public static void main(String args[]){
        String begin="hit";
        String target="cog";
        String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
        int answer = 0;

        boolean[] visit = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin,0));                               // 첫 노드 begin 을 만들고 큐에 넣어줍니다. 

        while (!queue.isEmpty()){                                       // bfs 노드 순회 방식
            Node now = queue.poll();                                    // 큐의 최상단에서 노드를 가져옵니다.
            int cost = now.cost;
            if(now.next.equals(target)){                                // target 과 현재 노드의 단어가 같다면 순회는 끝납니다. 
                answer=cost;                                            // 시작 노드와의 거리
                break;
            }
            for(int i=0; i<words.length; i++){
                if(isChange(now.next,words[i]) && !visit[i]){           // 단어를 바꿀수있느지 없는지와 방문했는지 검사
                    queue.add(new Node(words[i], cost+1));          // 단어를 바꿀수있고 방문하지않았다면 큐에 넣어줍니다.
                    visit[i]=true;                                      // visit 최신화
                }
            }
        }

        System.out.println(answer);
    }


    static class Node {
        String next;
        int cost;

        public Node(String next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }

    public static Boolean isChange(String a, String b){                 // 두 단어가 변환될 수 있는지 판단
        String[] splitA = a.split("");
        String[] splitB = b.split("");
        int diffNum=0;
        for(int i=0; i<splitA.length; i++){
            if(!splitA[i].equals(splitB[i])){
                diffNum++;
                if(diffNum>1){return false;}
            }
        }
        return true;
    }
}