package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
    문제의 알고리즘 자체는 어렵지않지만
    문제의 메모리조건을 맞춰야하는 문제입니다.
    3x3 배열로 고정인 점과 10^9 은 int 범위 내라는걸 생각하고 풀이해야합니다.
    3x3 배열의 크기는 int*9 지만, 이를 하나의 숫자로 보면 int 한 개 만큼의 메모리를 차지합니다.

    아이디어
    0. 최소 이동횟수를 구해야하므로 BFS 를 사용합니다.
    1. 배열을 하나의 숫자로 만들어서 저장합니다. ex) 123456780
    2. 0을 9로 바꿔줍니다.
        - 0이 맨 앞의 자리로 가게되면 012345678 -> 8자리 숫자가 되기때문.
    3. 배열을 하나의 데이터(String or int)로 보고 배열을 조작하듯이 배열을 수정합니다.

 */

public class boj1525_Puzzle {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static final String ANSWER = "123456789";   // 미리 답을 만들어 줍니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> queue = new LinkedList<>();       // 퍼즐을 하나의 String 으로 봅니다. ex) 123456789
        HashMap<String, Integer> visit = new HashMap<>();   // 방문체크와 몇번 움직였는지 체크

        String start = "";
        for (int i = 0; i < 3; i++) {
            start += br.readLine().replace(" ", "");
        }
        start = start.replace("0", "9");    // 0 -> 9

        queue.add(start);
        visit.put(start, 0);
        while (!queue.isEmpty()) {
            String puzzle = queue.poll();

            if (puzzle.equals(ANSWER)) {
                System.out.println(visit.get(ANSWER));
                return;
            }

            int blankIdx = puzzle.indexOf("9");     // 9가 어디있는지
            int y = blankIdx / 3;                   // 2차원 배열일 경우 y
            int x = blankIdx % 3;                   // 2차원 배열일 경우 x
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny > 2 || nx < 0 || nx > 2) { continue; }

                StringBuilder sb = new StringBuilder(puzzle);
                char tmp = sb.charAt(ny * 3 + nx);
                sb.setCharAt(blankIdx, tmp);                // 9와 이동가능한 숫자와 자리를 바꿈.
                sb.setCharAt(ny * 3 + nx, '9');

                String nextPuzzle = sb.toString();
                if (!visit.containsKey(nextPuzzle)) {   // 퍼즐의 모양이 방문하지않은 모양일 경우
                    visit.put(nextPuzzle, visit.get(puzzle) + 1);   // 현재의 움직인 횟수+1
                    queue.add(nextPuzzle);
                }
            }
        }
        System.out.println(-1);
    }
}