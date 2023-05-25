/*
*   2659 - 십자카드 문제
*
*   시계수 : 카드의 숫자들을 시계 방향으로 읽어서 만들어지는 네 자리 수들 중에서
*   가장 작은 수
*       3
*   7       2
*       2
*
*   위의 경우라면 , 3227, 2273, 2732, 7322 네 가지가 가능하며 2273이 가장 작은 수가 된다.
*   1111부터 시작해서 주어진 수의 시계수까지 구하며 몇 번째인지 출력하도록 한다.
*
* */


import java.util.*

fun card(t: Int): Boolean { // 시계수인지 체크하는 메서드
    var tmp = t
    for (i in 0 until 3) { // 총 4자리 확인, 0 ~ 3
        if (tmp % 10 == 0) // 끝자리에 0이 올 수 없으므로 false
            return false
        tmp = tmp / 10 + 1000 * (tmp % 10) // 끝에 붙은 수를 앞에 붙이면서 .. 확인할 것
        if (tmp < t) // 만약 현재 비교하는 시계수보다 큰 경우라면 false
            return false
    }
    return true // 반복문을 모두 돌면 true
}

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var num = 1000 * sc.nextInt() + 100 * sc.nextInt() + 10 * sc.nextInt() + sc.nextInt() // 입력받는데, 입력 받는 수를 4자리로 연결한다.
    var tmp = num

    for (i in 0 until 3) { // 끝에 붙은 수를 앞에 붙이면서 .. 확인할 것
        tmp = tmp / 10 + 1000 * (tmp % 10)
        num = Math.min(num, tmp) // 처음 입력받은 수와 만든 시계수를 min을 통해 비교하고, 더 작은 수를 num에 넣어 갱신을 반복
    }

    var ans = 1
    for (t in 1111 until num) { // 1111부터 num까지의 수를 반복하며 시계수를 센다.
        if (card(t)) // 시계수 체크하고, true라면 시계수 개수 +1
            ans++
    }

    println(ans)
}