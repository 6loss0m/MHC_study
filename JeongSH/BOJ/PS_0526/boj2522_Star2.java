package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2522_Star2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        for(int i=1;i<=(N*2)-1;i++){
            if(i<=N){
                for(int j=0;j<N-i;j++){
                    sb.append(" ");
                }
                for(int k=0; k<i; k++){
                    sb.append("*");
                }
            }else{
                for(int j=0; j<i%N;j++){
                    sb.append(" ");
                }
                for(int k=0;k<N-(i%N);k++){
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
