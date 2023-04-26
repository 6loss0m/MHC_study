/*
*   1932 - 정수 삼각형
*
*   dp 문제, 삼각형 모양대로 숫자가 쓰여져 있고 이전 숫자를 더해가며 최대의 합을 구하는 문제
*
* */

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt() // 삼각형의 크기 n
    val triangle = ArrayList<IntArray>() // 삼각형을 담을 배열 triangle

    for (i in 0 until n) { // 정수 삼각형
        triangle.add(readLine().split(" ").map { it.toInt() }.toIntArray())
    }

    for (i in 1 until n) { // 삼각형 세로
        for (j in 0..i) { // 삼각형 가로
            when (j) { // 경로의 최댓값을 저장하는 방식
                // 현재 위치 triangle[i][j]의 숫자와, 이전 줄에 있던 숫자를 더하기
                // 0 (가장 왼쪽)의 경우, 이전 줄도 가장 왼쪽 밖에 선택지가 없음
                0 -> {
                    triangle[i][j] += triangle[i-1][0]
                }
                // i (가장 오른쪽)의 경우, 이전 줄은 가장 오른쪽 밖에 선택지가 없음
                i -> {
                    triangle[i][j] += triangle[i-1][j-1]
                }
                // 중간 숫자들
                else -> {  // 1~ i-1 (중간)의 경우, 중간에 있는 숫자들 중에서 최댓값을 구한 후 더해야 한다.
                    triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])
                }
            }
        }
    }
    println(triangle[n - 1].max())
}