package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11022_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        String[] input;
        for(int t=0; t<T; t++){
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            sb.append("Case #").append(t+1).append(": ").append(A).append(" + ").append(B).append(" = ").append(A+B).append("\n");
        }
        System.out.println(sb);
    }
}
