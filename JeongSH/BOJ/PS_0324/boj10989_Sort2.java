package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    sort...

 */

public class boj10989_Sort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){ arr[i]=Integer.parseInt(br.readLine()); }
        Arrays.sort(arr);
        for(int i=0; i<N; i++){ sb.append(arr[i]).append("\n"); }
        System.out.println(sb);
    }
}
