package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    구현문제입니다.
    조건을 직접 해보며 생각해봐야합니다.
    3회 이동까지는 1~4 조건 중 무엇을 사용하건 상관없지만
    4회 이동부터는 1~4 조건을 한번 이상 사용해야합니다.

    - 1~3 회 이동까지는 조건 두개를 이용하여 반복하는것이 여행 횟수가 많습니다.
    - 4회 이상부터는 1~4 조건을 한번씩 사용 한 뒤, 조건 2개를 사용하여 반복하는것이 여행 횟수가 많습니다.


 */

public class boj1783_SickKnights {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 세로
        int M = Integer.parseInt(input[1]); // 가로
        int ret = 1;

        if(N == 1){ ret = 1; }
        else if(N == 2){ ret = Math.min(4,(M+1)/2); }   // 4회 이상 움직이려면 제시한 조건을 모두 사용해야 함. 하지만 사용할 수 없으므로 최대 4
        else if (N >= 3) {
            if(M <= 6){ ret = Math.min(4,M); }  // 1,4 번 조건으로 최대 3회 이동
            else { ret = M-2;}                  // M 이 6보다 크다면 1,2,3,4 조건을 한번씩만 사용후 1,4 로 이동하는게 가장 많은 칸을 방문 할 수 있다.
        }
        System.out.println(ret);
    }
}
