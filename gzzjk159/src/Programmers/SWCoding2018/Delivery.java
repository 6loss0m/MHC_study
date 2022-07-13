package Programmers.SWCoding2018;

public class Delivery {
    static class Solution {
        public int solution(int N, int[][] road, int K) {
            int[][] map = new int[N][N];

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if (i == j) {
                        map[i][j] = 0;
                        continue;
                    }
                    map[i][j] = 500001;
                }
            }

            for (int[] ints : road) {
                if (map[ints[0] - 1][ints[1] - 1] < ints[2])
                    continue;
                map[ints[0] - 1][ints[1] - 1] = ints[2];
                map[ints[1] - 1][ints[0] - 1] = ints[2];
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
            int count = 0;

            for (int i = 0; i < map.length; i++) {
                if (map[0][i] <= K)
                    count++;
            }
            return count;
        }
    }
}
