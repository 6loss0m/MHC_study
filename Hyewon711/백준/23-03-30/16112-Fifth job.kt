/*
    16112 - 5차 전직
    n개의 퀘스트를 진행하여 n개의 아케인 스톤을 받아야한다.
    퀘스트로 얻는 경험치와 사냥으로 얻는 경험치는 똑같고, 한 번에 하나의 아케인스톤만 활성화시켜 놓을 수 있다.
    그러나 문제에서는 최대 경험치 제한을 없애고 동시 활성화가 가능하다.

    첫째 줄에 정수 n, k가 주어진다.
    둘째 줄에 n개의 정수가 공백을 사이에 두고 주어진다.

    첫째 줄에 키파가 아케인 스톤에 모을 수 있는 경험치의 합의 최댓값을 출력한다.
    아이디어 참고 블로그 : https://hyomyo.tistory.com/64
*/

fun main() {
    val (n: Int, k: Int) = readLine()!!.split(' ').map(String::toInt)
    val v = readLine()!!.split(' ').map(String::toInt).toMutableList()

    var i = 0
    var sum = 0L

    v.sort()
    for (j in 0 until n) {
        sum += v[j] * i.toLong()
        if (i < k) {
            i++
        }
    }
    println(sum)
}
