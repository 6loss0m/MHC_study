
/*

    문제접근
        최대값과 최소값을 둘 다 접근해야하기 때문에 오름차순으로 정렬된 큐와 내림차순으로 정렬된 큐를 만들어 처리합니다.
        "I n" 명령어가 들어오면 오름차순,내림차순 큐 둘 모두 추가해줍니다.
        "D 1" 명령어가 들어오면 내림차순 큐에서 최상단을 뽑아, 오름차순 큐의 인자를 지워줍니다.
        "D -1" 명령어가 들어오면 오름차순 큐에서 최상단을 뽑아, 내림차순 큐의 인자를 지워줍니다.

 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class DoublePriority2 {
    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(new String[] {"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[] {"I 7","I 5","I -5","D -1"})));
        System.out.println(Arrays.toString(solution(new String[] {"I 5","D 1","D 1","D 1","I 5","I -5","D 1"})));
    }
    public static int[] solution(String[] operations){
        int[] answer = {0,0};
        PriorityQueue<Integer> minQ = new PriorityQueue<>();                    // 오름차순
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2-o1);   // 내림차순
        for(int i=0; i<operations.length; i++){
            String[] split = operations[i].split(" ");
            if(split[0].equals("I")){minQ.add(Integer.parseInt(split[1])); maxQ.add(Integer.parseInt(split[1]));}   // 두 큐 모두 추가
            else{
                if(maxQ.isEmpty()){continue;}                                   // 큐가 비었다면 무시.
                else if(split[1].equals("1")){minQ.remove(maxQ.poll());}        // 최대값을 뽑아 오름차순 큐 인자를 삭제.
                else{maxQ.remove(minQ.poll());}                                 // 최소값을 뽑아 내림차순 큐 인자를 삭제.
            }
        }
        if(maxQ.isEmpty()){return answer;}
        answer[0]=maxQ.peek();
        answer[1]=minQ.peek();
        return answer;
    }
}
