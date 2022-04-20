package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    에라토스테네스의 체를 사용하여 풀이합니다.

 */

public class boj1929_Prime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] prime = new int[1000001];

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        prime[1]=1;
        for(int i=2; i<N; i++){
            if(i > N/2 ) break;
            for(int j=2; j*i<=N; j++){
                if(prime[i*j]==1){ continue; }
                prime[i*j] = 1;
            }
        }
        for(int i=M; i<=N; i++){
            if(prime[i]==0){sb.append(i).append("\n"); }
        }
        System.out.print(sb);
    }
}
