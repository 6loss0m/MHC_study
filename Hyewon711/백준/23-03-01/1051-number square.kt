/*
*   1051 - 숫자 정사각형
*   꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 문제
*
* */
import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() } // 상수
    val map = Array(n) { readLine().toCharArray() } // n x m 정보 입력받기, 상수
    var square = 0 // 정사각형의 최대 크기, 변수

    for (i in 0 until n) {
        for (j in 0 until m) {
            val size = min(m-j, n-i)
            // 정사각형이어야 하므로 가로, 세로의 min 값을 기준으로 size를 측정
            // size 크기는 점점 줄여나가면서 확인하게 될 것

            for (k in size downTo 1){ // size ~ 1까지 반복문 돌리기
                if (map[i][j] == map[i+k-1][j+k-1] && map[i][j] == map[i][j+k-1] && map[i][j] == map[i+k-1][j]){
                    square = max(k * k, square) // k를 기준으로 나머지 꼭짓점을 확인한다.
                    // 현재 기준점을 기준으로 우측상단의 꼭짓점, 좌측하단의 꼭짓점, 우측하단의 꼭짓점 총 세 군데가 같으면 정사각형이다.
                    // 이 때의 정사각형 크기를 max에 값 넣어주기
                }
            }

        }
    }
    println(square)
}

