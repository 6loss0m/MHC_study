package KaKaoWinterIntern;
/*

    stack 을 사용한 간단한 구현문제.
    인형을 집어서 스택의 최상단과 비교한 후 같으면, pop 해줍니다.
    아니면 push 합니다.

 */
import java.util.Stack;

public class Crane {
    public static void main(String args[]){
        System.out.println(solution(new int [][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[] {1,5,3,5,1,2,1,4}));
    }
    public static int solution(int[][] board, int[] moves){
        int answer=0;
        Stack<Integer> stack= new Stack<>();
        for(int i=0; i<moves.length; i++){
            int doll = getDoll(board,moves[i]);
            if(doll != 0){
                if(!stack.isEmpty()&&stack.peek()==doll){ stack.pop(); answer+=2;}
                else{ stack.push(doll);}
            }
        }
        return answer;
    }
    public static int getDoll(int[][] board, int n){
        int maxY = board.length;
        int doll =0;
        for(int y=0; y<maxY ; y++){
            if(board[y][n-1]!=0){doll = board[y][n-1]; board[y][n-1]=0; return doll;}
        }
        return 0;
    }
}
