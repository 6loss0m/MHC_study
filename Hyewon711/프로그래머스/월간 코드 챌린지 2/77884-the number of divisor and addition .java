// 77884 - 약수의 개수와 덧셈
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) { // 나누어 떨어지는 경우 약수에 해당되므로 cnt++
                    cnt++;
                }
            }
            if (cnt % 2 == 0) { // 짝수라면?
                answer += i; // 더하기
            } else { // 홀수라면?
                answer -= i; // 빼기
            }
        }
        return answer;
    }
}