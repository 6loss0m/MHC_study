package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    유클리드 호제법을 공부해야함..
    두 수 a,b의 최대공약수는 두 수를 계속 나머지 연산을 하여
    0이 될때까지 하면, 마지막 수가 두 수의 최대공약수입니다.

 */

public class boj1850_GCD2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        Long A = Long.parseLong(input[0]);
        Long B = Long.parseLong(input[1]);

        long GCD=gcd(A,B);
        for(long i=0; i<GCD; i++){ sb.append("1");}
        System.out.println(sb);
    }
    static long gcd(long a, long b){
        if(b==0){ return a;}
        return gcd(b,a%b);
    }
}
