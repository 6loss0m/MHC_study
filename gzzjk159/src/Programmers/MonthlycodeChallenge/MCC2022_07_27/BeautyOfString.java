package Programmers.MonthlycodeChallenge.MCC2022_07_27;

public class BeautyOfString {
    public long solution(String s) {
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int max = 0;
            for (int j = i; j <s.length() ; j++) {
                if(s.charAt(i)!=s.charAt(j)) {
                    max = Math.max(max, j-i);
                }
                answer += max;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        BeautyOfString bos = new BeautyOfString();
        System.out.println(bos.solution("baby"));
    }
}
