package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10991_Star2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N;i++){
            for(int j=N-1; j>=i;j--){ sb.append(" "); }
            for(int j=1; j<=i;j++){ sb.append("*").append(" "); }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
