/*
*   1149 - RGB 거리
*
*   집의 색은 같은 색이 나란히 있을 수 없다.
*   빨강, 초록, 파랑 3가지 색이 주어지고, 집마다 각각 색상의 칠하는 비용이 다를 때
*   비용의 최솟값을 구하여야 한다.
*
*   각 집을 칠할 때 마다 최소 비용을 구해야 한다.
*   첫 집부터 칠하는 비용을 누적해서 최소 비용을 구해야하는데, 아래 3가지 경우를 통해 점화식을 세운다.
*
*   1) 현재 집을 빨간색으로 칠할 때, min(이전 집이 파란색, 이전 집이 초록색)
*   2) 현재 집을 파란색으로 칠할 때, min(이전 집이 빨간색, 이전 집이 초록색)
*   3) 현재 집을 초록색으로 칠할 때, min(이전 집이 빨간색, 이전 집이 파란색)
*
* */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt() // 집의 개수

    // 입력받은 비용 선언
    val r = arrayListOf<Int>()
    val g = arrayListOf<Int>()
    val b = arrayListOf<Int>()

    // 최소 비용 (빨간색 / 초록색 / 파란색)
    val dpR = Array(n){ 0 }
    val dpG = Array(n){ 0 }
    val dpB = Array(n){ 0 }

    // 입력문 반복하여 r, g, b를 채워주기
    repeat(n){
        val str = StringTokenizer(readLine())
        r.add(str.nextToken().toInt())
        g.add(str.nextToken().toInt())
        b.add(str.nextToken().toInt())
    }

    // 처음 값은 항상 최대값이므로 각 색상의 첫 번째 배열요소 [0]을 넣어준다.
    dpR[0] = r[0]
    dpG[0] = g[0]
    dpB[0] = b[0]

    for(i in 1 until n){ // 세운 점화식을 통해 최소비용을 구한다.
        dpR[i] = min(dpG[i-1], dpB[i-1]) + r[i]
        dpG[i] = min(dpR[i-1], dpB[i-1]) + g[i]
        dpB[i] = min(dpR[i-1], dpG[i-1]) + b[i]
    }

    //
    val result = min(dpR[n-1], min(dpG[n-1], dpB[n-1]))
    println(result)
}

