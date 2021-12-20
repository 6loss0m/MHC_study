/*

    문제접근
    brown + yellow = 총 블럭갯수
    가로 x 세로 = 총 블럭갯수
    brown = 2*(가로+세로)-4
    가로보다 세로가 더 길거나 같음.

    위 조건을 만족하는 가로를 계속 늘려 확인 해봄.


 */
import java.util.Arrays;

public class Carpet2 {
    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(24,24)));
    }
    public static int[] solution(int brown, int yellow){
        int[] answer = new int[2];
        int sum = brown+yellow;     // 총 블럭의 갯수.
        int x;
        int y;
        for(int i=3; i<sum; i++){   // i는 가로를 의미
            if(sum%i!=0){continue;} // 가로 X 세로는 = sum , 가로로 안나눠 떨어지면 넘김.
            x=i;                    // 가로
            y=sum/i;                // 세로
            if(x<y){continue;}      // 문제에서 가로가 더 길다고 제시.
            if(brown==2*(x+y)-4){   // brown 의 갯수는 2(가로*세로)-4
                answer[0]=x;
                answer[1]=y;
            }
        }
        return answer;
    }
}
