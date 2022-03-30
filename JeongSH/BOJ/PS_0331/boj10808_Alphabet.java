package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    알파벳 갯수 세기..

 */

public class boj10808_Alphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] alphabet = new int[26];
        char[] S = br.readLine().toCharArray();
        int len = S.length;

        for(int i=0; i<len; i++){ alphabet[S[i]-'a']+=1; }
        for(int i=0; i<26; i++){ sb.append(alphabet[i]).append(" ");}
        System.out.println(sb);
    }
}
