package Programmers.MonthlycodeChallenge.MCC2022_07_27;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoChooseAndSum {
    public int[] solution(int[] numbers) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(!result.contains(numbers[i]+numbers[j])){
                    result.add(numbers[i]+numbers[j]);
                }
            }
        }
        answer = new int[result.size()];
        result.sort(null);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        TwoChooseAndSum tc = new TwoChooseAndSum();
        System.out.println(Arrays.toString(tc.solution(new int[]{2, 1, 3, 4, 1})));
    }
}
