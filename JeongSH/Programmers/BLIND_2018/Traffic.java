package BLIND_2018;

import java.util.PriorityQueue;

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

        PriorityQueue<Job> pq = new PriorityQueue<>();
        for(int i=0;i<lines.length;i++){
            String[] line = lines[i].split(" ");
            String[] end = line[1].split(":|\\.");
            int endTime = Integer.parseInt(end[0]);
            endTime = endTime*60 + Integer.parseInt(end[1]);
            endTime = endTime*60 + Integer.parseInt(end[2]);
            endTime = endTime*1000 + Integer.parseInt(end[3]);
            pq.add(new Job(endTime+999,1));

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
