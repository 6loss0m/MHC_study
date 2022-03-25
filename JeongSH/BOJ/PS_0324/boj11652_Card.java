package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    sort....

 */

public class boj11652_Card {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       long[] arr = new long[N];
       for(int i=0; i<N; i++){ arr[i]=Long.parseLong(br.readLine()); }
       Arrays.sort(arr);
       int max=0;
       int maxIdx=0;
       int i=1;
       int cnt = 0;
       while (i<N){
           if(arr[i]==arr[i-1]){ cnt+=1;
               if(max < cnt){
                   max = cnt;
                   maxIdx = i;
               }
           }
           else{ cnt = 0; }
           i++;
       }
        System.out.println(arr[maxIdx]);

    }
}
