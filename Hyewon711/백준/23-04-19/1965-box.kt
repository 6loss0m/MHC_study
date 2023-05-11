/*
*   1965 - 상자넣기
*
*   상자 크기가 더 큰 상자가 있으면, 작은 상자를 넣을 수 있다. (마트료시카처럼)
*   상자 크기가 주어질 때, 한 번에 넣을 수 있는 최대의 상자 개수를 구하는 문제이다.
*
*   dp[i] 초기값은 1이다.
*   dp배열을 채우는데, 현재보다 작은 상자가 오는 경우 dp를 1 증가한다.
*   자신보다 낮은 인덱스들의 숫자를 비교하고, 자기자신보다 작으면 dp값을 저장,
*   dp값 중 가장 큰 값에 1을 더한다.
*
*   LIS 유형의 문제
*   최장 증가 부분 수열 알고리즘이라고 한다.
*   원소가 n개인 배열의 일부 원소를 골라내서 만든 부분 수열 중, 각 원소가 이전 원소보다 크다는 조건을 만족하고
*   그 길이가 최대인 부분 수열을 최장 증가 부분 수열을 의미한다.
*
* */

import kotlin.math.max

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N: Int = readLine().toInt()
    val box = readLine().split(" ").map { it.toInt() }
    val dp = IntArray(N)

    var count = 0

    for (i in 0 until N) { // 상자개수만큼 반복
        dp[i] = 1 // dp[i]의 초기값은 1이다.
        for (j in 0 until i) {  // j를 0부터 상자개수만큼 반복
            if (box[j] < box[i]) {  // 인덱스를 비교, 주어진 상자 순서보다 앞에 있는 상자가 작다면,
                dp[i] = max(dp[j]+1, dp[i]) // dp[j]+1과 dp[i]의 값을 비교하고 더 큰 값을 dp[i]에 넣는다.
            }
        }
        count = max(count, dp[i])
    }

    println(count)
}