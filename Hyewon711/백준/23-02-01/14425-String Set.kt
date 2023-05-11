/*
*   14425 - 문자열 집합
*   중복 제외하는 Set을 이용하면 좋을 것 같다고 생각했다.
*   HashSet은 같은 문자열을 갖는 String은 동일한 객체로 간주,
*   다른 문자열을 갖는 String은 다른 객체로 간주한다.
*   HashSet에 추가될 때마다 count 해주면 정답이 나올 것 같다
*/

import java.util.HashSet

fun main() {
    val br = System.`in`.bufferedReader()
    val set = HashSet<String>()

    val (n, m) = br.readLine().split(' ').map{it.toInt()}
    var count = 0

    repeat(n) {
        set.add(br.readLine())
    }

    repeat(m) {
        if(set.contains(br.readLine())) count++
    }
    println(count)
}

