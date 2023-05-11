/*
*
*   2240 - 자두나무
*   T개 줄에 두 개의 나무 중 자두가 떨어지는 나무 번호가 1, 2로 주어진다.
*   출력은 자두가 받을 수 있는 자두의 최대 개수 출력하기
*
*   자두가 떨어지는 초는 1000까지, 자두(사람)은 30번까지 움직일 수 있다.
*
*   https://lotuslee.tistory.com/50
*
* */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var sarr = br.readLine().split(" ")
    val T = sarr[0].toInt()
    val W = sarr[1].toInt()

    // int[][][] dp = new int[자두(나무)가 몇번째 떨어지는지][자두(사람)이 어느 위치에 있는지][자두(사람)의 이동횟수]
    val dp = Array(T + 1) { Array(3) { IntArray(W + 1) } }

    var n = br.readLine().toInt()

    if (n == 1) {
        dp[1][1][0] = 1
        dp[1][2][1] = 0
    } else if (n == 2) {
        dp[1][1][0] = 0
        dp[1][2][1] = 1
    }

    for (t in 2..T) {
        n = br.readLine().toInt()

        if (n == 1) {
            dp[t][1][0] = dp[t-1][1][0] + 1
            dp[t][2][0] = dp[t-1][2][0]

            for (w in 1..W) {
                dp[t][1][w] = maxOf(dp[t-1][1][w], dp[t-1][2][w-1]) + 1
                dp[t][2][w] = maxOf(dp[t-1][1][w-1], dp[t-1][2][w])
            }
        } else if (n == 2) {
            dp[t][1][0] = dp[t - 1][1][0]
            dp[t][2][0] = dp[t - 1][2][0] + 1

            for (w in 1..W) {
                dp[t][1][w] = maxOf(dp[t-1][1][w], dp[t-1][2][w-1])
                dp[t][2][w] = maxOf(dp[t-1][1][w-1], dp[t-1][2][w]) + 1
            }
        }
    }

    var max = 0
    for (w in 0..W) {
        max = maxOf(max, maxOf(dp[T][1][w], dp[T][2][w]))
    }
    bw.write("$max\n")
    bw.flush()
}
