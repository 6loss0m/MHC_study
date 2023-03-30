/*
*   2548 - 대표 자연수
*   어느 숫자와 주어지는 모든 자연수들의 차를 모두 합한 값이 최소가 되는 자연수 = 대표 자연수
*   가장 작은 수, 가장 큰 수를 기준으로 중간 값을 구하고 한 두칸씩 비교해보는 방법이 좋을 것 같다. ( 이분 탐색)
* */


fun find(arr: IntArray, mid: Int): Int {
    var sum = 0
    for (i in arr) {
        sum += Math.abs(arr[mid]-i) //
    }
    return sum
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().trim().toInt()// 상수
    val info = readLine().trim().split(' ').map { it.toInt() }.toIntArray() // 상수
    info.sort()

    var start = 0
    var end = info.size-1
    var answer = 0
    var sum = Int.MAX_VALUE // 초기값은 Int의 최대값으로 설정, if문을 통해 result 값으로 변경될 것

    while (start <= end) { // 0부터
        val mid = (start+end)/2 // 중간 값 구하기
        val result = find(info, mid)  // 중간값과 주어지는 자연수 모두 find 메서드에 넣기

        if ( result <= sum ) { // result의 값 (차의 합) 비교
            answer = info[mid] // 주어진 자연수 중 중간에 해당하는 값을 answer에 넣기
            end = mid-1 // 중간 값 변경
            sum = result // result값을 sum에 넣음 (다음 if문 준비)
        } else {
            start = mid+1 // 중간 값 변경
        }
    }
    println(answer)
}

