package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    더하기..
 */

public class boj11021_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        String[] in;
        for(int t =1; t<=T; t++){
            in = br.readLine().split(" ");
            sb.append("Case #").append(t).append(": ");
            sb.append(Integer.parseInt(in[0])+Integer.parseInt(in[1])).append("\n");
        }
        System.out.println(sb);
    }
}
