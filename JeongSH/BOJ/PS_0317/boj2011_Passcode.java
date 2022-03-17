package BOJ.PS_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제 접근
    dp[N] = N번 째 숫자까지 사용하여 만들수 있는 경우의 수.

    arr[N] : N번째 숫자.
    25114
    dp[1] = 1  / arr[1] = 2 : B
    dp[2] = 2  / arr[2] = 5 : BE , Y
    dp[3] = 2  / arr[3] = 1 : BEA, YA
    dp[4] = 4  / arr[4] = 1 : BEAA, YAA,  BEK,YK
        BEAA, YA 는 dp[3] 의 BEA, Y 에서 붙여서 만든것.
        BEK, YK 는 dp[2] 의 BE, Y 에서 붙여서 만든것.
        즉, dp[4] = dp[2] + dp[3]

    dp[5] = 6  / arr[5] = 4 : BEAAD, YAAD, BEKD, YKD
                              BEAN, YAN
        BEAAD, YAAD, BEKD, YKD 는 dp[4] 에서 내려온것.
        BEAN, YAN 은 dp[3] 에서 내려온것.
        dp[5] = ap[4] + dp[3]

    그러므로, arr[N-1] 과 arr[N] 을 붙여서 26 이하의 숫자를 만들 수 있으면
    dp[N] = dp[N-1] + dp[N-2]

    arr[N] 위 조건을 만족하지않으면
    dp[N] = dp[N-1]

    주의점
    1. 잘못된 암호는 0을 출력해야합니다.
    잘못된 암호 0으로 시작하는 암호, 또는 arr[N-1] > 2 && arr[N] == 0 인 경우.

    2. 10, 20 같은 경우 해석의 가짓수가 dp[N-2] 와 같습니다.
        - 한가지로 밖에 해석할 수 없는 경우.

 */

public class boj2011_Passcode {
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5001];
        int[] dp = new int[5001];
        String input = br.readLine();
        int N = input.length()+1;
        for(int n=1; n<N; n++){ arr[n]=input.charAt(n-1)-'0'; }

        if(arr[1]==0){
            System.out.println(0);
            return;
        }

        dp[0]=1;
        dp[1]=1;
        for(int n=2; n<N; n++){
            if(arr[n]>0){ dp[n]=dp[n-1]; }      // 잘못된 암호를 건너뛰기 위해서 + 한가지로 밖에 해석할 수 없는 경우 둘 다 고려
            if(arr[n-1]==1 || (arr[n-1]==2 && arr[n]<7)) {  // 잘못된 암호는 이 조건에 들어올수 없음.
                dp[n] = (dp[n] + dp[n - 2]) % MOD;      // 해석의 여지가 한가지 밖에없다면 dp[n]==0 이므로 dp[n-2]만 들어감
            }
        }
        System.out.println(dp[N-1]%MOD);
    }
}
