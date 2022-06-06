package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2445_Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=(2*N)-1;i++){
            if(i<=N){
                for(int j=N-i; j<N;j++){sb.append("*");}
                for(int k=(2*(N-i));k>0;k--){ sb.append(" "); }

                if(i<=N){
                    for(int j=N-i; j<N;j++){sb.append("*");}
                }
            }

            if(i>N){
                for(int l=0;l<(2*N)-i;l++){sb.append("*");}
                for(int h=0;h<(i%N)*2;h++){
                    sb.append(" ");
                }
                for(int l=0;l<(2*N)-i;l++){sb.append("*");}
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
