package BOJ.PS_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    가장 큰 정사각형이 될 수 있는 한변의 길이는
    N,M 중 작은값입니다.
    N,M 중 작은 값 부터 -1 씩 하여 모든 정사각형을 탐색합니다.

    1. N,M 중 작은 값이 최대 변의 길이 (len)
    2. len 을 -1 씩 하며 모든 정사각형을 탐색합니다.
    3. 모든 꼭지점이 같은 숫자면 넓이를 출력합니다.
 */

public class boj1051_Square {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[50][50];
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i=0;i<N;i++){
            String in = br.readLine();
            for(int j=0;j<M;j++){ map[i][j]=in.charAt(j)-'0'; }
        }

        for(int len = Math.min(N,M); len > 0; len--){
            for(int i=0; i<= N-len; i++){
                for(int j=0; j<= M-len; j++){
                    int n = map[i][j];
                    if(n==map[i][j+len-1] && n==map[i+len-1][j] && n==map[i+len-1][j+len-1]){
                        System.out.println(len*len);
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }
}
