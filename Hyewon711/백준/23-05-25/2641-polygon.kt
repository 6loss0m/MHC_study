/*
*
*   2641 - 다각형그리기
*
*   1 : 오른쪽 2: 위쪽 3: 왼쪽 4: 아래쪽
*
*   첫째 줄에는 다각형의 모양수열
*   둘째 줄에는 그릴 모양수열의 개수
*   셋째 줄부터는 개수만큼의 모양수열
*
*   첫째 줄에 입력한 모양수열과 같은 형태의 모양수열들의 개수와 정보를 출력한다.
*
*   같은 모양수열은 같은 방향으로 시작하는 경우와, 다른 방향으로 시작하는 수열 두 가지를 신경써야한다.
*
* */

val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().trim().toInt()

fun StringBuilder.getReplace(): String{ // 역방향의 경우
    val sb = StringBuilder(this.reversed())
    for(i in this.indices){
        sb[i] = when(sb[i]){
            '1' -> '3'
            '2' -> '4'
            '3' -> '1'
            else -> '2'
        }
    }
    return sb.toString()
}

fun makeSet(str: String): Set<String>{
    val se = mutableSetOf<String>()
    val line = StringBuilder(str)
    repeat(line.length){
        se.add(line.toString())
        val temp = line.getReplace()
        line.append(line[0]).also {
            line.deleteCharAt(0)
        }
        se.add(temp)
    }
    return se
}

fun main() = with(System.out.bufferedWriter()){

    getInt()
    val input = br.readLine().replace(" ","")
    val se = makeSet(input)
    val result = ArrayList<String>()
    repeat(getInt()){
        val seq = br.readLine()
        val str = seq.replace(" ","")
        if(se.contains(str)) {
            result.add(seq)
        }
    }
    write("${result.size}\n")
    for(re in result){
        write("$re\n")
    }
    close()
}