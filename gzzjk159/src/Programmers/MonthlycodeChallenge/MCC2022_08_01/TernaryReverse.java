package Programmers.MonthlycodeChallenge.MCC2022_08_01;

public class TernaryReverse {
    public int solution(int n) {
        int answer;
        String str = Integer.toString(n,3);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        answer = Integer.parseInt(String.valueOf(sb),3);
        return answer;
    }

    public static void main(String[] args) {
        TernaryReverse tr = new TernaryReverse();
        System.out.println(tr.solution(45));
    }
}
