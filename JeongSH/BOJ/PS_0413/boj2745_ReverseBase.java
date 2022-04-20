package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    B 진법 수를 10진수 숫자로 바꾸려면
    B 진법 각 자리의 수마다 B 제곱을 해준 뒤 곱하여 더해주면 됩니다.

 */

public class boj2745_ReverseBase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String N = input[0];
        int B = Integer.parseInt(input[1]);
        int len = N.length();
        int ret = 0;
        int tmp = 1;
        for(int i=1; i<=len; i++){
            int q = N.charAt(len-i);
            if('0'<=q && q<='9'){ q -= '0'; }
            else { q= q-'A'+10;}
            ret += tmp * q;
            tmp *= B;
        }
        System.out.println(ret);
    }
}
