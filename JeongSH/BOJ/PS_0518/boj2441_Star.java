package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2441_Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());

        for(int i=N; i>0; i--){
            for(int k=0; k<N-i; k++){ sb.append(" "); }
            for(int j=i; j>0; j--){ sb.append("*"); }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
