package BOJ.PS_0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제의 입력조건을 보면 완전탐색을 하더라도 시간초과가 발생하지않습니다.
    dfs 를 통해 완전탐색을 했습니다.
    각각 인덱스를 선택하거, 선택하지않거나 두 가지를 모두 검사합니다.
    마지막 인덱스에 도착하게되면 각각 갈림길에서 더한 숫자를 보고 만들수있는 숫자를 체크합니다.

    출력할 때 가장 먼저 만나게되는 만들수없는 숫자를 출력합니다.

 */

public class boj14225_SubSequenceSum {
    static int N;
    static int[] arr = new int[20];
    static boolean[] possible = new boolean[20*100000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) { arr[i]=Integer.parseInt(input[i]); }

        dfs(0,0);
        int idx=0;
        while (true){
            if(!possible[idx]){ System.out.println(idx);break; }
            idx+=1;
        }
    }
    static void dfs(int idx, int sum){
        if(idx == N){ possible[sum]=true; return;}
        dfs(idx+1,sum+arr[idx]);    // 현재 idx 를 선택하거나
        dfs(idx+1, sum);                 // 선택하지않거나.
    }
}
