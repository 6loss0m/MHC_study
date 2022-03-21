package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    VPS 조건
    1. '(' 의 갯수와 ')' 의 갯수는 같아야한다.
        - '('는 +1  /   ')'는-1 을 한다.
        - 결과가 0 이 아니라면 두개의 갯수가 서로 다르므로 VPS 가 아님.
        
    2.  무조건 '(' 가 ')' 보다 먼저나와야 한다.
        - ")(" 는 서로의 갯수는 같지만, VPS 가 아님.
        - 위의 방법처럼 진행하며 연산 결과가 음수가 된다면 VPS 가 아니기때문에 반복문을 탈출해야함. 

 */
public class boj9012_VPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input;
        Boolean isSkip;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            isSkip = false;
            int ret=0;
            input = br.readLine();
            int size = input.length();

            for(int j=0; j<size; j++){
                if(input.charAt(j) == '('){ret+=1;}
                else {ret-=1;}
                if(ret<0){ sb.append("NO").append("\n"); isSkip = true; break;} //조건 2
            }
            if(isSkip) {continue;}
            sb.append(ret == 0 ? "YES" : "NO").append("\n");    // 조건 1
        }
        System.out.println(sb);

    }
}
