package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2446_Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());:
        for(int i=N; i>0; i--){
            for(int j=1; j<=(N-i); j++){ sb.append(" "); }
            for(int k=1; k<=2*i-1; k++){ sb.append("*"); }
            sb.append("\n");
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<=(N-i); j++){ sb.append(" "); }
            for(int k=1; k<=2*i-1; k++){ sb.append("*"); }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
