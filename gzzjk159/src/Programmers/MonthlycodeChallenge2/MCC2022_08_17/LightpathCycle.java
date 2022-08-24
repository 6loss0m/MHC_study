package Programmers.MonthlycodeChallenge2.MCC2022_08_17;

import java.util.ArrayList;

public class LightpathCycle {
    static int R, C;
    static int[] dr = { 1, 0, -1, 0 }, dc = { 0, -1, 0, 1 }; // 아래, 왼, 위, 오른
    static boolean[][][] visited;
    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        R = grid.length;
        C = grid[0].length();

        visited = new boolean[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 4; k++) {
                    if(!visited[i][j][k]){
                        answer.add(light(grid, i,j,k));
                    }
                }
            }
        }
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }
    public static int light(String[] grid, int r, int c, int d){
        int cnt = 0;
        while (!visited[r][c][d]) {
            cnt++;    // 거리증가
            visited[r][c][d] = true; // 방문처리

            if (grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d - 1; // 좌회전
            else if (grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d + 1; // 우회전

            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        return cnt;
    }
    public static void main(String[] args) {




    }
}
