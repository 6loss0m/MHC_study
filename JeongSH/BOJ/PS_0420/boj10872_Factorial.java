package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    팩토리얼..

 */

public class boj10872_Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ret = 1;
        for(int i=2; i<=N; i++){ ret *= i; }
        System.out.println(ret);
    }
}
