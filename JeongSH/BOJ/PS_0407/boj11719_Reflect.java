package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11719_Reflect {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input="";
        while ((input=br.readLine()) != null){
            sb.append(input).append("\n");
        }
        System.out.println(sb);
    }
}
