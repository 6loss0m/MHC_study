/*
*   13116 - 30번
*   LCA : 최소 공통 조상을 찾는 알고리즘
*   두 정점 u, v(혹은 a, b)에서 가장 가까운 공통 조상을 찾는 과정을 말한다.
*
*   1. 모든 노드에 대한 깊이를 계산합니다.
*   2. 최소 공통 조상을 찾을 두 노드를 확인합니다.
*   3. 먼저 두 노드의 깊이가 동일하도록 거슬러 올라갑니다.
*   4. 부모가 같아질 때까지 북쪽으로 두 노드의 부모방향으로 거슬러 올라갑니다.
*   5. 모든 LCA(a, b) 연산에 대하여 3~4번 과정을 반복합니다.
*
*   현재 노드를 기준으로 부모 노드는 [현재 값 / 2] 이다.
*   a와 b가 같아지면 같은 노드가 되므로 print하고 반복문을 종료한다.
*/

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val sb = StringBuilder()

    val n = br.readLine().toInt()
    for (i:Int in 0 until n) {
        var (a, b) = br.readLine().split(" ").map { it.toInt() }
        // map{it.toInt()} 를 사용하면 변수가 리스트로 선언

        while(true){
            if(a == b) break
            else if (a > b) a /= 2
            else b /= 2
        }
        sb.append("${10 * a}\n")
    }
    bw.write("${sb.toString()}")
    bw.flush()
}

