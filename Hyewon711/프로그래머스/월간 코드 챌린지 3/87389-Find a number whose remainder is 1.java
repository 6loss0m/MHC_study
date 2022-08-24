// 87389 - 나머지가 1이 되는 수 찾기

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int x = 2; x < n; x++ ){ // n은 3이상부터
            if (n%x == 1 ){
                answer = x;
                break;
            }
        }
        return answer;
    }
}
