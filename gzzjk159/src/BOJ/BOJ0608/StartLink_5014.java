package BOJ.BOJ0608;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class StartLink_5014 {
    static int now;
    static int goal;
    static int[] check = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max_f = Integer.parseInt(st.nextToken());
        now = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        if (goal == now ){
            System.out.println(0);
        }
        else{
            bfs(now,u,d,max_f);
        }

    }
    static void bfs(int num, int up, int down, int max){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        check[num] = 1;
        int next;

        while(!q.isEmpty()){
            int temp = q.poll();

            for (int i = 0; i < 2; i++) {
                if (i==0){
                    next = temp + up;
                }
                else{
                    next = temp - down;
                }
                if (next == goal){
                    System.out.println(check[temp]);
                    return;
                }
                if (next>=1 && next<max+1 && check[next]==0){
                    q.add(next);
                    check[next] = check[temp]+1;
                }
            }
        }
        System.out.println("use the stairs");
    };
}
