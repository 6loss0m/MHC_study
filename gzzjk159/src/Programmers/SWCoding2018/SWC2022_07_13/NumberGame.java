package Programmers.SWCoding2018.SWC2022_07_13;
import java.util.*;

public class NumberGame {
    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            int idx_a = A.length - 1;
            int idx_b = idx_a;
            while (idx_a >= 0) {
                int a = A[idx_a];
                int b = B[idx_b];
                if (b > a) {
                    idx_b--;
                    answer++;
                }
                idx_a--;
            }
            return answer;
        }
    }
}
