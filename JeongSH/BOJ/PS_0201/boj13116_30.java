package BOJ.PS_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제에서 처럼 순서데로 연결된 이진트리이기때문에
    노드N 의 부모노드는
    짝수 일 경우 -> N/2
    홀수 일 경우 -> (N-1)/2 
    
    그러므로,
    공통 부모노드가 나올때까지 노드들의 부모노를 타고올라가면 됩니다.  

 */

public class boj13116_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] inputs = br.readLine().split(" ");
            int A = Integer.parseInt(inputs[0]);
            int B = Integer.parseInt(inputs[1]);

            while (A!=B){
                if(A<B){ int tmp=A; A=B; B=tmp;}    // A>B 를 만들어 계산을 쉽게합니다.
                if((A&1)==1){ A-=1; }               // 홀수는 N-1
                A=A/2;                              
            }
            sb.append(A*10).append("\n");           // 문제에서 곱하기 10을 해야하기 때문에
        }
        System.out.println(sb);
    }
}
