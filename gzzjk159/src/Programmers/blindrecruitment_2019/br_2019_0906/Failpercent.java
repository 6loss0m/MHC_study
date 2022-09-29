package Programmers.blindrecruitment_2019.br_2019_0906;

import java.util.*;

public class Failpercent {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double person = stages.length;
        ArrayList<double[]> fail_rate = new ArrayList<>();

        int cnt = 0;

        for (int i = 1; i < N; i++) {
            for (int stage : stages) {
                if (i == stage) {
                    cnt++;
                }
            }
            if(cnt==0){
                fail_rate.add(new double[]{i,0});
                continue;
            }
            fail_rate.add(new double[]{i,cnt/person});
            person -= cnt;
            cnt = 0;
        }
        fail_rate.sort((a,b) -> Double.compare(b[1],a[1]));

        for (int i = 0; i < fail_rate.size(); i++) {
            answer[i] = (int) fail_rate.get(i)[0];
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
