/*
*   2502 - 떡 먹는 호랑이
*
*   1, 2일차를 구하고 출력해야 하는 문제이다.
*   3일차부터는 피보나치 수열로 표현식을 얻을 수 있다.
*   B의 최댓값부터 A의 값으로 정수가 나오지는지 확인하고,
*   나오지 않는 경우 B의 값을 줄여 다시 확인한다.
*
*   피보나치 수열 : 첫째 및 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열
*
* */


class IO2502 { // 입력문 class
    private val br = System.`in`.bufferedReader()
    private val bw = System.out.bufferedWriter()

    fun getDayAndCount() = br.readLine().split(" ") // 넘어온 날 D, 준 떡의 개수 K
    fun flush() = bw.flush()
    fun close() = bw.close()
    fun write(message: String) = bw.write(message)
}

fun main() {
    val io = IO2502()
    val (day, count) = io.getDayAndCount().map { it.toInt() }

    var arr = getFibonacci(day) // 피보나치 수열 메서드를 이용해 D 날짜까지의 arr를 미리 구해놓는다.

    var a = arr[day-3]  // 1일차 떡의 개수
    var b = arr[day-2]  // 2일차 떡의 개수

    var B = count / b // 2일차 떡의 개수를 D날짜의 떡의 개수만큼 나누어준다.

    while ( B >= 1) { // 만약 B가 1보다 크거나 같다면 (A가 나올 수 없는 경우가 될 때 까지)
        val rest = count - (B * b) // D날짜의 떡의 개수에서 현재 저장된 2일차 떡의 개수와 이전에 구한 B를 뺴주기
        if (rest / a > 0 && rest % a == 0) {
            io.write("${rest/a}\n")
            io.write("$B")
            break
        } else {
            B--
        }
    }
    io.flush()
    io.close()
}

fun getFibonacci(day: Int): Array<Int> {
    return Array(day) { -1 }.apply {
        set(0, 1)
        set(1, 1)

        for (idx in 2 until day) {
            set(idx, get(idx-1) + get(idx -2))
        }
    }
}
