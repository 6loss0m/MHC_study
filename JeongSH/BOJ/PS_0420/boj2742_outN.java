package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2742_outN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=N; i>0; i--){ sb.append(i).append("\n"); }
        System.out.println(sb);
    }
}
