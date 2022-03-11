package BOJ.PS_0113;

/**
 * 정렬 문제.
 * 정렬 합시다.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11650 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++){
            String tmp[] = br.readLine().split(" ");
            arr[i][0]=Integer.parseInt(tmp[0]);
            arr[i][1]=Integer.parseInt(tmp[1]);
        }
        Arrays.sort(arr, (o1, o2) -> { if(o1[0]!=o2[0]){ return o1[0]-o2[0];}       // x 값이 다르면 x 값으로 정렬
                                                         return o1[1]-o2[1]; });    // 같다면 y 값으로 정렬
        for(int i=0; i<n; i++){
            sb.append(arr[i][0]+" "+arr[i][1]+"\n");
        }
        System.out.println(sb);
    }
}
