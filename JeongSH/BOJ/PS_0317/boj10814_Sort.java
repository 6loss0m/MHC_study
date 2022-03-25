package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    sort...


 */


public class boj10814_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N][2];
        String[] name = new String[N];
        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            list[i] = new int[]{Integer.parseInt(input[0]), i};
            name[i] = input[1];
        }
        Arrays.sort(list, (o1, o2) -> {
            if(o1[0]==o2[0]) { return o1[1]-o2[1]; }
            else { return o1[0]-o2[0]; }
        });

        for(int[] a: list){ sb.append(a[0]).append(" ").append(name[a[1]]).append("\n"); }
        System.out.println(sb);
    }
}
