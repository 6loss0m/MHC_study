package Programmers.MonthlycodeChallenge2.MCC2022_08_17;

public class NsquareCut {
    public int[] solution(int n, long left, long right) {
        int[] answer;
        int idx = 0;
        answer = new int[(int) (right-left+1)];
        for (long i = left; i < right+1; i++) {
            answer[idx] = (int) (Math.max(i/n ,i%n)+1);
            idx++;
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
