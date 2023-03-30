package BOJ.PS_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    무식하게 구현하더라도 
    시간 복잡도는 O(M*N) 정도 됩니다.
    
    아이디어
    1. 룰렛의 i번째 부터 M번 이동하여 숫자를 만듭니다.
        - 룰렛이 원형이기 때문에 roulette[(i+j)%N] 로 접근해야 합니다. 
    2. 만들어진 숫자가 X<= M <=Y 를 만족하면 카운트를 증가시킵니다.
     
 */

public class boj11504_Roulette {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] roulette = new int[100];

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // n등분
            int M = Integer.parseInt(input[1]); // M자리 수

            double X=0;
            double Y=0;

            input = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {  X += Double.parseDouble(input[i])*Math.pow(10,(M-i-1)); }   // X
            input = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {  Y += Double.parseDouble(input[i])*Math.pow(10,(M-i-1)); }   // Y
            input = br.readLine().split(" ");
            for(int i=0; i<N; i++){  roulette[i]=Integer.parseInt(input[i]); }  // roulette

            int cnt = 0;
            for(int i=0;i<N;i++){
                double now = 0;
                for(int j=0;j<M;j++){ now += roulette[(i+j)%N]*Math.pow(10,(M-j-1)); }
                if(X<=now && now<=Y){cnt++;}
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
