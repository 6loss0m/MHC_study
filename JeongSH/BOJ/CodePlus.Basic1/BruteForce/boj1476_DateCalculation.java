
/**
 *  최악의 입력값인 15 28 19 가 들어오더라도 7980 번만 순회하면 되기때문에 완전탐색으로 풀이하였습니다.
 *
 *  팁:
 *      입력값에 전부 -1 을 해준이유는 각각 1부터 15,28,19 기준으로 돌기때문에,
 *      i % 15 을 해야합니다. 하지만,
 *      15라는 입력값이 들어왔을 경우 나머지 연산을 취하게되면 15%15 != 15 이됩니다.
 *      그래서 입력값에서 -1 을 해주고 출력값에 +1을 해주면
 *      14%15 == 14
 *      14+1 == 15 가 됩니다.
 *
 *  다른풀이:
 *      1. E S M 과 Y 를 둡니다.
 *      2. 1회 반복문 마다 E++, S++, M++, Y++ 해줍니다.
 *      3. E==16 되면 E=1 로 초기화 합니다. (E,S,M 모두 각각)
 *      4. 입력값과 E,S,M 이 같아지면 Y 를 출력합니다.
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1476_DateCalculation {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int E=Integer.parseInt(str[0])-1; // 15
        int S=Integer.parseInt(str[1])-1; // 28
        int M=Integer.parseInt(str[2])-1; // 19

        for(int i=0; i<=7980; i++) {    // ESM 의 최소 공배수
            if((i%15) != E){continue;}
            if((i%28) != S){continue;}
            if((i%19) != M){continue;}
            System.out.println(i+1);
            break;
        }
    }
}
