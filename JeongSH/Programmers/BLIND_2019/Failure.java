package BLIND_2019;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
    난이도에 비해 생각을 해야하는 문제입니다.

    실패율
        스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수(=f) / 스테이지에 도달한 플레이어 수(=t)

    stage 배열을 보고 f 를 구할 수 있습니다.
    t 는 반복문을 돌며 확인할 수 있습니다.

    실패율을 계산한 뒤 문제에 조건에따라 정렬하여 반환합니다.

 */

public class Failure {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] fail = new int[N+2];
        Arrays.sort(stages);

        System.out.println(Arrays.toString(stages));
        for(int i=0;i<stages.length;i++){ fail[stages[i]]+=1; }
        System.out.println(Arrays.toString(fail));

        double[] result = new double[N+2];
        int len = stages.length;
        for(int i=0;i<stages.length;i++){
            if(result[stages[i]]!=0){continue;}                 // 스테이지의 도달한 플레이어 수(t) 는 len-i 중 가장 먼저 탐색하는 i 입니다.
            result[stages[i]]=(double) fail[stages[i]]/(len-i); // t
        }
        PriorityQueue<Fail> q = new PriorityQueue();
        for(int i=1;i<=N;i++){ q.add(new Fail(i,result[i])); }

        int[] ret = new int[q.size()];
        for(int i=0;i<ret.length;i++){ ret[i]=q.poll().n; }
        System.out.println(Arrays.toString(ret));

    }
    static class Fail implements Comparable<Fail>{
        int n;
        double failure;

        public Fail(int n, double failure) {
            this.n = n;
            this.failure = failure;
        }

        @Override
        public int compareTo(Fail o) {
            if(this.failure==o.failure){ return this.n-o.n; }
            return (o.failure-this.failure)>0 ? 1:-1;
        }
    }

}
