package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    문자열을 0~end, 1~end, 2~end.... 까지 나눠서
    정렬 합니다.

 */

public class boj11656_Suffix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb =new StringBuffer();
        String input = br.readLine();
        int len = input.length();
        String[] suffix = new String[len];

        for(int i=0; i<len; i++){ suffix[i] = input.substring(i); }
        Arrays.sort(suffix);
        for(int i=0; i<len; i++){ sb.append(suffix[i]).append("\n");}
        System.out.println(sb);

    }
}
