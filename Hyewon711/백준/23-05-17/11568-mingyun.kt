/*
*   11568 - 민균이의 계략
*
*   LIS (최장 증가 부분 수열) 문제
*   이전에 비슷한 문제를 풀었던 기억이..?
*   LIS : 원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중,
*   각 원소가 이전 원소보다 크다는 조건을 만족하고, 그 길이가 최대인 부분 수열을
*   최장 증가 부분 수열이라고 한다.
*
*   수열의 원소의 최대 개수를 출력하기
*
*   최장 증가 부분 수열 알고리즘의 개념은 이 블로그를 참조
*   https://chanhuiseok.github.io/posts/algo-49/
*
* */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val card = IntArray(n) // 카드 n개에 들어있는 정수
    val dp = IntArray(n) // dp 배열 선언
    var ans = 0

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        card[i] = Integer.parseInt(st.nextToken())
    } // 여기까지 입력받는 부분

    for (i in 0 until n) { // 1부터 n까지, 아래 점화식으로 최소비용을 구한다.
        dp[i] = 1
        for (j in 0 until i) {
            if (card[i] > card[j]) {
                dp[i] = Math.max(dp[i], dp[j]+1)
            }
        }
        ans = Math.max(ans, dp[i])
    }
    println(ans)
}