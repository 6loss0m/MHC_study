package Programmers.BlindRecruitment_2018.BR_2018_0824;
import java.util.*;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String table : timetable) {
            int time = Integer.parseInt(table.substring(0, 2)) * 60 + Integer.parseInt(table.substring(3));
            pq.add(time);
        }

        int start_time = 9 * 60;
        int last_time = 0;
        int total = 0;
        for(int i = 0; i < n; i++) {
            total = 0;
            while(!pq.isEmpty()) {
                int current_time = pq.peek();
                if(current_time <= start_time && total < m) {
                    pq.poll();
                    total++;
                } else break;
                last_time = current_time - 1;
            }
            start_time += t;
        }
        if(total < m) last_time = start_time - t;

        String hour = String.format("%02d", last_time / 60);
        String minute = String.format("%02d", last_time % 60);
        return hour + ":" + minute;
    }
    public static void main(String[] args) {

    }
}
