package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10818_MaxMin {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int num;

        int N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int i=0;i<N; i++){
            num = Integer.parseInt(input[i]);
            if(max<num){max=num;}
            if(min>num){min=num;}
        }
        System.out.println(min+" "+max);

    }
}
