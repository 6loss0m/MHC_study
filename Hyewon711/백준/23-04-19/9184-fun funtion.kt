/*
*   9184 - 신나는 함수 실행
*
*   문제에서 주어진 조건들을 그대로 구현하지만
*   그대로 재귀함수를 돌리면 시간초과가 되므로
*   배열에 저장하는 방식으로 같은 계산을 반복하는 것을 막는다.
*
* */

var array = Array(21){Array(21){Array(21){0}}}

fun main(args: Array<String>)
{
    while(true) {
        val n = readLine()
        if(n == "-1 -1 -1") break // -1 -1 -1이 입력되는 경우 종료
        val abc = n?.split(" ")!!.map { it.toInt() }.toTypedArray() // 공백을 기준으로 split
        println("w(${abc[0]}, ${abc[1]}, ${abc[2]}) = ${w(abc[0], abc[1], abc[2])}") // 출력 예시
    }
}

fun w(a: Int, b: Int, c: Int): Int {
    if(a <= 0 || b <= 0 || c <= 0) { // 문제에서 주어진 조건 1
        return 1
    }

    if(a > 20 || b > 20 || c > 20) { // 문제에서 주어진 조건2
        return w(20, 20, 20)
    }

    if(array[a][b][c] != 0) { // 0이 아닐 때 그대로 리턴
        // 재귀함수를 돌 때, 함수에서 값을 계산한 후 배열에 저장하여 같은 계산을 반복하는 것을 방지
        return array[a][b][c]
    }

    if(a < b && b < c) { // 문제에서 주어진 조건 3
        array[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        return array[a][b][c]
    }

    // 문제에서 주어진 otherwise
    array[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
    return array[a][b][c]
}