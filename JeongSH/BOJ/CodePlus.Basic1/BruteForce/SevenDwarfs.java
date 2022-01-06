package CodePlus.Basic1.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SevenDwarfs {
    static int[] visit;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] dwarfs = new int[9];
        int[] answer = new int[7];
        visit = new int[9];
        int i=0;
        while (i<9){ dwarfs[i++]=Integer.parseInt(br.readLine()); }
        Arrays.sort(dwarfs);
        dfs(dwarfs,answer,0,0);
        for(int e: answer){sb.append(e+"\n");}
        System.out.println(sb);
    }
    public static int[] dfs(int[] dwarfs, int[] answers, int depth, int sum){
        if(depth==7){if(sum==100){return answers;} return null;}
        for(int i=0; i<dwarfs.length; i++) {
            if(visit[i]!=0){continue;}
            visit[i]=1;
            sum += dwarfs[i];
            answers[depth] = dwarfs[i];
            if(dfs(dwarfs, answers, depth + 1, sum)!=null){return answers;}
            sum -= dwarfs[i];
            visit[i]=0;
        }
        return null;
    }
}
