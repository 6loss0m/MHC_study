package BOJ.BOJ0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
아이디어
일단 이중 포문을 돈다.
해당 인덱스 i, j를 돌면서
1. i행 비교
2. j열 비교
3. 작은 사각형 비교
를 해야 할거 같다.
*/
public class Sudoku_2580 {
    static int[][] map = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs(0,0);
    }
    public static void dfs(int row, int col){
        if(col==9){
            dfs(row+1,0);
            return;
        }
        if(row==9){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);

            System.exit(0);
        }
        if(map[row][col]==0){
            for (int i = 1; i <=9; i++) {
                if(check(row,col,i)){
                    map[row][col] = i;
                    dfs(row,col+1);
                }
            }
            map[row][col] = 0;
            return;
        }
        dfs(row, col+1);
    }
    public static boolean check(int row, int col, int value){
        for (int i = 0; i < 9; i++) {
            if(map[row][i]==value){ return false; }
        }
        for (int i = 0; i < 9; i++) {
            if(map[i][col]==value){ return false; }
        }
        int sdk_row = (row/3)*3;
        int sdk_col = (col/3)*3;
        for (int i = sdk_row; i < sdk_row+3; i++) {
            for (int j = sdk_col; j < sdk_col+3; j++) {
                if(map[i][j] == value){ return false; }
            }
        }
        return true;
    }
}
