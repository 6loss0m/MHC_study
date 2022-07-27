package CodeChallenge;

import java.util.Arrays;
import java.util.HashSet;
/*
    이중 for 문 으로 모든 경우의수를 구하고
    set 으로 중복 제거

 */

public class Sum {
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        HashSet<Integer> set = new HashSet<>();
        int N = numbers.length;
        for(int i=0;i<N;i++){
            for(int j=i+1; j<N; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] ret = new int[set.size()];
        int idx=0;
        for (Integer s: set) { ret[idx++]=s; }
        Arrays.sort(ret);
        for (int n: ret) { System.out.println(n); }
    }
}
