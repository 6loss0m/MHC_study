package SummerWinter_2018;

/*
    처음엔 dp로 접근하려했지만 입력 값의 제한이 10억 이므로 메모리 초과가 날 수있다고 생각하고 풀이하였습니다.

    도착지점에서 부터 0 까지 간다가고 반대로 생각합니다.
    도착지점이 짝수일경우 -> 텔레포트(/2)
             홀수일경우 -> 점프(1) (배터리 사용양+1)

    로 이동합니다.

 */

public class JumpOrTeleport {
    public static void main(String[] args) {
        int N = 5000; // 5
        int cnt=0;
        while (N!=0){
            if((N&1)==1){ N-=1; cnt+=1; }
            else{ N/=2; }
        }
        System.out.println(cnt);
    }
}