package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
    그냥 linkedlist 를 사용하여 구현하면 시간초과가 나옵니다.
        - linkedlist의 remove 연산은 O(n)

    stack 을 두개 사용하여 (커서 기준 left, right)
    remove 연산을 O(1) 연산으로 바꿔야합니다.

    혹은 linkedlist 를 직접 구현하여 remove 연산을 O(1) 만들 수 있습니다.

 */

public class boj1406_Editor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();
        int len = input.length();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i=0; i<len; i++){ left.push(input.charAt(i)); }

        int N = Integer.parseInt(br.readLine());
        String[] cmd;
        for(int i=0; i<N; i++){
            cmd = br.readLine().split(" ");
            switch (cmd[0]){
                case "L":
                    if(!left.isEmpty()) { right.push(left.pop()); }
                    break;
                case "D":
                    if(!right.isEmpty()) { left.push(right.pop()); }
                    break;
                case "B":
                    if(!left.isEmpty()) { left.pop(); }
                    break;
                case "P":
                    left.push(cmd[1].charAt(0));
                    break;
            }
        }
        while (!left.isEmpty()){ right.push(left.pop()); }
        while (!right.isEmpty()) { sb.append(right.pop()); }
        System.out.println(sb);
    }
}
