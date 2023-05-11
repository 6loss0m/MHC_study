/*
*
*   16194 - 카드 구매하기2
*
* */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    val price = IntArray(n+1) // 카드 구매개수마다 최소비용을 저장할 price 배열, 배열의 크기는 카드의 개수+1
    val dp = IntArray(n+1) // 점화식에 쓸 dp 배열 (P1, P2, P3... Pn)
    val st = StringTokenizer(br.readLine())
    for (i in 1..n) {
        price[i] = Integer.parseInt(st.nextToken())
    } // 여기까지 입력받는 부분

    for (i in 1..n) { // 1부터 n까지, 아래 점화식으로 최소비용을 구한다.
        dp[i] = price[i]
        for (j in i downTo 1) {
            dp[i] = Math.min(dp[i], dp[i-j] + price[j])
        }
    }
    println(dp[n])
}
