package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    대문자, 소문자, 숫자, 공백 체크하기..

 */

public class boj10820_Analysis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String in = br.readLine();
        char[] input;
        while (true){
            input = in.toCharArray();
            int len = input.length;
            int up,small,num,space;
            up = small = num = space = 0;
            for(int i=0; i<len; i++){
                char c = input[i];
                if(isUp(c)){ up+=1;}
                else if(isSmall(c)){ small+=1; }
                else if(isNum(c)){ num+=1; }
                else {space +=1;}
            }
            sb.append(small).append(" ").append(up).append(" ").append(num).append(" ").append(space).append("\n");
            if( (in = br.readLine()) == null) {break;}
        }
        System.out.println(sb);

    }
    static Boolean isUp(char c){ return 'A' <= c && c <= 'Z'; }
    static Boolean isSmall(char c){ return 'a' <= c && c <= 'z'; }
    static Boolean isNum(char c){ return '0' <= c && c <= '9'; }
}
