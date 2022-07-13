package SummerWinter_2018;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
    두 팀을 모두 오름차순으로 정렬하고, 각각 queue 에 담아줍니다.

    아이디어
    큐를 보며,
    1. A 큐의 가장 처음 >= B 큐의 가장 처음 (비기거나 지는 경우)
        B 큐의 가장 처음 숫자를 B 큐의 가장 마지막에 넣어줍니다.

    2. A 큐의 가장 처음 < B 큐의 가장 처음 (이기는 경우)
        A,B 큐 모두 가장 앞의 숫자를 제거하고, 점수를 +1 합니다.

    하지만 이런방식으로 동작하게되면
    A = {2,2,2,2}
    B = {1,1,1,1}
    해당경우 무한 반복을 돌게됩니다.

    그러므로 위의 1번 동작을 반복하는 최대횟수를 정해줍니다.
    1번동작의 최대 횟수 = B팀의 모든 큐를 탐색했으나, A팀을 이기는 숫자가 없는 경우 입니다.
    즉 현재 B팀 큐의 사이즈 만큼이 최대 반복 횟수입니다.

 */

public class NumGame {
    public static void main(String[] args) {
//        int[] A = {5,1,3,7};
//        int[] B = {2,2,6,8};

        int[] A = {2,2,2,2};
        int[] B = {1,1,1,1};

        Arrays.sort(A);
        Arrays.sort(B);

        Queue<Integer> aq = new LinkedList<>();
        Queue<Integer> bq = new LinkedList<>();
        for(int a : A){ aq.add(a); }
        for(int b : B){ bq.add(b); }

        int idx = bq.size();    // 최대 반복횟수는 B팀의 큐 사이즈 입니다.

        int point = 0;
        while (idx>0){
            int nA = aq.peek();
            int nB = bq.peek();
            if(nA>=nB){ bq.add(bq.poll()); idx-=1; }    // 1번 동작. 반복횟수 - 1
            else{ aq.poll(); bq.poll(); point+=1; idx=bq.size(); }  // 2번 동작. 반복횟수 초기화.
        }

        System.out.println(point);

    }
}
