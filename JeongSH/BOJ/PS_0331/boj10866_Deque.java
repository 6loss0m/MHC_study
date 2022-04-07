package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    덱 자료형도 배열로 구현하여 사용할 수 있습니다.
    방법 1. 입력값의 두배의 크기의 배열을 선언하여 가운데부터 시작한다.
    방법 2. 0 부터 시작하지만, 배열을 원형 구조라고 생각하고 데이터를 넣는다.

    저는 방법2 로 구현하였습니다.
    0번 인덱스의 앞은, 배열의 가장 마지막 인덱스라고 생각하면 됩니다.

    push_front 는 데이터를 현재 포인터에서 앞에 넣기때문에 [9999] 에 데이터를 넣어주면됩니다.
    front 는 처음에 0을 가리키고 있으므로
    deque[(front-1+10000) % 10000] 을 하면 됩니다.
    나머지 연산은 음수를 반환할 수 있기때문에
    (front-1)%10000 이 아닌
    (front-1+10000)%10000 을 해야합니다.

    이후에는 pop 하고 난뒤 각각의 포인터 위치를 생각하여 구현하면 됩니다.

 */

public class boj10866_Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] deque = new int[10000];
        int front = 0;
        int rear = 0;
        int size = 0;
        int N = Integer.parseInt(br.readLine());
        String[] cmd;
        for(int i=0; i<N; i++){
            cmd = br.readLine().split(" ");
            switch (cmd[0]){
                case "push_front":
                    deque[front] = Integer.parseInt(cmd[1]);
                    front = (front-1 + 10000) % 10000;
                    size+=1;
                    break;

                case "push_back":
                    rear = (rear+1) % 10000;
                    deque[rear] = Integer.parseInt(cmd[1]);
                    size+=1;
                    break;

                case "pop_front":
                    if(size == 0){sb.append(-1);}
                    else{
                        sb.append(deque[(front+1)%10000]);
                        front = (front+1)%10000;
                        size-=1;
                    }
                    sb.append("\n");
                    break;

                case "pop_back":
                    if(size == 0){sb.append(-1);}
                    else{
                        sb.append(deque[rear]);
                        rear = (rear-1+10000) % 10000;
                        size -=1;
                    }
                    sb.append("\n");
                    break;

                case "size":
                    sb.append(size).append("\n");
                    break;

                case "empty":
                    if(size==0){sb.append(1);}
                    else{sb.append(0);}
                    sb.append("\n");
                    break;

                case "front":
                    if(size==0){sb.append(-1);}
                    else{ sb.append(deque[(front+1)%10000]); }
                    sb.append("\n");
                    break;

                case "back":
                    if(size==0){sb.append(-1);}
                    else{ sb.append(deque[rear]);}
                    sb.append("\n");
                    break;

            }
        }
        System.out.println(sb);
    }
}
