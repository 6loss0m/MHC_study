package Programmers.MonthlycodeChallenge.MCC2022_07_27;

import java.util.Arrays;

public class BinaryChangeRepeat {
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[2];

        int cnt = 0;
        int cnt_zero = 0;
         while(!s.equals("1")){
             int cnt_one = 0;
             for (int i = 0; i < s.length(); i++) {
                 if(s.charAt(i)=='1'){
                     cnt_one++;
                 }
                 else{
                     cnt_zero++;
                 }
             }
             s = Integer.toBinaryString(cnt_one);
             cnt++;
         }
         answer[0] = cnt;
         answer[1] = cnt_zero;
        return answer;
    }

    public static void main(String[] args) {
        BinaryChangeRepeat bcr = new BinaryChangeRepeat();
        System.out.println(Arrays.toString(bcr.solution("01110")));
    }
}
