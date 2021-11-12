
import java.util.Arrays;
/*
    topDown(n,m) -> t(n,m) 으로 표기.
    해당 문제의 점화식을 세워보면
    t(n,m)=t(n-1)+t(m-1)
    이전의 방식으로 시간초과가 떴기때문에 시간복잡도를 낮추기 위해
    boolean[][] DICT 를 이용해서 이미 탐색했던 길이라면 바로 t(y,x) 값을 리턴하게 함.
    int[][] MAP 은 각각의 좌표로 갈 수 있는 경우의 수를 넣음.

    해당 test-case를 이용하여 구한 MAP의 마지막 모습.
    1 1 1 1
    1 0 1 2
    1 1 2 4

 */

public class RoadToSchool2 {
    static int[][] MAP;
    static boolean[][] DICT;
    static int DIV_VALUE = 1000000007;
    public static void main(String args[]){
        int m=4;
        int n=3;
        int puddles[][] = {{2,2}};
        MAP = new int[n][m];
        DICT = new boolean[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(MAP[i],1);                  //모든 MAP의 좌표의 경우의 수를 1로 초기화
            Arrays.fill(DICT[i],false);             //모든 DICT 를 false로 초기화
        }
        for(int i=0; i<puddles.length; i++){
            MAP[puddles[i][1]-1][puddles[i][0]-1]=0;        //puddle 위치 표시
            DICT[puddles[i][1]-1][puddles[i][0]-1]=true;    //puddle 위치 표시
        }

        System.out.println("answer: "+topDown(n-1,m-1,puddles));
    }
    public static int topDown(int y, int x, int[][] puddles){
        if(x<0 || y<0){return 0;}                           // 시작점을 벗어난경우
        if(x==0 && y==0){return MAP[y][x];}                 // 시작점
        if(DICT[y][x]==true){return MAP[y][x];}             // 이미 방문한 경우
        DICT[y][x]=true;                                    // 방문하였기때문에 true 로
        return MAP[y][x]=(topDown(y-1,x,puddles)+topDown(y,x-1,puddles))%DIV_VALUE;
        // 점화식 t(n,m) = t(n-1,m)+ t(n,m-1)
    }
}
