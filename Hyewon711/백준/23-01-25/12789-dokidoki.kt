/*
*   12789 - 도키도키 간식드리미
*/

import java.util.*

fun main() {// BufferdReader가 Scanner보다 더 빠르다.
    val n = readln().toInt()
    val que = readln().split(" ").map { it.toInt() }.toCollection(LinkedList<Int>()) // 공백을 기준으로 split, que는 현재 줄 서있는 곳
    // toCollection : Stream을 일반적인 List, Set 등으로 변경시키는 메서드
    // map{it.toInt()} 를 사용하면 변수가 리스트로 선언
    val stack = Stack<Int>() // stack은 줄을 바로 세우기 위한 임시 공간
    var num = 1 // num을 증가하면서 n에 도달한 경우 break

    while (true) {
        if (num == n) { // 모두 꺼낸 경우
            break;
        }
        if (que.isNotEmpty() && que.peek() == num ){ // 만약 큐가 비어있지 않고 큐의 가장 맨 앞의 수가 num과 동일하다면
            que.poll() // 줄 세우기
            num++
            // isNotEmpty를 해주는 이유 : poll은 큐가 비어있을 때 삭제하면 예외 발생
        }
        else if (stack.isNotEmpty() && stack.peek() == num ){ // 만약 스택의 가장 위에 있는 수가 num과 동일하다면
            stack.pop() // 줄 세우기
            num++
        }
        else if (que.isEmpty() && stack.peek() != num ){ // 만약 스택의 가장 위에 있는 수가 num과 동일하지 않거나, que가 비어있는 경우
            println("Sad") // 줄을 올바르게 세울 수 없음
            return
        } else {
            stack.add(que.poll())
        }
    }
    println("Nice")
}