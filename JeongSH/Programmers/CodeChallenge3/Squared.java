package CodeChallenge3;

import java.util.ArrayList;
import java.util.Arrays;
/*
    1 2 3 4
    2 2 3 4
    3 3 3 4
    4 4 4 4

    위의 배열을 n 크기만큼 자른뒤에 이어붙이면 아래와 같습니다.
    1 2 3 4 / 2 2 3 4 / 3 3 3 4 / 4 4 4 4
    1. / 로 구분되어있는 곳을 각각 한 구간 이라고 부른다면
        1 2 3 4 (0번째 구간)
        2 2 3 4 (1번째 구간)
    2. 각 구간별로 각각의 원소를 인덱스라고 부른다면
        1 2 3 4 (0번재 구간/ 인덱스 2번) = 3

    i번째 구간은 (i+1) 을 (i+1)번 만큼 반복한 뒤,
    남은 인덱스는 각 구간의 인덱스+1 번호로 채워줍니다.
    ex) 2번째 구간
    2 2
    - (i+1)을 (i+1)번 만큼 반복
    2 2 3 4
       [2][3]

    left/n 으로 시작 구간을 구할 수 있습니다.
    left%n 으로 시작 구간의 몇번째 인덱스 부터인지 구할 수 있습니다.

 */

public class Squared {
    public static void main(String[] args) {
        int n=4;
        long left = 7;
        long right = 14;

        int leftCycle = (int) left/n; // 몇번째 구간인지
        int leftIdx = (int) left%n;   // 몇번째 인덱스인지

        int rightCycle = (int) right/n;
        int rightIdx = (int) right%n;

        ArrayList<Integer> list = new ArrayList<>();
        for(int c=leftCycle; c<=rightCycle; c++){
            for(int i=0; i<n; i++){
                if(c==leftCycle && i<leftIdx){continue;}    // 시작구간이고, leftIdx 보다 작다면 시작 지점이 아니므로
                if(c==rightCycle && i>rightIdx){break;}     // 마지막 구간이고, rightIdx 보다 크다면 끝 지점을 초과하므로
                if(c>=i){ list.add(c+1); }
                else { list.add(i+1); }
            }
        }
        int[] ret = list.stream().mapToInt(i->i).toArray(); // ArrayList 를 간단하게 int[] 로 바꾸는 방법.
        System.out.println(Arrays.toString(ret));

    }
}
