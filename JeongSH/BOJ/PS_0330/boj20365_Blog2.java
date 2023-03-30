package BOJ.PS_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    BBRBRBBR
    BB B BB         : 3
      R R  R        : 3

    BRRRRB
    B    B          : 2
     RRRR           : 1

    1. 연속된 같은 색끼리 하나의 그룹으로 묶는다
    2. 그룹이 더 많은 색으로 모두 칠해준다. ( 칠하기+=1 )
    3. 그룹이 더 적은 색으로 부분 적으로 칠해준다. (칠하기+=min(redGroup,blueGroup) )


 */

public class boj20365_Blog2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int redCnt = 0;
        int blueCnt = 0;

        char prv = input.charAt(0);     //  0 번째 칸의 색 저장

        if(prv=='B'){ blueCnt++; }      //  0 번째 칸의 그룹은 무조건 +1 해야하므로
        else{ redCnt++; }

        for (int i = 0; i < N; i++) {
            char now = input.charAt(i);
            if(prv == now){ continue; }     // 이전과 같은 색이면 무시
            prv = now;                      // 이전과 다른 색이면 prv 최신화
            if(now=='B') { blueCnt++; }     // 현재 색 그룹 ++
            else { redCnt++; }
        }

        System.out.println(Math.min(blueCnt,redCnt)+1);
    }
}
