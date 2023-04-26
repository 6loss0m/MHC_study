/*
*   1793 - 타일링
*
*   자주보던 타일링 문제, 2n 직사각형을 2x1과 2x2 타일로 채우는 방법의 수를 구해야한다.
*   타일링 문제를 보면 먼저 점화식을 세우는 것이 중요한 것 같다.
*
* */

import java.math.BigInteger
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    // 0 ≤ n ≤ 250 범위이므로 사이즈를 251로 지정해둔다.
    // 출력예제를 보면 알 수 있다시피 숫자 범위가 굉장히 크다.
    // BigInteger는 문자열 형태이므로 숫자의 범위가 무한하기에 어떤 숫자든 담을 수 있다.
    val dp = Array<BigInteger>(251) { BigInteger.ZERO }

    dp[0] = BigInteger.ONE
    dp[1] = BigInteger.ONE
    dp[2] = BigInteger("3")
    for (i in 3..250) {
        // dp[i] = (dp[i-1] + dp[i-2] * 2)
        dp[i] = dp[i-2].multiply(BigInteger("2")).add(dp[i-1])
    }

    while (sc.hasNextInt()) {
        val n = sc.nextInt()
        println(dp[n])
    }
}
