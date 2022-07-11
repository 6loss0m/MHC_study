package BOJ.BOJ0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
처음 생각 -> 조합문제라고 생각함
다만 조합이긴 한데 저번에 풀었던 패스워드 문제처럼 뽑는 수의 개수가 고정이 아니라 1~n까지로 다 해봐야 한다.
어떻게 해야할지 몰라서 찾아보았다.
찾아보니 단순하게 생각해서 dfs로 두 갈래로 나누어서 풀었다.
depth를 추가하여 그 배열 인덱스를 더하거나 더하지 않는 것으로 풀었다.
*/
public class SubsequenceSum_1182 {
    static int[] num;
    static int n;
    static int s;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        String[] scan = br.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(scan[i]);
        }
        dfs(0,0);
        System.out.println(s==0? --answer: answer);
    }
    public static void dfs(int depth, int sum){
        if(depth==n){
            if(sum==s){
                answer++;
            }
            return;
        }
        dfs(depth+1, sum + num[depth]);
        dfs(depth+1,sum);
    }
}
