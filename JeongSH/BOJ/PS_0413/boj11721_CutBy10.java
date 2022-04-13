package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11721_CutBy10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        char[] input = br.readLine().toCharArray();
        int len = input.length;
        for(int i=0; i<len; i++){
            sb.append(input[i]);
            if((i+1)%10==0) {sb.append("\n");}
        }
        System.out.println(sb);
    }
}
