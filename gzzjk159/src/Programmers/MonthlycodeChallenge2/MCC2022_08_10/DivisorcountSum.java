package Programmers.MonthlycodeChallenge2.MCC2022_08_10;

public class DivisorcountSum {
    public int solution(int left, int right) {
        int answer = 0;
        boolean[] div = new boolean[1001];
        for (int i = 1; i < Math.sqrt(1001); i++) {
            div[i*i] = true;
        }
        for (int i = left; i <= right; i++) {
            if(div[i]){
                answer -= i;
            }
            else{
                answer +=i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        DivisorcountSum dcs = new DivisorcountSum();
        System.out.println(dcs.solution(24,27));
    }
}
