package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2609_GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int GCF=0;    // 최대공약수
        int LCM=0;    // 최소공배수
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int N = A*B+1;
        for(int i=1; i<N; i++){
            if((A%i==0) && (B%i==0)){ GCF = i;}
            if((i%A==0) && (i%B==0)){ LCM = i; break;}
        }
        System.out.println(GCF);
        System.out.println(LCM);
    }
}
