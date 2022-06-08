package BOJ.PS_0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10992_Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<N;i++){ sb.append(" "); }
        sb.append("*").append("\n");
        if(N==1){ System.out.print(sb); return;}

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-i; j++){ sb.append(" "); }
            sb.append("*");
            for(int k=1; k<i*2; k++){ sb.append(" "); }
            sb.append("*");
            sb.append("\n");
        }
        for(int i=0; i<N*2-1; i++) {sb.append("*"); }
        System.out.print(sb);
    }
}
