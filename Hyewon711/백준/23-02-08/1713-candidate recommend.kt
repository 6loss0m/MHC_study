import java.util.*
import kotlin.collections.ArrayList

fun solution(){

    var n = readLine()!!.toInt() // 사진틀
    var m = readLine()!!.toInt() // 전체 학생의 총 횟수

    var recommend = IntArray(101)
    var time = IntArray(101)
    // priorityQueue : 우선순위 큐, 우선순위를 결정하고 우선순위가 높은 데이터가 먼저 나가는 구조

    var queue = PriorityQueue<Int>(
        {o1, o2 ->
            if(recommend[o1] == recommend[o2]) // 둘이 같다면 먼저 들어온 후보가 나가게 된다 (time이 작을 수록 앞에 게시)
                time[o1] - time[o2]
            else // 둘이 같지않다면 추천 수에 따라 나가게 된다 (recommend가 작을 수록 앞에 게시)
                recommend[o1] - recommend[o2]
        }
    )

    var str = readLine()!!.split(" ") // 추천받은 순서 입력

    for(i in 0 until str.size) { // 0부터 str.size까지 반복문
        var student = str[i].toInt() // str에 저장된 값 int형으로 가져와서
        recommend[student] ++ // 해당 학생의 추천 수 증가

        if(!queue.contains(student)) { // 추천받은 학생이 큐에 없는 경우
            time[student] = i // 해당 학생의 게시시간을 현재 index로 넣기

            if(queue.size == n) // 사진 틀이 꽉 찬 경우
                recommend[queue.poll()] = 0 // 우선순위 낮은 것 부터 제거

            queue.offer(student) // 현재 학생 큐에 추가
        }

        // 추천받은 학생이 큐에 있는 경우
        else {
            // 추천 수가 증가했으므로 해당 학생 지운 후 다시 추가
            queue.remove(student)
            queue.offer(student)
        }
    }

    var result = ArrayList<Int>(queue)
    result.sort() // 결과 오름차순 정렬
    for(a in result)
        print("$a ") // 답 출력
}


fun main() {
    solution()
}