package BOJ.PS_0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    백트레킹을 사용하는 문제입니다.
    boolean[] alphabet 을 선언하여 여태 지나온 알파벳을 체크해줍니다.
    현재까지 들어간 depth 를 반환하여 가장 큰 값을 저장합니다.

 */

public class boj1987_Alphabet {
    static boolean[] alphabet = new boolean[26];
    static char[][] board = new char[20][20];
    static int R,C;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        for(int i=0; i<R; i++){
            String in = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j]=in.charAt(j);
            }
        }
        alphabet[board[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(count);
    }

    static int dfs(int y, int x, int depth){
        for(int i=0;i<4;i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(isRange(ny,nx) && !alphabet[board[ny][nx]-'A']){
                alphabet[board[ny][nx]-'A'] = true;
                int ret = dfs(ny,nx,depth+1);         // 현재까지의 depth
                if( count < ret ){ count = ret; }           // 최대값 저장
                alphabet[board[ny][nx]-'A'] = false;
            }
        }
        return depth;
    }

    static boolean isRange(int y,int x) { return 0<=y && y<R && 0<=x && x<C; }
}
