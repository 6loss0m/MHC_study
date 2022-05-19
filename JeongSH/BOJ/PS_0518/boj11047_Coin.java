package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    그리디하게 접근하면 되는 문제입니다.
    거스름돈의 종류는 오름차순이므로
    가장 마지막 거스름돈부터 반복문을 돌며
    큰수부터 빼줍니다.

 */

public class boj11047_Coin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coins = new int[10];
        int N,K;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        int ret=0;
        for(int i=0;i<N; i++){ coins[i]=Integer.parseInt(br.readLine()); }
        for(int i=N-1; i>0; i--){
            int tmp = K / coins[i];
            ret+=tmp;
            K-=tmp*coins[i];
        }
        System.out.println(ret);
    }
}
