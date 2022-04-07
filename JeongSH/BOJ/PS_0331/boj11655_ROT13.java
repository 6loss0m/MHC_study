package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    대소문자만 13칸 씩 뒤로 밀어서 출력하기

 */

public class boj11655_ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[] in = br.readLine().toCharArray();

        int len = in.length;
        for(int i=0; i<len; i++){
            char c = in[i];
            if('A'<=c && c<='Z' ){
                if(13+c > 'Z') { c = (char) (13+c-'Z'+'A'-1); }
                else { c = (char) (c+13); }
                sb.append((char)(c));
            }
            else if( ('a'<=c && c<='z')) {
                if(13+c > 'z') { c = (char) (13+c-'z'+'a'-1); }
                else { c = (char) (c+13); }
                sb.append((char)(c));
            }
            else{ sb.append((char)(in[i]));}
        }
        System.out.println(sb);

    }
}
