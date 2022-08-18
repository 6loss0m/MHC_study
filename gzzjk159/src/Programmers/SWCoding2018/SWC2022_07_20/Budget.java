package Programmers.SWCoding2018.SWC2022_07_20;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int i : d) {
            if (budget >= i) {
                budget -= i;
                answer++;
            }
            else break;
        }
        return answer;
    }
    public static void main(String[] args) {
        Budget bg = new Budget();
        System.out.println(bg.solution(new int[]{1,3,2,5,4},9));
        System.out.println(bg.solution(new int[]{2,2,3,3},10));
    }
}