package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제이해가 잘 안됬으나 결국 N진수 만들기를 음수로 하는것과 같습니다.
    다만 수를 나누어가면서 나머지를 1로 만들어야합니다.
    나머지가 -1 일 경우엔 몫을 하나 늘리고 나머지를 1 로 바꿔주면됩니다.

 */

public class boj2089_MBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==0){ System.out.println(0); }

        String ret = "";
        while (N!=0) {
            int q = N / -2;
            int r = N % -2;
            if(r == -1) { q+=1; r=1; }
            ret = r+ret;
            N = q;
        }
        System.out.println(ret);
    }
}
