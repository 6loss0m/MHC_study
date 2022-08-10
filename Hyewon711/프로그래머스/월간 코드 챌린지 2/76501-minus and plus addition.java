// 76501 - 음양 더하기

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) { // 절댓값의 길이만큼
            if (signs[i]) { // sighns이 true 라면
                answer += absolutes[i]; // 양수이므로 answer에 더하기
            } else {
                answer -= absolutes[i]; // false 라면 음수이므로 answer에 빼기
            }
        }
        return answer;
    }
}