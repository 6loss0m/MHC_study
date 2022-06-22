package BOJ.PS_0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    간단한 조합문제입니다.

    조건 중 조심해야하는 것은 S=0 일 때,
    부분수열은 최소 하나이상의 숫자를 포함하고있어야 하므로, depth > 0 이라는 조건을 추가해야합니다.

 */

public class boj1182_Subsequence{
    static int N,S;
    static int count=0;
    static int[] arr=new int[20];
    static boolean[] visit = new boolean[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) { arr[i]=Integer.parseInt(input[i]); }

        dfs(0,0,0);
        System.out.println(count);
    }
    static void dfs(int idx, int sum, int depth){
        if(sum==S && depth>0 ) { count+=1; }    // 현재 부분수열의 합이 S 이고, 최소 하나이상의 숫자를 포함하고있다면

        for(int i=idx; i<N; i++){
            if(!visit[i]){
                visit[i]=true;
                dfs(i,sum+arr[i],depth+1);
                visit[i]=false;
            }
        }
    }
}
