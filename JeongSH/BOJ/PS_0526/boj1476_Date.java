package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    완전탐색 문제입니다.
    직접 1일부터 ESM 까지 돌면서 결과가 충족하는지 확인합니다..

 */

public class boj1476_Date {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0])-1;   // 15
        int S = Integer.parseInt(input[1])-1;   // 28
        int M = Integer.parseInt(input[2])-1;   // 19

        for(int i=0; i<=7980; i++){
            if((i%15)!=E){continue;}
            if((i%28)!=S){continue;}
            if((i%19)!=M){continue;}
            System.out.println(i+1);
            break;
        }
    }
}
