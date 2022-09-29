package Programmers.blindrecruitment_2022.br_2022_0921;

public class findprime {
    public int solution(int n, int k) {
        int answer = 0;
        String notation = Integer.toString(n, k);
        String[] nums = notation.split("0+");

        for (String num : nums) {
            if(checkprime(Long.parseLong(num))){
                answer++;
            }
        }
        return answer;
    }
    public static boolean checkprime(long num){
        if (num == 2) { return true; }
        if (num == 1 || num % 2 == 0) { return false; }

        for (long i = 3; i <= (long)Math.sqrt(num); i += 2) {
            if (num % i == 0) { return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        findprime fp = new findprime();
        System.out.println(fp.solution(437674, 3));
        System.out.println(fp.solution(110011, 10));
    }
}
