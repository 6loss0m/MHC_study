package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    알파벳 위치 ..

 */

public class boj10809_Alphabet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] alphabet = new int[26];
        for(int i=0; i<26; i++){alphabet[i] = -1;}

        char[] input = br.readLine().toCharArray();
        int len = input.length;

        for(int i=0; i<len; i++){
            if(alphabet[input[i]-'a']==-1){alphabet[input[i]-'a']=i;}
        }
        for(int i=0; i<26; i++) {sb.append(alphabet[i]).append(" ");}
        System.out.println(sb);
    }
}
