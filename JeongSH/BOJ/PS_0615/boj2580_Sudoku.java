package BOJ.PS_0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    백트레킹문제입니다.
    dfs 를 사용하여 완전탐색을 이용하여 스도쿠를 충족하는지 검사합니다.
    충족하지 않는다면, 가장 갚이 도달한 곳부터 백트레킹을하여 조건이 충족할때까지 탐색합니다.

    스도쿠 충족조건
    1. 넣으려는 칸의 y축에 넣으려는 숫자가 나온다면 충족하지 않습니다.
    2. 넣으려는 칸의 x축에 넣으려는 숫자가 나온다면 충족하지 않습니다.
    3. 전체 칸을 기준으로 3x3 판에 넣으려는 숫자가 나온다면 충족하지않습니다.
        3x3 칸을 나누는 방법
        (현재 x,y 값 / 3) * 3 을 해주면 됩니다.
        ex) (5,3) 의 시작 3x3 x,y 값 -> (3,3)

 */

public class boj2580_Sudoku {
    static int[][] board =new int[9][9];
    static ArrayList<int[]> blank = new ArrayList<>();  // y,x
    static int size=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input;

        for(int i=0;i<9;i++){
            input=br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j]=Integer.parseInt(input[j]);
                if(board[i][j]==0){ blank.add(new int[]{i,j}); size+=1; }
            }
        }
        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static boolean dfs(int index){
        if(index== size ){return true;}     // 1) 이 조건에 들어오는 경우는 모든 칸에 이미 조건을 충족하는 값이 들어온 상태
        int y = blank.get(index)[0];        // true 반환하게되면 57번 줄의 조건이 true 가 되어 모든 dfs 가 끝나게됩니다.
        int x = blank.get(index)[1];
        for(int i=1; i<=9; i++){
            if(isValid(y,x,i)){
                board[y][x]=i;
                if(dfs(index+1)) { return true;}
                board[y][x]=0;             // 3) 다른 가능성이 있는 숫자를 탐색하기위해 마지막 방문을 초기화
            }
        }

        return false;   // 2) 이것을 반환하는 조건은 dfs 해당칸에 조건을 충족하는 값을 넣지 못하는 경우입니다. 즉 dfs(index+1) 이 false 를 반환하므로 백트레킹을 하게됩니다.
    }

    static boolean isValid(int y,int x, int num){
        for(int i=0;i<9;i++){
            if(board[y][i]==num || board[i][x]==num){ return false;}    // 1,2 번조건
        }

        int startX = (x/3)*3;
        int startY = (y/3)*3;
        for(int i=startY; i<startY+3; i++){         // 3번 조건
            for(int j=startX; j<startX+3; j++){
                if(board[i][j]==num){return false;}
            }
        }
        return true;
    }
}
