package BOJ.PS_0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

    문제 접근
    순열로 접근해보았습니다.
                - +1 = 2        .....
      - +1 = 1  - +2 = 3
                - +3 = 4

                - +1 = 3        .....
    0 - +2 = 2  - +2 = 4
                - +3 = 5

                - +1 = 4        ......
      - +3 = 3  - +2 = 5
                - +3 = 6

    문제에서 N은 최대 10까지 가능하므로
    모든 순열을 구하는 과정에서 10이하일 경우를 모두 세면됩니다.

 */

public class BOJ_9095 {
    static int[] arr = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        dfs(0);

        int N;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int value){
        if(value > 10){ return; }
        arr[value] += 1;

        for(int i=1; i<4; i++){ dfs(value + i); }
    }
}
