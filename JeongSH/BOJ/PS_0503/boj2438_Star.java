package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2438_Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine())+1;
        for(int i=1; i<N;i++){
            for(int j=0; j<i; j++){ sb.append("*"); }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
