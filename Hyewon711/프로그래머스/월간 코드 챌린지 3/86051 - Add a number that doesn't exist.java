// 86051 - 없는 숫자 더하기

class Solution {
    public int solution(int[] numbers) {
        int answer = -1;
        int sum = 0;
        for ( int i=0; i < numbers.length; i++){
            sum += numbers[i]; // 모든 원소 더하기
        }
        answer = 45 - sum; // 0~9의 합은 45

        return answer;
    }
}