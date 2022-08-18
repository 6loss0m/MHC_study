package Programmers.MonthlycodeChallenge2.MCC2022_08_17;

public class NoNumberSum {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] num = new boolean[10];
        for (int number : numbers) {
            num[number] = true;
        }
        for (int i = 0; i < 10; i++) {
            if(!num[i]){
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
