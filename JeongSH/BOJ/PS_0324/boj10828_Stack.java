package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

    스택을 간단한 배열로 구현..
    백준과 달리
    하나의 프로세스로 여러 테스트케이스를 테스트할 경우.
    매번 new 를 사용하여 공간할당을 하는것은 매우 느리기 떄문에,
    라이브러리의 큐를 사용하여 매 인풋마다 new 를 하는것보다
    문제의 제한 조건을 보고 미리 최대 크기만큼 한 번 할당하여 사용하는게 더 빠릅니다.

 */

public class boj10828_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb =new StringBuffer();
        int top=-1;
        int size=0;
        String[] input;
        String cmd;
        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        for(int n=0; n<N; n++){
            input = br.readLine().split(" ");
            cmd = input[0];
            switch (cmd){
                case "push":
                    stack[++top]=Integer.parseInt(input[1]);
                    size+=1;
                    break;

                case "pop":
                    if(size == 0){ sb.append(-1).append("\n");}
                    else {sb.append(stack[top--]).append("\n"); size-=1;}
                    break;

                case "size":
                    sb.append(size).append("\n");
                    break;

                case "empty":
                    if(size==0) {sb.append(1).append("\n");}
                    else {sb.append(0).append("\n");}
                    break;

                case "top":
                    if(size==0){sb.append(-1).append("\n");}
                    else{sb.append(stack[top]).append("\n");}
                    break;
            }

        }
        System.out.println(sb);

    }
}
