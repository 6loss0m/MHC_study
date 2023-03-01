package BOJ.PS_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제의 제한 사항에따라
    가장 왼쪽 위 부터 탐색을 진행해야 합니다.
    1. 동 남동 남 남서 방향으로 탐색.

    재귀식으로 각 칸의 방향별로 이어진 바둑돌 갯수를 세어 저장합니다.
    해당칸이 5 일 경우만 정답이기때문에 5일 경우 해당 색의 돌이 이기게됩니다.

 */

public class boj2615_Omok {
    static int[][] map = new int[21][21];
    static int[][][] visit = new int[21][21][4];
    static int[] dx = { 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 19; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= 19; j++) {
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                if(map[i][j]==0){continue;}
                for (int d = 0; d < 4; d++) {       // 네 방향으로 탐색
                    if (visit[i][j][d] == 0 && go(i, j, d, map[i][j]) == 5) {
                        System.out.println(map[i][j]+"\n"+i+" "+j);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static int go(int x, int y, int dir, int color) {   // 주어진 방향으로 계속 탐색
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (map[nx][ny] == color) {
            return visit[nx][ny][dir] = go(nx, ny, dir, color) + 1;     // 재귀식으로 저장.
        }
        return 1;
    }

}