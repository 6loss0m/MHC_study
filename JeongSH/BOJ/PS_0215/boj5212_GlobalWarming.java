package BOJ.PS_0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    입력 범위가 작기때문에 단순 구현문제 입니다. (1 ≤ R, C ≤ 10)

    조건을 짤 때 주변에 바다의 갯수를 세는 것 보다 섬의 갯수를 세는게 편하여
    각 섬마다 주변의 섬 갯수를 세어 1개 이하면 가라앉는 섬 list 에 추가하여
    한번에 섬을 가라앉게 하였습니다.

    1. 섬을 만나면 주변의 섬의 갯수를 파악
    2. 주변 섬이 1개 이하면 가라앉는 섬 list 에 추가
    3. 만들어진 가라앉는 섬 list 를 보고 map 수정
    4. map 이 작아져야 하므로 시작 x,y 끝 x,y 를 구하여 출력

 */

public class boj5212_GlobalWarming {
    static char[][] map ;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int R,C;
    static ArrayList<int[]> down = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new char[10][10];
        for (int i = 0; i < R; i++) {
            String in = br.readLine();
            for (int j = 0; j < C; j++) { map[i][j]=in.charAt(j); }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='X'){ down(i,j); }
            }
        }

        for(int[] arr : down){ map[arr[0]][arr[1]]='.'; }

        int startX=getStartX();
        int endX=getEndX();
        int startY=getStartY();
        int endY=getEndY();

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void down(int r, int c){
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = c+dx[i];
            int nextY = r+dy[i];
            if(isRange(nextY,nextX) && map[nextY][nextX]=='X'){ cnt ++; }
        }
        if(cnt<=1){ down.add(new int[]{r,c}); }
    }

    static boolean isRange(int r, int c){ return 0<=r && r<R && 0<=c && c<C; }
    static int getStartX() {
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if(map[j][i]=='X'){ return i;}
            }
        }
        return -1;
    }
    static int getEndX(){
        for(int i=C-1; i>=0; i--){
            for (int j = 0; j < R; j++) {
                if(map[j][i]=='X'){ return i;}
            }
        }
        return -1;
    }
    static int getStartY(){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='X'){return i;}
            }
        }
        return -1;
    }
    static int getEndY(){
        for (int i = R-1; i>=0; i--) {
            for (int j = 0; j < C; j++) {
                if(map[i][j]=='X'){return i;}
            }
        }
        return -1;
    }
}
