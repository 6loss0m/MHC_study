package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
/*
    DFS,BFS 상관없이 완전탐색을 해주면됩니다.
    방문체크는 set을 사용하여 현재 상황을 문자열로 변환하여 체크합니다.
    물통의 모든 경우의 수를 생각하여 조건문을 작성하면됩니다.
    A->B
    B->A
    C->A
    C->B
    A->C
    B->C
 */

public class boj2251_Bucket {
    static int MaxA,MaxB,MaxC;
    static HashSet<String> visit = new HashSet<>();
    static ArrayList<Integer> ans = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input = br.readLine().split(" ");
        MaxA = Integer.parseInt(input[0]);
        MaxB = Integer.parseInt(input[1]);
        MaxC = Integer.parseInt(input[2]);

        dfs(0,0,MaxC);
        Collections.sort(ans);

        for(Integer n : ans){ sb.append(n).append(" "); }

        System.out.println(sb);
    }
    static void dfs(int a, int b, int c){
        if(visit.contains(""+a+b+c)){ return;}
        if(a==0){ ans.add(c); }
        visit.add(""+a+b+c);
        //A -> B
        if(a+b > MaxB){ dfs((a+b)-MaxB, MaxB, c); }
        else{ dfs(0,a+b,c); }
        //B -> A
        if(a+b > MaxA){ dfs(MaxA,a+b-MaxA,c); }
        else{ dfs(a+b,0,c); }
        //C -> A
        if(a+c > MaxA){ dfs(MaxA,b,a+c-MaxA); }
        else{ dfs(a+c,b,0);}
        //C -> B
        if(b+c>MaxB){ dfs(a,MaxB,b+c-MaxB); }
        else { dfs(a,b+c,0); }

        //A -> C
        dfs(a,0,b+c);   // 최대치는 C보다 많을 수 없기때문.
        //B -> C
        dfs(0,b,a+c);   // 최대치는 C보다 많을 수 없기때문.
    }
}
