package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2442_Star2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            for(int k=N-i; k>0; k--){ sb.append(" ");}
            for(int j=0; j<(i*2)-1; j++) { sb.append("*"); }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
