package Programmers.SWCoding2018;

public class MakePrime {
    static class Solution {
        public int solution(int[] nums) {
            int answer=0;
            prime();
            for (int i = 0; i < nums.length-2; i++) {
                for (int j = i+1; j < nums.length-1; j++) {
                    for (int k = j+1; k < nums.length; k++) {
                        if(!primenum[nums[i]+nums[j]+nums[k]]){
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
        static boolean[] primenum = new boolean[4001];
        static void prime() {
            primenum[0] = primenum[1] = true;
            for (int i = 2; i*i <= 4000; i++) {
                if(!primenum[i]){
                    for (int j = i*i; j <=4000 ; j+=i) {
                        primenum[j] = true;
                    }
                }
            }
        }
    }
}
