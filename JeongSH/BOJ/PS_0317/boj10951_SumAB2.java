package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10951_SumAB2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input;
        String[] tok;
        while( (input = br.readLine()) != null) {
            tok = input.split(" ");
            sb.append(Integer.parseInt(tok[0])+Integer.parseInt(tok[1])).append("\n");
        }
        System.out.println(sb);
    }
}
