/*
    20365 - 블로그2
    각 문제를 주어진 색으로 칠할 때 필요한 최소한의 작업 횟수를 구하는 프로그램 작성하기

    ex) 1~2 파란색 / 3 빨간색 / 4 파란색 / 5 빨간색 / 6~7 파란색 / 8 빨간색 = 7번의 작업
    그러나 1~7 파란색 / 3 빨간색 / 5 빨간색 / 8 빨간색으로 변경하는 경우 = 4번의 작업

    파란색과 빨간색 중 어느 항목이 더 많은지 확인하고, 더 많은 색상으로 모두 칠한 후
    더 적은 색상으로 칠하는 것을 아이디어로 잡았다.
*/

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()  = with(BufferedReader(InputStreamReader(System.`in`))) { // 입력
    val st = StringTokenizer(readLine()) // 입력받은 문자열을 쪼개기
    val n = st.nextToken().toInt() // 문제에서 명시된 n (n개의 문자가 공백 없이 순서대로 주어짐)

    val s = readLine() // n개의 문자가 공백없이 순서대로 주어진다.
    val arr = s.toCharArray() // 입력받은 문자열 char형 배열로 만들기

    var red = 0 // 빨간색상 cnt
    var blue = 0 // 파란색상 cnt

    for (i in arr.indices) {
        val now = arr[i]
        if (i == 0) { // 1) 처음에는 무조건 cnt
            if (now == 'B') { // 파란색상의 경우
                blue++
            }
            else red++ // 빨간 색상의 경우
        } else { // 2) 처음 이후
            if (arr[i-1] == now) continue
            // 만약 현재 색상이 이전의 색상과 같은 경우, cnt할 필요가 없으므로 (1~2, 1~3과 같이 한번의 작업으로 수행이 가능하므로)
            // continue로 이번 반복문을 넘긴다.
            else { // 만약 이전 색상과 다른 경우엔 cnt 해주어야한다.
                if (now == 'B') { // 파란색상의 경우
                    blue++
                }
                else red++ // 빨간 색상의 경우
            }
        }
    }
    val ans = if (red >= blue) blue + 1 else red + 1
    // 만약 빨간색상이 더 많다면 파란색상 cnt에 +1 추가한 값이 정답이 되고,
    // 파란색상이 더 많다면 빨간색상 cnt에 +1 추가한 값이 정답이 된다.
    println(ans)
}
