package BOJ.PS_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    구현문제입니다.
    나이트의 이동은 아래 경우가 있습니다.
    1. X+-1,Y+-2
    2. X+-2,Y+-1
    현재칸에서 다음칸으로 갈 수 있는지 파악하여, 갈 수 없다면 Invalid 를 출력합니다.
    현재칸에서 다음칸으로 갈 수 있지만 이미 방문한 곳이라면 Invalid 를 출력합니다.

    모든 조건을 충족했다면
    마지막 칸에서 시작칸으로 갈 수 있는지 확인하여 갈 수 있다면 Valid
                                                   없다면 Invalid


 */

public class boj1331_Knight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int [6][6];


        String input = br.readLine();
        int startX=input.charAt(0)-'A';
        int startY=input.charAt(1)-'1';
        map[startX][startY]=1;

        int nowX = startX;
        int nowY = startY;

        for (int i = 0; i < 35; i++) {
            input = br.readLine();
            int nextX = input.charAt(0)-'A';
            int nextY = input.charAt(1)-'1';
            if(!isGo(nowX,nowY,nextX,nextY)){ System.out.println("Invalid"); return; }  // 다음 칸으로 갈 수 없다면
            else{
                if(map[nextX][nextY]==1){ System.out.println("Invalid"); return; }      // 이미 방문한 곳이라면
                map[nextX][nextY]=1;
            }
            nowX = nextX;
            nowY = nextY;
        }
        if(isGo(nowX,nowY,startX,startY)){ System.out.println("Valid"); }               // 마지막 칸에서 시작칸으로 갈 수 있다면
        else{ System.out.println("Invalid"); }                                          // 마지막 칸에서 시작카느로 갈 수 없다면
    }

    // 나이트의 이동이 가능한지
    static boolean isGo(int fromX, int fromY, int toX, int toY){
        if(fromX+2==toX){
            if(fromY+1==toY){ return true;}
            if(fromY-1==toY){ return true;}
        }
        if(fromX-2==toX){
            if(fromY+1==toY){ return true;}
            if(fromY-1==toY){ return true;}
        }
        if(fromX+1==toX){
            if(fromY+2==toY){ return true;}
            if(fromY-2==toY){ return true;}
        }
        if(fromX-1==toX){
            if(fromY+2==toY){ return true;}
            if(fromY-2==toY){ return true;}
        }
        return false;
    }
}
