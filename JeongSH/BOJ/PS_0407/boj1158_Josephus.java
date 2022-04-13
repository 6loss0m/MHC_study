package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
    큐를 사용하여 k-1 번쨰 까지 pop,push 를 같이 합니다.
    k번째를 pop 하여 결과에 추가하고, 이를 계속 반복합니다.

 */

public class boj1158_Josephus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        for(int i=0; i<N; i++){ queue.offer(i+1); }

        sb.append("<");
        while (queue.size()>1){
            for(int i=1; i<K; i++){ queue.offer(queue.poll()); }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
