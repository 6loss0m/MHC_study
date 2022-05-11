package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    배열 정렬..

 */

public class boj11728_ArrSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[2000000];
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        for(int i=0;i<N ;i++){ arr[i] = Integer.parseInt(input[i]); }

        input = br.readLine().split(" ");
        for(int i=0;i<M; i++){ arr[i+N]=Integer.parseInt(input[i]);}
        Arrays.sort(arr,0,M+N);
        for(int i=0;i<M+N;i++) {sb.append(arr[i]).append(" ");}
        System.out.println(sb);

    }
}
