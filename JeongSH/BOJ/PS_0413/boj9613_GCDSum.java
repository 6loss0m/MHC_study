package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    유클리드 호제법으로 GCD 를 구합니다.
    sum 의 범위는 int 범위를 넘습니다..

 */

public class boj9613_GCDSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[100];
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            int len = Integer.parseInt(input[0]);
            for(int i=0; i<len; i++){ arr[i]=Integer.parseInt(input[i+1]); }
            long sum=0;
            for(int i=0; i<len-1; i++){
                for(int j=i+1; j<len; j++){
                    sum += gcd(arr[i],arr[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
    static int gcd(int a, int b){
        if(b==0) {return a;}
        return gcd(b,a%b);
    }
}
