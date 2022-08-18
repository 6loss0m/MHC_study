package Programmers.MonthlycodeChallenge2.MCC2022_08_10;

public class NegativePositiveSum {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            if(signs[i]){
                answer += absolutes[i];
            }
            else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
