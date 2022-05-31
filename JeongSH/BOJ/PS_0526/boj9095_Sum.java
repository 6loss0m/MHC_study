package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    dfs 를 사용한 완전탐색으로 풀이하였습니다.
    dfs(0) -> dfs(1) -> dfs(1+1) -> dfs(1+1+1)......
    dfs(1+1+1+.....+2) -> dfs(1+1+....+2+2) ....

 */

public class boj9095_Sum {
    static int[] arr = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        dfs(0);
        for(int i=0;i<N; i++){
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(int n){
        if(n>10){ return;}
        arr[n]+=1;
        for(int i=1; i<4; i++){ // dfs(0) -> dfs(1) -> dfs(1+1) -> dfs(1+1+1)......
            dfs(n+i);
        }
    }
}
