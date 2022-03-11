package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1929 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] strArr = br.readLine().split(" ");
        int M = Integer.parseInt(strArr[0]);
        int N = Integer.parseInt(strArr[1]);
        Boolean[] isDecimal = new Boolean[1000001];
        Arrays.fill(isDecimal,true);
        isDecimal[1]=false;
        for(int i=2; i<1000000; i++){
            for(int j=2; i*j<1000000; j++){
                isDecimal[i*j]=false;
            }
        }
        for(int i=M; i<=N; i++) {
            if(isDecimal[i]){sb.append(i+"\n");}
        }
        System.out.println(sb);
    }
}
