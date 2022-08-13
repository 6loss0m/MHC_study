package Programmers.MonthlycodeChallenge2.MCC2022_08_10;

import java.util.Arrays;

public class TwoDiffBit {
    public long[] solution(long[] numbers) {
        long[] answer= new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==0){
                answer[i] = numbers[i]+1;
            }
            else{
                String s = Long.toString(numbers[i],2);
                int zeroIdx = s.lastIndexOf("0");
                if(zeroIdx!= -1){
                    s = s.substring(0,zeroIdx) + "10" + s.substring(zeroIdx+2);
                    answer[i] = Long.parseLong(s,2);
                }
                else{
                    s = "10" + s.substring(1,s.length());
                    answer[i] = Long.parseLong(s,2);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        TwoDiffBit tdb = new TwoDiffBit();
        System.out.println(Arrays.toString(tdb.solution(new long[]{1,2,3,7})));
    }
}
