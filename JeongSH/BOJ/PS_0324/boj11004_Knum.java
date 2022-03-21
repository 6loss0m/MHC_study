package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    sort...

 */


public class boj11004_Knum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){ arr[i] = Integer.parseInt(input[i]); }

        Arrays.sort(arr);
        System.out.println(arr[K-1]);
    }
}
