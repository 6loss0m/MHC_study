
/*

    아이디어는 금방 잡았는데 의외로 예외처리에서 막혔습니다.
    문제 접근
         1. 먼저 들어온 작업이 없다면 , 먼저들어온 순서로
         2. 작업시간이 짧을수록

         1번 조건을 충족하기 위해, jobs[][] 배열을 들어온 순서데로 오름차순으로 정렬해주었습니다.
         2번 조건을 충족하기 위해, 작업시간이 빠를수록 우선순위를 갖는 우선순위 큐를 만들었습니다.
         nowTime 은 해당 작업이 끝났을 때의 시간을 의미합니다.
         가장 먼저들어온 작업을 완료한 뒤, nowTime 보다 일찍 들어온 작업들을
         우선순위 큐에 넣어주면 이 작업들은 작업시간을 기준으로 오름차순으로 정렬됩니다.

         이를 이용하여 모든 작업들의 평균시간을 구합니다.

     막힌부분
        1. 처음 jobs[][] 정렬할 때, 들어온 시간데로 오름차순으로 정렬하되 들어온 시간이 "같은"경우 작업이 짧은 작업을 앞으로 배치해야 합니다.
            ex) {{0,3},{4,4},{4,1},{5,3}} -> {4,4},{4,1} 비교할 때 {4,1} 이 앞으로 오게 정렬해야 함.
        2. 작업이 끝난 뒤, 바로 작업이 들어오지않고 시간의 텀을두고 다음 작업이 들어올 때 예외처리.
            ex) {{0,3},{4,4},{4,1},{5,3}} -> 첫 작업이 끝난 뒤, nowTime=3이지만 {4,1} 작업을 가져와야함.

 */


import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController2 {
    public static void main (String args[]){
        System.out.println(solution(new int[][] {{0, 3}, {4, 4}, {5, 3}, {4, 1}}));
//        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));
    }
    public static int solution(int[][] jobs){
        boolean[] isFinish = new boolean[jobs.length];                      // 끝낸 작업과 남은 작업을 체크하기 위한 배열.
        Arrays.fill(isFinish,false);
        Arrays.sort(jobs, (o1, o2) -> {                                     // 배열 정렬
            if(o1[0]!=o2[0]) {return o1[0]-o2[0];}                          // 들어온 순서 오름차순으로 정렬
            return o1[1]-o2[1];                                             // 들어온 시간이 같다면 작업시간이 짧은 작업부터.
        });

        int nowTime=jobs[0][0]+jobs[0][1];                                  // 첫 작업은 첫 작업의 시작시간 + 작업시간
        int answer = jobs[0][1];                                            // 첫 작업의 요청완료시간 = 대기시간(0)+작업시간
        isFinish[0]=true;                                                   // 첫 작업을 끝냈으므로.
        while(true) {
            PriorityQueue<Job> priorityQueue = new PriorityQueue<>();
            for(int i=1; i<jobs.length; i++) {
                if (isFinish[i]==true){continue;}                           // 이미 작업한 작업이면 건너뛰기.
                if (nowTime >= jobs[i][0]){priorityQueue.add(new Job(jobs[i][0],jobs[i][1],i)); }       // 지금 작업이 끝나기전에 들어온 요청들이있다면 우선순위 큐에 넣기
                if (nowTime < jobs[i][0]){                                                              // 지금 작업이 끝나고나서 텀을 갖고 요청이 들어왔다면
                    if(priorityQueue.isEmpty()){priorityQueue.add(new Job(jobs[i][0],jobs[i][1],i)); }  // 큐가 비어있다면 = nowTime 내에 요청 작업이 없다는 뜻.
                    break;                                                                              // 먼저들어온 순서로 요청을 처리.(시작시간이 같다면 짧은 순서로 정렬되어있음)
                }
            }
            if(priorityQueue.isEmpty()){break;}                                                         // 큐가 비었다는 것은 모든 요청이 전부 처리된 경우.
            Job nowJob = priorityQueue.poll();
            isFinish[nowJob.index]=true;
            int wait;
            if(nowTime<=nowJob.start){nowTime=nowJob.start; wait=0;}                                    // nowTime 이후 요청시간이 텀을 두고 들어온경우. 이 작업은 대기 시간이없음.
            else{ wait=nowTime-nowJob.start;}                                                           // 위 경우가 아니면    대기시간 = nowTime - 현재작업의시작시간.
            nowTime += nowJob.running;                                                                  // 현재 시간은 = 현재시간 + 작업시간.
            answer += wait+nowJob.running;                                                              // 총 요청대기시간 += 대기시간 + 작업시간.
        }

        return answer/ jobs.length;
    }
    static class Job implements Comparable<Job> {
        int start;
        int running;
        int index;

        public Job(int start, int running, int index) {
            this.start = start;
            this.running = running;
            this.index = index;
        }

        @Override
        public int compareTo(Job o) {
            if(this.running > o.running)
                return 1;
            else if(this.running < o.running)
                return -1;
            return 0;
        }
    }

}