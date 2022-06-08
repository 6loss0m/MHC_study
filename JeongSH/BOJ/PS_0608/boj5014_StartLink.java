package BOJ.PS_0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*

    간단한 BFS 문제입니다.
    최소값을 구해야 하므로 bfs 를 사용합니다.

    현재층과, 버튼횟수를 큐에 저장합니다.

 */

public class boj5014_StartLink {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new LinkedList<>();    // 큐의 배열은 {현재층, 버튼횟수}
        boolean[] visit = new boolean[1000001];

        String[] input = br.readLine().split(" ");
        //F, S, G, U, D
        int F = Integer.parseInt(input[0]); // 건물 총 층
        int S = Integer.parseInt(input[1]); // 강호의 현재 층
        int G = Integer.parseInt(input[2]); // 스타트링크 층
        int U = Integer.parseInt(input[3]); // U 층 올라가는 버튼
        int D = Integer.parseInt(input[4]); // D 층 내려가는 버튼

        queue.add(new int[]{S,0});  // {현재층, 버튼횟수}
        visit[S]=true;

        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            int now = tmp[0];
            int count = tmp[1];

            if(now==G){ System.out.println(count); return; }

            if(now+U <= F && !visit[now+U]){ queue.add(new int[]{now+U, count+1}); visit[now+U]=true; }
            if(now-D >= 1 && !visit[now-D]){ queue.add(new int[]{now-D, count+1}); visit[now-D]=true; }
        }
        System.out.println("use the stairs");
    }
}
