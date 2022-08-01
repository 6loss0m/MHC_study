package Programmers.MonthlycodeChallenge.MCC2022_07_27;
import java.util.*;

public class TreeTrioAvg {
    public int solution(int n, int[][] edges) {
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++) list[i] = new ArrayList<Integer>();
        for(int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }

        // 임의의 점 1에서 가장 먼 노드 X를 찾음 (start)
        int start = 1, cnt;
        int[] result = bfs(list, start, n);
        for(int i=2; i<=n; i++)
            if(result[i]>result[start]) start = i;

        // X에서 각 노드까지의 값을 찾음
        cnt = 0;
        result = bfs(list, start, n);
        for(int i=1; i<=n; i++)
            if(result[i]>result[start]) start = i;
        for(int i=1; i<=n; i++) if(result[start]==result[i]) cnt++;
        if(cnt>=2) return result[start]; // 만약 가장 먼 노드가 2개라면 X와 이 두 노드를 선택하면 되므로 리턴

        // X에서 가장 먼 노드인 Y를 기준으로 각 노드까지의 값을 찾음
        cnt = 0;
        result = bfs(list, start, n);
        for(int i=1; i<=n; i++) if(result[start]==result[i]) cnt++;
        if(cnt>=2) return result[start];
        return result[start]-1;
    }
    static int[] bfs(List<Integer>[] list, int start, int n) {
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int i : list[now]) {
                if(visit[i]) continue;
                visit[i] = true;
                queue.add(i);
                dist[i] = dist[now] + 1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {

    }
}
