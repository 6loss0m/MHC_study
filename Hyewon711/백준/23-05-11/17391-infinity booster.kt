/*
*
*   17391 - 무한 부스터
*
* */


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    repeat(n) { i ->
        val st = StringTokenizer(br.readLine())
        repeat(m) { j ->
            map[i][j] = st.nextToken().toInt()
        }
    }
    val result = bfs(map, n, m) // bfs 메서드에서  return된 값이 격자의 최소 크기
    println(result)
}

private val dy = intArrayOf(0, 1) // 열 (오른쪽 이동)
private val dx = intArrayOf(1, 0) // 행 (아래 이동)

private fun bfs(map: Array<IntArray>, n: Int, m: Int): Int {
    val q: Queue<IntArray> = LinkedList()
    q.offer(intArrayOf(0, 0)) // add는 용량제한이 발생시 Exception 발생, offer은 Exception 발생하지 않는다. (둘다 사용해도 상관은 없음)
    var time = 0 // 격자 개수
    val visited = Array(n) { BooleanArray(m) }
    while (q.isNotEmpty()) {
        val size = q.size
        repeat(size) { // q의 사이즈만큼 반복..
            val now = q.poll() // poll은 remove와 동일하게 앞에서부터 제거, 큐가 비어있는 경우 null이 출력됨
            if (now[0] == n-1 && now[1] == m-1) { // 끝까지 도달한 경우
                return time // 격자 개수 return
            }
            val power = map[now[0]][now[1]] // power은 각 격자마다 입력받은 부스터 개수이다.
            repeat(2) { i ->
                for (j in 1..power) { // 부스터 개수만큼 탐색...
                    val ny = now[0] + j * dy[i] // 오른쪽 이동
                    val nx = now[1] + j * dx[i] // 아래 이동
                    if (ny >= n || nx >= m) { //오른쪽 끝이나 맨 아래에 도달한 경우 repeat 종료
                        break
                    }
                    if (!visited[ny][nx]) { // 만약 방문하지 않은 경우
                        visited[ny][nx] = true // 방문처리,
                        q.offer(intArrayOf(ny, nx)) // q에 현재 위치를 추가
                    }
                }
            }
        }
        time++ // 격자 개수 +1
    }
    return -1
}
