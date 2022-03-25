package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10953_Sum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(",");
            sb.append(Integer.parseInt(input[0])+Integer.parseInt(input[1])).append("\n");
        }
        System.out.println(sb);
    }
}
