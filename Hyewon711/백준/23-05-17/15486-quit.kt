/*
*
* 15486 - 퇴사 2
*
* 오늘부터 n+1일째 되는 날 퇴사를 하고자한다.
*
* 인덱스 1부터 시작하며 마지막 퇴사하는 날 n+1을 추가해야하므로 배열의 사이즈는 총 n+2가 된다.
* */

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().toInt()

    val t = IntArray(n + 2)
    val p = IntArray(n + 2)

    for (i in 1..n) {
        val st = StringTokenizer(reader.readLine())
        t[i] = st.nextToken().toInt()
        p[i] = st.nextToken().toInt()
    }
    // 위까지 입력 부분

    val dp = IntArray(n + 2)
    var max = 0

    for (i in 1 until n + 2) { // 인덱스는 1부터 n+2까지
        if (max < dp[i]) // dp는 i까지 일 했을 때의 최소 수익이 저장되어있다.
            max = dp[i] // max값보다 dp[i]의 수익이 더 크다면 max에 대입한다.

        val day = i + t[i] // i에 잡힌 상담일자가 끝나는 날짜
        if (day < n + 2)  // dp 채우기, 상담이 끝나는 날짜
            dp[day] = maxOf(dp[day], max + p[i])
    // "현재 날짜에 기록된 금액이 더 큰지" / "현재 날짜까지의 최대 금액 + 현재 상담 금액"이 더 큰지 비교 후 max에 넣는다.
    }

    println(max)
}
