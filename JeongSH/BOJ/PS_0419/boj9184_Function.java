package BOJ.PS_0419;

/*
    아이디어
    함수의 최대 호출은 2^20 인 1048576 입니다.
    그러므로 매번 2^20 계산이 아닌 한번만 계산을 한다면 시간초과가 발생하지 않습니다.
    메모리제이션을 이용하여 연산횟수를 줄여보았습니다.
    arr[a][b][c] : w(a,b,c) 값을 저장

    20을 넘는 숫자가 있으면 w(20,20,20) 로 고정되므로 3중 반복문으로 arr 배열을 채워 줍니다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9184_Function {
    static int[][][] arr = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 20; k++) {
                    arr[i][j][k] = w(i,j,k);
                }
            }
        }

        while (true){
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            if(a==-1 && b==-1 && c==-1){ return; }
            System.out.printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
        }

    }
    static int w(int a, int b, int c){
        if(a<=0 || b<= 0 || c<=0) { return 1; }

        if(a>20 || b>20 || c>20){ return w(20,20,20); }

        if(arr[a][b][c]!=0){ return arr[a][b][c]; } // 메모리제이션 사용

        if(a<b && b<c){ return w(a,b,c-1)+w(a,b-1,c-1) -w(a,b-1,c); }

        return w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }
}
