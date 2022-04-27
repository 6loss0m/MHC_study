package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2739_MultiplicationTable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<10; i++){
            sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
        }
        System.out.print(sb);
    }
}
