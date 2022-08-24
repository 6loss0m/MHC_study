package BLIND_2018;

import java.util.PriorityQueue;
/*
    난이도가 높은 문제였습니다.

    가장 중요한 부분은 처리량이 변하는 지점은 시작과 끝지점 입니다.

    1. 시간 비교를 편하게 하기위해 모든 시간을 ms 단위로 바꾸어 오름차순으로 정렬하는 큐에 넣어줍니다.
        - 시작 시간과 끝시간 모두를 종류를 체크하여 하나의 리스트에 넣어서 정렬해 줍니다.
            * 시간이 같다면 종류가 시작,끝 순서로 정렬합니다. (계산과정에 음수가 될수 있으므로)
        - 끝 시간에 + 999 를 더해서 넣어줍니다.
            * 1초 동안 처리이기 때문에 1 초가 포함되면 안됨
            * 미리 계산하면, 반복문 중간에 다시 계산안해도 되기때문에
        - 시작시간에 +1 를 더해서 넣어줍니다.
            * 문제에 제시된 예제
    2. 큐에서 하나하나 뽑아주며 상태를 보고 현재 처리량의 증감시키고, 최대 처리량을 계산합니다.

 */

public class Traffic {
    public static void main(String[] args) {
        String[] lines= {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};

        PriorityQueue<Job> pq = new PriorityQueue<>();  // 시간의 오름차순, 종류는 시작,끝 순서로 정렬됨.
        for(int i=0;i<lines.length;i++){
            String[] line = lines[i].split(" ");
            String[] end = line[1].split(":|\\.");
            int endTime = Integer.parseInt(end[0]);
            endTime = endTime*60 + Integer.parseInt(end[1]);
            endTime = endTime*60 + Integer.parseInt(end[2]);
            endTime = endTime*1000 + Integer.parseInt(end[3]);
            pq.add(new Job(endTime+999,1));         // 미리 끝시간에 +999 를 해놓으면 이후 끝시간에서 +999 를 하여 계산하는 과정을 생략해도 되므로

            int start =(int)((Double.parseDouble(line[2].replaceAll("s","")))*1000);
            int startTime = endTime-start+1;
            pq.add(new Job(startTime,0));
        }
        int max = 0;
        int ing = 0;
        while (!pq.isEmpty()){
            Job tmp = pq.poll();
//            System.out.println("시간:"+tmp.time+"  종류:"+(tmp.kind==0? "시작":"종료"));
            if(tmp.kind==0){ ing+=1; }  // 0:start  1:end
            else{ ing-=1;}
            max = Math.max(ing,max);
        }
        System.out.println(max);
    }
    static class Job implements Comparable<Job> {
        int time;
        int kind;   // 0:start , 1:end

        public Job(int time, int kind) {
            this.time = time;
            this.kind = kind;
        }

        @Override
        public int compareTo(Job o) {
            if(this.time==o.time){ return this.kind-o.kind;}
            return this.time-o.time;
        }
    }
}
