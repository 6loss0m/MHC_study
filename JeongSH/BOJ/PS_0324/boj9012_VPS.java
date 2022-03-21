package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9012_VPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input;
        Boolean isSkip;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            isSkip = false;
            int ret=0;
            input = br.readLine();
            int size = input.length();

            for(int j=0; j<size; j++){
                if(input.charAt(j) == '('){ret+=1;}
                else {ret-=1;}
                if(ret<0){ sb.append("NO").append("\n"); isSkip = true; break;}
            }
            if(isSkip) {continue;}
            sb.append(ret == 0 ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);

    }
}
