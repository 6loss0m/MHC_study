/*
*   11668 - 구간 합 구하기 5
*
*   N X N의 표에서 (x1, y1) ~ (x2, y2)의 합을 구해야한다.
*   주의할 점은 시작 지점이 x1, y1이란 점이다.
*
*   (2, 2)부터 (3, 4)까지의 합이라면 직사각형 모양의 6개 격자의 합을 더해야 한다는 의미다!
*
*   구간 합은 (0, 0)부터 (x2, y2)까지의 합을 더하고,
*   (x2, y1 - 1)와 (x1 -1, y2)을 빼준다.
*   이 때, 교집합에 해당되는 부분은 다시 더해주는 과정을 거치면 된다.
*
* */


fun main(args: Array<String>): Unit = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(' ').map { it.toInt() }

    val field = Array(N) { readLine().split(' ').map { it.toInt() }.toTypedArray() }
    val sums = Array(N) { IntArray(N){0} }
    sums[0][0] = field[0][0]
    for(i in 1 until N)
        sums[0][i] = sums[0][i - 1] + field[0][i]
    for(i in 1 until N)
        sums[i][0] = sums[i - 1][0] + field[i][0]

    for(i in 1 until N){
        for(j in 1 until N){
            sums[i][j] = sums[i-1][j] + sums[i][j-1] + field[i][j] - sums[i-1][j-1]
        }
    }

    fun getSum(x1: Int, y1: Int, x2: Int, y2: Int): Int{
        return when{
            x1 == x2 && y1 == y2 -> field[x1][y1] // 만약 시작, 끝 지점이 같은 좌표인 경우 해당 값을 바로 return
            x1 == 0 && y1 == 0 -> sums[x2][y2] // (0, 0) 부터 (x2, y2) 까지 합
            x1 == 0 && y1 > 0 -> sums[x2][y2] - sums[x2][y1-1] // 뺴는 부분 1
            x1 > 0 && y1 == 0 -> sums[x2][y2] - sums[x1-1][y2] // 빼는 부분 2
            else -> sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1] // 위 설명에서 말한 (x2, y2) - (x1-1, y2) - (x2, y1-1) + (x1-1, y1-1 교집합) 부분
        }
    }

    val answer = StringBuilder()
    val cases = Array(M){readLine().split(' ').map{it.toInt()}}
    cases.forEach {
        answer.append("${getSum(it[0] - 1, it[1] - 1, it[2] - 1, it[3] - 1)}\n")
    }
    print(answer.toString()) // 입력받은 끝지점 개수만큼 출력 
}