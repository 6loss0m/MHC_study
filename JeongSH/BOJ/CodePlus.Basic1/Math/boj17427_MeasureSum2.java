package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj17427_MeasureSum2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum=0;
        for(int i=1; i<=n; i++){
            sum+=(n/i)*i;
        }
        System.out.println(sum);
    }
}
