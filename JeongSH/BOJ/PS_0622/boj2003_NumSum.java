package BOJ.PS_0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    dfs 로 먼저 풀이해 보았습니다. (사실상 2중 for 문 )
    풀고나서 찾아보니 투포인트로 해결할 수 있는 문제였습니다.
    start, end 를 두고 구간합을 구하게되면 시간복잡도 2N 으로 풀이할 수 있습니다.

 */

public class boj2003_NumSum {
    static int N,M;
    static int[] arr = new int[10000];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) { arr[i]=Integer.parseInt(input[i]); }

//
//        for(int i=0; i<N; i++){ dfs(arr[i],i); }
//        System.out.println(count);

        int s=0, e=0, sum=0;
        while (true){
            if(sum>=M){ sum-=arr[s++]; }
            else{
                if(e==N){ break;}
                sum += arr[e++]; }
            if(sum==M) {count+=1;}
        }
        System.out.println(count);
    }

    static void dfs(int sum, int idx){
        if(sum > M) { return; }
        if(sum == M) { count+=1; return; }
        if(idx+1<N){ dfs(sum+arr[idx+1], idx+1); }
    }
}
