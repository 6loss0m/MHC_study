package BOJ.BOJ0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class SequenceSum_14225 {
    static int n;
    static HashSet<Integer> hash = new HashSet<>();
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        num = new int[n];
        for (int i = 0; i < n; i++) {
            hash.add(Integer.parseInt(input[i]));
            num[i] = Integer.parseInt(input[i]);
        }

        dfs(0,0);
        for (int i = 1; i < 100002; i++) {
            if(!hash.contains(i)){
                System.out.println(i);
                break;
            }
        }
    }
    public static void dfs(int depth, int sum){
        if(depth==n){
            hash.add(sum);
            return;
        }
        dfs(depth+1, sum+num[depth]);
        dfs(depth+1, sum);
    }
}
