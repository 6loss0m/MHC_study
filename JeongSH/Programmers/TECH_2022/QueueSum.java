package TECH_2022;

import java.util.LinkedList;
import java.util.Queue;
/*
    두 큐중 합이 더 큰 큐에서 작은 큐로 이동해주고
    두 큐의 합이 같은지 계속 확인하는식으로 풀이하였습니다.

    저번에 풀이할때도 케이스 1 번만 계속 실패를 했는데
    반복문의 최대횟수를 늘려 해결했습니다.

 */

public class QueueSum {
    public static void main(String[] args) {
        int[] queue1={1, 1};
        int[] queue2={1, 5};

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1=0;
        long sum2=0;

        for (int n:queue1){ q1.offer(n); sum1+=n; }
        for (int n:queue2){ q2.offer(n); sum2+=n; }

        int max=queue1.length+queue2.length;
        int cnt = 0;

        while(max>=cnt){
            if(sum1==sum2){ System.out.println(cnt);return; }

            if(sum1>sum2){
                int n = q1.poll();
                q2.offer(n);
                sum2+=n;
                sum1-=n;
            }
            else{
                int n = q2.poll();
                q1.offer(n);
                sum1+=n;
                sum2-=n;
            }
            cnt++;
        }
        System.out.println(-1);
    }
}
