package BOJ.BOJ0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
처음 생각 빈 문자열 만들어서 contain함수로 더해가면서 특정 문자가 있는지 확인하는 줄 알았지만
그게 아니라 알파벳26개의 불린 배열을 만들어서 상하좌우를 돌면서 방문하지 않았으면 불린 배열을 true로 바꾸고 cnt를 더해가면서
cnt를 늘려 나간다. 만약 이미 방문한 경험이 있는 알파벳을 방문 하면 그 cnt를 max함수를 통해서 answer와 비교후 큰 값을 저장한다.

*/
public class Alphabet_1987 {
    static int r,c;
    static int[][] map;
    static boolean[] check = new boolean[26];
    static int answer = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j)-'A';
            }
        }
        dfs(0,0,0);
    }
    public static void dfs(int x, int y, int cnt){
        if(check[map[x][y]]){
            answer = Math.max(answer, cnt);
        }
        else{
            check[map[x][y]] = true;
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<r && cy<r){
                    dfs(cx,cy,cnt+1);
                }
            }
            check[map[x][y]] = false;
        }
    }
}
