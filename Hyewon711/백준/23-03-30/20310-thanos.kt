/*
    20310 - 타노스
    0과 1로 이루어진 문자열 S가 주얻진다.
    S가 포함하는 0의 개수와 S가 포함하는 1의 개수는 모두 짝수이다.
    문자 중 절반의 0, 절반의 1을 제거하여 새로운 문자열을 만들 때,
    가능한 문자열 중 사전순으로 가장 빠른 것을 구하는 문제

    입력받은 문자열 s를 기준으로 0과 1의 개수를 세고, 이를 2로 나눈다.
    이후 repeat를 이용하여 0과 1의 개수만큼 반복하며 mutablew의 지정원소를 하나씩 삭제한다.

*/

fun main() {
    val input = readLine()!!
    val str = input.toCharArray().toMutableList()
    val zero = str.count { it == '0' } / 2
    val one = str.count { it == '1' } / 2

    // 사전순은 0 -> 1 순이다.
    repeat(zero) { // 0은 뒤에서부터 삭제 (사전순이므로)
        str.removeAt(str.size-1-str.reversed().indexOf('0')) // str.size-1-str.reversed = 앞뒤를 반전한 상태로 indexOf('0')을 찾고, remove
    }

    repeat(one) {
        str.removeAt(str.indexOf('1')) // indexOf('1')의 경우 remove (앞부터 삭제된다.)
    }

    println(str.joinToString("")) // 위 repeat를 통해 사전순으로 정렬된 str를 출력하기만 하면 된다.
}