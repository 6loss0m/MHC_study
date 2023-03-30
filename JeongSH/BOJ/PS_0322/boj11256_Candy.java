package BOJ.PS_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/*
    아이디어
    가장 큰 박스부터 사탕을 담아야 가장 적게 박스를 사용할 수 있습니다.

    박스의 크기를 구한뒤 내림차순 정렬을합니다.
    박스에 사탕을 담아 사용한 박스 갯수를 구합니다.

 */

public class boj11256_Candy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] in = br.readLine().split(" ");
            int candy = Integer.parseInt(in[0]);
            int box = Integer.parseInt(in[1]);

            Integer[] arr = new Integer[box];
            for (int i = 0; i < box; i++) {
                in=br.readLine().split(" ");
                arr[i]=Integer.parseInt(in[0])*Integer.parseInt(in[1]);
            }
            Arrays.sort(arr, Collections.reverseOrder());

            int cnt = 0;
            for(int i=0;i<box;i++){
                candy -= arr[i];
                cnt++;
                if(candy<=0){ break; }
            }
            System.out.println(cnt);
        }
    }
}
