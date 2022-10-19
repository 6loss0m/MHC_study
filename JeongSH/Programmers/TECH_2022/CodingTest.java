package TECH_2022;

import java.util.Arrays;
/*
    dp 문제입니다.
    정의 : dp[algo][code] = minCost

    아이디어 1
    1. dp 배열을 주어진 alp,cop 부터 채워갑니다
        dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
        dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);

    2. 문제를 풀 조건이 된다면 풀수있는 문제를 전부풀고
        dp[][] 배열을 최소값으로 바꿔줍니다.

    3. 목표 alp, cop 이상의 모든 인덱스를 검사하여 최소값을 찾아냅니다.

    -> 왜인지 계속 계속틀림, dp 배열의 크기를 엄청 늘려주면 점점 틀리는 문제갯수가 적어짐..
       180 -> 5문제 틀림, 300 기준 두문제 틀림 500 기준 하나 틀림

   이유를 알수없어 3번을 다른사람의 코드를 참고하여 바꿈
   -> 목표 alp,cop 을 초과하는 값은 목표 alp,cop 에 초기화하는 방식.
   케이스 1.  둘다 목표치를 넘겻을때,
   케이스 2.  알고력만 목표치를 넘겻을때
   케이스 3.  코딩력만 목표치를 넘겻을때
   케이스 4.  둘다 목표치를 안넘겻을때
   을 사용하여 조건을 추가함

   반복문은 목표 alp, cop 까지 돌리지만
   제한사항 중 최대 reward 가 30이 될 수 있므로
   배열의 최대크기는 150(최대요구치) + 30(최대리워드) 이기때문에
   dp[181][181]을 할당해야 함.


 */

public class CodingTest {
    public static void main(String[] args) {
        System.out.println(solution(10,10,new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}}));
    }

    static int goalAlp= 0;
    static int goalCop= 0;
    static int[][] dp;

    static public int solution(int alp, int cop, int[][] problems) {
        for(int i=0;i<problems.length;i++){
            goalAlp = Math.max(problems[i][0],goalAlp);
            goalCop = Math.max(problems[i][1],goalCop);
        }
        goalAlp = Math.max(goalAlp,alp);        // 이미 모든문제를 풀 수 있다면
        goalCop = Math.max(goalCop,cop);        // 이미 모든문제를 풀 수 있다면

        dp= new int[181][181];
        for(int[] d: dp){ Arrays.fill(d,Integer.MAX_VALUE); }
        dp[alp][cop]=0;

        for(int i=alp ; i<=goalAlp; i++){
            for(int j=cop; j<=goalCop; j++){
                dp[i+1][j] = Math.min(dp[i+1][j],dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1],dp[i][j]+1);
                for(int[] p: problems){
                    if(p[0]>i || p[1]>j){ continue; }
                    if(i+p[2]>goalAlp && j+p[3]>goalCop){   // 둘 다 목표치를 넘겼다면
                        dp[goalAlp][goalCop]=Math.min(dp[goalAlp][goalCop],dp[i][j]+p[4]);
                    }
                    else if(i+p[2]>goalAlp){        // 알고력만 넘겼다면
                        dp[goalAlp][j+p[3]]= Math.min(dp[goalAlp][j+p[3]],dp[i][j]+p[4]);
                    }
                    else if(j+p[3]>goalCop){        // 코딩력만 넘겼다면
                        dp[i+p[2]][goalCop]=Math.min(dp[i+p[2]][goalCop],dp[i][j]+p[4]);
                    }
                    else if(i+p[2]<=goalAlp && j+p[3]<=goalCop){    // 둘다 목표치가 안된다면
                        dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                    }
                }
            }
        }
        return dp[goalAlp][goalCop];
    }
}
