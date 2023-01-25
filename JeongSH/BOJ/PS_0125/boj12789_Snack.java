package BOJ.PS_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
    큐와 스택을 사용하여 풀이하였습니다.

    아이디어
    큐=줄 / 스택=대기
    1. 큐로 처음 줄을 세웁니다.
    2. 큐에서 사람을 꺼내 자기 순서가 맞다면, 간식을 줍니다.
    3. 스택에서 사람을 꺼내 자기 순서가 맞다면, 간식을 줍니다.
    4. 2,3 번이 둘 다 아니라면, 큐에서 스택으로 이동시켜줍니다.
    5. 2,3,4 를 만족하지 않는다면, "Sad" 를 출력 합니다.

    2~5번을 반복

 */

public class boj12789_Snack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> line= new LinkedList<>();
        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            line.add(Integer.parseInt(input[i]));
        }

        Stack<Integer> wait = new Stack<>();
        int time = 1;
        while (!line.isEmpty() || !wait.isEmpty() ){

            if(!line.isEmpty()) {   // 2. 큐에서 사람을 꺼내 자기 순서가 맞다면, 간식을 줍니다.
                if (time == line.peek()) { line.poll(); time++; continue; }
            }

            if(!wait.isEmpty()){    // 3. 스택에서 사람을 꺼내 자기 순서가 맞마면, 간식을 줍니다.
                if(time == wait.peek()){ wait.pop(); time++; continue; }
            }

            if(!line.isEmpty()){ wait.push(line.poll()); continue; }    // 4. 3,4 번이 둘 다 아니라면 큐에서 스택으로 이동시켜줍니다.

            else{ System.out.println("Sad"); return; }  // 5. 2,3,4 를 만족하지 않는다면, "Sad" 를 출력 합니다.
        }
        System.out.println("Nice");
    }
}
