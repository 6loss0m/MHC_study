/*
*   1495 - 기타리스트
*
*   공연에서 세트리스트마다 볼륨을 바꾸고 연주하려한다.
*   현재 볼륨이 P일 때 지금 i번째 곡을 연주하기 전이라면,
*   i번째 곡은 P+V[i]나 P-V[i]로 연주해야한다.
*   0보다 작은 값으로 볼륨을 바꾸거나, M보다 큰 값으로 볼륨을 바꿀 순 없다.
*
* */

import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val S = sc.nextInt()
    val M = sc.nextInt()
    var ans = -1

    val vol = IntArray(M + 1)
    val change = IntArray(N)

    for (i in 0 until N) change[i] = sc.nextInt()

    for (i in 0..M) vol[i] = -1

    vol[S] = 0

    for (i in 1..N) {
        val changer = mutableListOf<Int>()
        for (j in 0..M) {
            if (vol[j] == i - 1) {
                val minus = j-change[i-1]
                val plus = j+change[i-1]

                if (minus >= 0) {
                    changer.add(minus)
                }
                if (plus <= M) {
                    changer.add(plus)
                }
            }
        }
        for (k in changer) vol[k] = i
    }

    for (i in 0..M) {
        if (vol[i] == N) ans = ans.coerceAtLeast(i) // max(ans, i)과 같음
    }

    println(ans)
}
