package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
    간단한 BFS 문제입니다.
    방문체크를 하지않으면, 제자리로 왔다갔다 하므로 메모리를 초과하게됩니다.
    방문체크는 배열로 했으며 배열의 인덱스에 주의하면서 방문합니다.

 */

public class boj1697_HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] visit = new int[1000001];
        Queue<int[]> q = new LinkedList<>();
        String[] input=br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        visit[start]=1;
        q.add(new int[]{start,0});
        while (!q.isEmpty()){
            int[] tmp = q.poll();
            int now = tmp[0];
            int time = tmp[1];
            if(now == end){ System.out.println(time); break; }

            if(now+1<1000001 && visit[now+1]==0) {      // 최대 지점을 넘지않아야합니다.
                visit[now+1]=1;
                q.add(new int[]{now + 1, time + 1});
            }
            if(now*2<1000001 && visit[now*2]==0){       // 최대 목표지점은 1000000 이므로 이는 500000*2 이므로.
                visit[now*2]=1;                         // now 인자가 5000000 보다 클 수 없습니다.
                q.add(new int[]{now*2,time+1});
            }
            if(0<=now-1 && visit[now-1]==0){            // 배열인덱스가 음수로 가지못하게 합니다.
                visit[now-1]=1;
                q.add(new int[]{now-1,time+1});
            }

        }
    }
}
