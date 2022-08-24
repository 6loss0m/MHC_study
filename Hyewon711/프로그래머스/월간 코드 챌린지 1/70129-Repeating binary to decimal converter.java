// 70129 - 이진 변환 반복하기

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2]; //[이진 변환의 횟수, 변환과정에서 제거된 모든 0의 개수]
        int zeroCnt = 0; // 변환과정에서 제거된 모든 0의 개수
        int count = 0; // 이진 변환의 횟수

        while(!s.equals("1")){ // 1이 될때까지 반복
            count += 1;
            int length = s.length();
            s = s.replace("0", ""); // 0을 제거
            zeroCnt += length - s.length(); // 0의 개수
            // 이진수 변환
            s = Integer.toBinaryString(s.length()); //1의 개수를 2진수로
        }
        answer[0] = count;
        answer[1] = zeroCnt;
        return answer;
    }
}