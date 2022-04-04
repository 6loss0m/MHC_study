package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    큐는 배열로 구현하였을때, 스택과 같이 간단하게 구현이 가능합니다.
    하지만, push pop 이 자주사용되면 메모리의 낭비가 심할 수 있습니다.

 */

public class boj10845_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] queue = new int[10000];
        int front = 0;
        int rear = 0;
        String[] cmd;
        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++){
            cmd = br.readLine().split(" ");
            switch (cmd[0]){
                case "push":
                    queue[rear++] = Integer.parseInt(cmd[1]);
                    break;

                case "pop":
                    if(front==rear) {sb.append(-1).append("\n"); }
                    else{ sb.append(queue[front++]).append("\n");}
                    break;

                case "size":
                    sb.append(rear-front).append("\n");
                    break;

                case "empty":
                    if(front==rear){ sb.append(1).append("\n"); }
                    else{ sb.append(0).append("\n"); }
                    break;

                case "front":
                    if(front==rear){ sb.append(-1).append("\n"); }
                    else{ sb.append(queue[front]).append("\n"); }
                    break;

                case "back":
                    if(front==rear){ sb.append(-1).append("\n"); }
                    else { sb.append(queue[rear-1]).append("\n");}
                    break;
            }
        }
        System.out.println(sb);
    }
}
