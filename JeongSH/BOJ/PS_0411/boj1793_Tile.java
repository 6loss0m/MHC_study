package BOJ.PS_0411;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
    점화식
    dp[n] = dp[n-2]*2 + dp[n-1]
    입니다.

    [1]     [2]     [3]     [4]
    1       3       5       11
    dp[4] 를 예로 들면,
    1. dp[3] 의 경우에 가장 오른쪽에 2x1 타일을 하나씩 배치합니다. (+5)
    2. dp[2] 의 경우에 가장 오른쪽 2x2 타일에 올 수 있는 경우는 2x2 1개 , 1x2 2개 타일 입니다. ( dp[2]x2 )
        - 2x2 타일에 2x1 타일이 올 수 없는 이유는 2x1 타일 2개는 1번 경우에 포함되는 경우이기 때문입니다.

    Java 에서는 큰 수 연산을 할 때 BigInteger 를 사용합니다.

 */

public class boj1793_Tile {
    public static void main(String[] args) throws IOException {
        BigInteger[] dp = new BigInteger[251];

        dp[0]= new BigInteger("1");
        dp[1]= new BigInteger("1");
        dp[2]= new BigInteger("3");
        for (int i = 3; i <=250; i++) {
            dp[i]=dp[i-2].multiply(new BigInteger("2")).add(dp[i-1]);
        }

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
