package BOJ.BOJ0608;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 접점이 있는 사각형끼리는 펜을 떼지 않고 한 번에 그릴 수 있으므로, 접점이 없는 사각형 집합의 갯수를 구함.
public class Logo_3108 {
    static int N;
    static Rec[] map;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new Rec[N+1];
        visited = new boolean[N+1];

        // 시작점
        map[0] = new Rec(0, 0, 0, 0);

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            map[i] = new Rec(x1, y1, x2, y2);
        }

        for(int i = 0; i<= N; i++) {
            // 이미 그린적이 있는 경우
            if(visited[i]) continue;

            visited[i] = true;
            q.add(i);

            while(!q.isEmpty()) {
                int cur = q.poll();

                for(int j = 0; j <= N; j++) {
                    // 동일 직사각형이거나, 공유하는 부분이 없는 관계거나, 이미 방문한 적이 있으면 건너뜀
                    if(cur == j || !check(cur, j) || visited[j]) {
                        continue;
                    }
                    visited[j] = true;
                    q.add(j);
                }
            }
            cnt++;
        }
        System.out.println(cnt - 1);
    }

    static boolean check(int cur, int next) {
        Rec c = map[cur];
        Rec n = map[next];
        // 아예 접점이 없는 경우
        return (c.x1 >= n.x1 || n.x2 >= c.x2 || c.y1 >= n.y1 || n.y2 >= c.y2)    // C가 N을 내포하는 경우
                && (c.x1 <= n.x1 || n.x2 <= c.x2 || c.y1 <= n.y1 || n.y2 <= c.y2) // N이 C를 내포하는 경우
                && c.x2 >= n.x1 && c.x1 <= n.x2 && c.y2 >= n.y1 && c.y1 <= n.y2;
        // C와 N이 공유하는 부분이 있는 경우
    }

}


class Rec {
    int x1, x2, y1, y2;

    public Rec(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}