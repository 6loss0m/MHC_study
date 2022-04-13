package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1934_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            int min = Math.min(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            int max = Math.max(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            for(int j=1; j<=min; j++){
                if((max*j)%min==0){ sb.append(j*max).append("\n"); break;}
            }
        }
        System.out.println(sb);
    }
}
