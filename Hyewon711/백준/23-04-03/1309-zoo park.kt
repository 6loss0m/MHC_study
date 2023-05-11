/*
*   1309 - 동물원
*
*   2 X n의 우리가 존재한다.
*   사자를 배치해야하는데, 가로, 세로로 붙어 있게 배치할 수 없다.
*   사자를 배치하는 경우의 수가 몇 가지인지 알아내는 프로그램을 작성하도록 한다.
*   사자를 한 마리도 배치하지 않는 경우도 카운트한다.
*
*   마지막으로 9901로 나눈 나머지를 출력하도록 한다.
*
* */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt() // 우리의 세로 길이 N

    val dp = Array(n+1) { IntArray(3) }
    Arrays.fill(dp[1], 1) // fill : 원소를 다른 값으로 변환
    for (i in 2..n) { // 2부터 n까지 아래의 점화식대로 값을 구한다.
        dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
        dp[i][1] = dp[i-1][0] + dp[i-1][2]
        dp[i][2] = dp[i-1][0] + dp[i-1][1]

        dp[i][0] %= 9901 // 9901로 나눈 나머지를 출력하기 위함
        dp[i][1] %= 9901
        dp[i][2] %= 9901
    }

    println(dp[n].reduce { acc, i -> acc + i } % 9901)
    // 코틀린 컬렉션에는 컬랙션 내의 데이터를 모두 모으는(accumulate) 함수인 reduce()와 fold()가 있다.
    // reduce : 초기값 없이 첫 번째 요소로 시작
    // 인자로 람다 함수를 받고, 람다 함수는 2개의 인자를 받음.
    // dp[n] 배열 내의 모든 요소를 더한 값을 반환한 후, 9901을 나눈 나머지를 print 한다.
}