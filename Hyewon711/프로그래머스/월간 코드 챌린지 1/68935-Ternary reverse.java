// 68935 - 3진법 뒤집기

class Solution {
    public int solution(int n){
        int answer = 0;
        String str = "";
        while (n>0) { // 3진법 계산
            str = (n%3) + str; // 3으로 나눈 값의 나머지를 str앞에 붙인다 (나머지의 역순이 3진법의 수가 되므로)
            n /= 3;
        }
        StringBuffer sb = new StringBuffer(str);
        str = sb.revers().toString(); // 3진수를 앞뒤 반전

        answer = Integer.valueOf(str, 3) // 3진수를 10진수로 변환
        return answer;
    }
}