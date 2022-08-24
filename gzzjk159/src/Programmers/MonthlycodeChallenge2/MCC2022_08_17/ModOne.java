package Programmers.MonthlycodeChallenge2.MCC2022_08_17;


public class ModOne {
    public int solution(int n) {
        int answer=0;
        for (int i = 2; i < n; i++) {
            if(n%i==1){
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
