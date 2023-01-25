package BOJ.PS_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
    스택을 사용하여 풀이하였습니다.

    아이디어
    과제:1 A T / 미과제:0
    1: 과제가 들어오면 T-1 을합니다.
        1-1. 0이 된다면 과제가 끝난것이므로, 총 점수를 올려줍니다.
        1-2. 0이 아니라면 스택에 추가해줍니다.
    0: 과제 x 이므로 기존의 과제를 꺼내 T-1 을 합니다.
        2-1. 0이 된다면 과제가 끝난것이므로, 총 점수를 올려줍니다.
        2-2. 0이 아니라면 스택에 다시 추가해줍니다.

 */

public class boj17952_EternalTask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer[]> stack = new Stack<>();

        int total=0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            if(split[0].equals("1")){
                // [score, time]
                int score = Integer.parseInt(split[1]);
                int time = Integer.parseInt(split[2])-1;
                if(time==0){ total+= score; continue;}

                stack.push(new Integer[]{score,time});
            }
            else if(!stack.isEmpty()) {
                Integer[] now = stack.pop();
                int score = now[0];
                int time = now[1]-1;
                if(time==0){ total+= score; continue; }

                stack.push(new Integer[]{score,time});
            }
        }
        System.out.println(total);
    }
}
