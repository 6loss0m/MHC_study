package BOJ.PS_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제접근
    제한 사항대로 구현하더라도 시간 복잡도 O(N) 이기때문에 단순 구현문제라 판단.

    풀이
    1. 킹이 가야하는 장소에 돌이 있을경우.
        1-1. 돌이 킹과 같은 방향으로 움직일 수 있을 때.
            - 킹도 움직이고 돌도 같은 방향으로 움직여야함.
        1-2. 돌이 킹과 같은 방향으로 움직일때 체스판을 벗어나는 경우.
            - 해당 동작 전부 무시.

    2. 킹이 가야하는 장소에 돌이 없는 경우.
        2-1. 킹이 움직일 수 있을 때
            - 킹을 움직임.
        2-2. 킹이 체스판을 벗어나는경우.
            - 해당 동작무시.

    큰 조건으로 킹이 가야하는 장소에 돌이 있는지 체크.
    작은 조건으로는 움질일 수 있는지 체크.

 */
public class King_1063 {
    static final String[] direction = {"R","L","B","T","RT","LT","RB","LB"};
    static final int[] dx = {1,-1,0,0,1,-1,1,-1};
    static final int[] dy = {0,0,-1,1,1,1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Chess king = new Chess(alphabetToNum(input[0].charAt(0)),(input[0].charAt(1)-'1'));
        Chess stone = new Chess(alphabetToNum(input[1].charAt(0)),(input[1].charAt(1)-'1'));
        int N = Integer.parseInt(input[2]);

        for(int i=0;i<N;i++){
            String in = br.readLine();
            int dir = dirToInt(in);
            if(king.x+dx[dir]==stone.x && king.y+dy[dir]==stone.y) {    // 1. 킹이 가야하는 장소에 돌이 있다면
                if(isRange(stone.x+dx[dir],stone.y+dy[dir])){     // 1-1. 돌이 체스판을 벗어나지 않는다면
                    stone.x+=dx[dir];
                    stone.y+=dy[dir];
                    king.x+=dx[dir];
                    king.y+=dy[dir];
                }
                else{ continue; }                                       // 1-2. 돌이 체스판을 벗어난다면
            }
            else{                                                       // 2. 킹이 가야하는 장소에 돌이 없다면
                if(isRange(king.x+dx[dir], king.y+dy[dir])){      // 2-1. 킹이 움직일 수 있다면
                    king.x+=dx[dir];
                    king.y+=dy[dir];
                }
                else{ continue; }                                       // 2-2. 킹이 움직일 수 없다면
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(numToAlphabet(king.x)).append(king.y+1).append("\n");
        sb.append(numToAlphabet(stone.x)).append(stone.y+1);
        System.out.print(sb);
    }


    static int dirToInt(String dir){                // 방향을 숫자 방향으로
        for(int i=0;i<8;i++){
            if(!dir.equals(direction[i])){continue;}
            return i;
        }
        return -1;
    }
    static int alphabetToNum(char c){ return c-'A'; }   // 영어좌표를 숫자로
    static char numToAlphabet(int n){ return (char)('A'+n); }   // 숫자좌표를 영어로
    static boolean isRange(int x,int y){ return 0<=x && x<8 && 0<=y && y<8; }   // 체스판 범위 확인

    static class Chess{
        int x,y;

        public Chess(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
