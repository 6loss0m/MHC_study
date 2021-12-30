
/*

    PriorityQueue 를 이용하여 문제 그대로를 구현..

    시간복잡도 : O(n)

 */


import java.util.PriorityQueue;

public class MoreSpicy2 {
    public static void main(String args[]){
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }
    public static int solution(int[] scoville, int K){
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            priorityQueue.add(scoville[i]);
        }
        if(priorityQueue.peek()>=K){return answer;}     // 안섞었는데 이미 K 이상일 경우는 0 리턴
        while(priorityQueue.size()>=2) {                // 한번에 두개 씩 빼내기 때문에, 큐가 2개 미만일 경우는 못만드는 경우.
            answer++;                                   // 섞는 횟수
            int e1 = priorityQueue.poll();
            int e2 = priorityQueue.poll();
            int comb = e1 + (e2 * 2);
            priorityQueue.add(comb);                    // 섞은거 추가
            if(priorityQueue.peek() >= K){return answer;}   // K 이상이면 섞는 횟수 반환
        }

        return -1;                                      // 못만드는 경우
    }
}
