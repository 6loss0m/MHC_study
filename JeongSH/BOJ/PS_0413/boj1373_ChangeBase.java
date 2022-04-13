package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    굳이 2진수를 10진수로 바꾸고 8진수로 바꾸지않고,
    2진수를 세 자리씩 묶으면 8진수로 표현할 수 있습니다.
    예외처리를 꼭 해줍니다.

 */

public class boj1373_ChangeBase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();
        int len = input.length();
        if(len==1){ System.out.println(input); return;}
        int r = len%3;
        if(r!=0){ input = "0".repeat(3-r)+input; len += (3-r);}
        for(int i=2; i<len; i+=3){
            int tmp =0;
            tmp += input.charAt(i-2)=='0' ? 0:4;
            tmp += input.charAt(i-1)=='0' ? 0:2;
            tmp += input.charAt(i)=='0' ? 0:1;
            sb.append(tmp);
        }
        System.out.println(sb);
    }
}
