package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    dfs 로 모든 수열을 구한 뒤
    모두 계산해 줍니다.
 */

public class boj10819_MaxDiff {
    static int N ;
    static int[] tmp = new int[8];
    static int[] arr = new int[8];
    static int[] visit = new int[8];
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input=br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(input[i]);
        }
        dfs(0);
        System.out.println(max);
    }
    static void dfs(int cnt){
        if(cnt == N){
            max = Math.max(cal(),max);
        }
        for(int i=0; i<N; i++){
            if(visit[i]==1){continue;}
            visit[i]=1;
            tmp[cnt] = arr[i];
            dfs(cnt+1);
            visit[i]=0;
        }
    }
    static int cal(){
        int sum = 0;
        for(int i=0;i<N-1;i++){
            sum += Math.abs(tmp[i]-tmp[i+1]);
        }
        return sum;
    }
}
