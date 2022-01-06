package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj6588_Goldvach {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Boolean[] isNotDecimal = new Boolean[1000001];
        StringBuffer sb = new StringBuffer();

        for(int i=2;i<1000001;i++){
            if(isNotDecimal[i]!=null) continue;
            for(int j=2*i; j<1000001 ; j+=i){
                isNotDecimal[j]=true;
            }
        }
        int n;
        while ((n=Integer.parseInt(br.readLine()))!=0) {
            for(int i=3;i<n; i++){
                int j=n-i;
                if(isNotDecimal[i]==null && isNotDecimal[j]==null){
                    sb.append(n+" = "+i+" + "+j+"\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
