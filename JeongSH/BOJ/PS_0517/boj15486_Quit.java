package BOJ.PS_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    일의 시작과 끝나는 날을 기준으로 dp를 생각했습니다.

    아이디어
    dp[i] = i-1 까지의 최대 수익
    1. 일이 끝나는날엔 수익이 들어옵니다.
        -> dp[i+기간] = dp[i]+job[i].price
        -> 이미 이전날에 수익을 올렸을 수도있으므로 자기 자신과도 비교해야합니다.
        -> dp[i+기간] = max( dp[i+기간] , dp[i]+job[i].price )
        -> ex) 1일의 작업이 5일날 끝나고, 2일의 작업이 5일날 끝날경우 비교를 해야 하므로
    2. i 날의 수익은
        -> 이전날까지의 수익 vs i 에 끝나는 일의 수익을 비교

 */

public class boj15486_Quit {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Job[] jobs = new Job[1500051];
        int[] dp = new int[1500051];

        int N = Integer.parseInt(br.readLine());

        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            jobs[i] = new Job(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1]));
        }

        for (int i = 0; i < N; i++) {
            int howLong = jobs[i].time;
            dp[i+howLong] = Math.max(dp[i+howLong],dp[i]+jobs[i].price);
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        System.out.println(dp[N]);
    }
    static class Job {
        int time;
        int price;

        public Job(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }
}
