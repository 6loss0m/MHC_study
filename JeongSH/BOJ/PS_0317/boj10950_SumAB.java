package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10950_SumAB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input;
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            sb.append(Integer.parseInt(input[0])+Integer.parseInt(input[1])).append("\n");
        }
        System.out.println(sb);
    }
}
