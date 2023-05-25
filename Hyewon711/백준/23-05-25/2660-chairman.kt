/*
*
*   2660 - 회장뽑기
*
*   친구 / 친구의 친구 / 친구의 친구의 친구
*   점수가 낮을 수록 '친구' 사이인 사람이 많으므로 회장이 된다.
*
*   만약 친구 / 친구의 친구 두 가지 관계라면 친구사이라고 본다.
*   입력을 보자마자 그래프로 노드를 연결하여 탐색해야할 것 같다 생각했다.
*   마지막에 -1 -1이 입력되면 코드는 종료한다.
*
*   플로이드 와샬 알고리즘 설명 : https://blog.naver.com/ndb796/221234427842
*   참고 코드 : https://moonsbeen.tistory.com/205
* */


import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextInt()
    val max = 251

    val friend = Array(n + 1) { IntArray(n + 1) { max } }

    for (i in 1..n) {
        for (j in 1..n) {
            friend[i][j] = max
        }
    }

    while (true) {
        val n1 = scan.nextInt()
        val n2 = scan.nextInt()
        if (n1 == -1 && n2 == -1) break
        friend[n1][n2] = 1
        friend[n2][n1] = 1
    }

    for (k in 1..n) {
        friend[k][k] = 1
        for (i in 1..n) {
            for (j in 1..n) {
                if (friend[i][j] > friend[i][k] + friend[k][j]) {
                    friend[i][j] = friend[i][k] + friend[k][j]
                }
            }
        }
    }

    val scores = IntArray(n + 1)
    var min = Int.MAX_VALUE //회장 점수
    for (i in 1..n) {
        for (j in 1..n) {
            scores[i] = scores[i].coerceAtLeast(friend[i][j])
        }
        min = min.coerceAtMost(scores[i])
    }

    val list = mutableListOf<Int>() //회장 후보 목록
    for (i in 1..n) {
        if (scores[i] == min) list.add(i)
    }

    println("$min ${list.size}")
    for (temp in list) {
        print("$temp ")
    }
}