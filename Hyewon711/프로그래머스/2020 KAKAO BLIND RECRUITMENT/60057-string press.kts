// 60057 - 문자열 압축
class Solution {

    fun solution(s: String): Int {
        var level = 1 // 압축단계 1
        val size = s.length
        var min = s.length

        while (level <= size) { // 문자열 길이가 압축단계보다 크거나 같다면 압축단계 2
            var str = s.substring(0, level) //  처음 부분 문자열은 0부터 level 까지 저장
            var isChange = false
            val sb = StringBuilder()
            var cnt = 2
            var temp = "" // cnt를 포함한 부분 문자열을 임시로 저장하는 temp

            var j = level
            while (j + level <= size) { // sub는 j + level 이므로 j + level <= size로 범위
                val sub = s.substring(j, j + level)
                if (str == sub) { // 현재 문자열과 다음 문자열이 같다면
                    isChange = true
                    temp = cnt.toString() + str // 문자열 임시 저장
                    cnt++ // cnt 증가, 다음 문자열 비교
                } else { // 현재 문자열과 다음 문자열이 다른 경우
                    sb.append(if(isChange) temp else str) // true -> temp + sb, false -> str + sb
                    isChange = false
                    str = sub // 다음 부분 문자열을 현재 부분 문자열로 할당
                    cnt = 2 // cnt를 2로 갱신
                    temp = ""

                }
                j += level
            }
            sb.append(if(temp.isEmpty()) s.substring(j-level, size) else temp + s.substring(j,size))
            // temp가 비어있다면 마지막에 아직 덧붙이지 않은 문자열이 존재, j-level ~ size 만큼 sb에 붙이기
            min = minOf(min, sb.length)
            // 가장 짦은 길이를 구해야 하기 때문에 최소를 담기 위한 변수 min 와 sb 의 길이를 비교
            level++
        }
        return min
    }
}