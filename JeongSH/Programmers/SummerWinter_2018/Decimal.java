package SummerWinter_2018;

import java.util.Arrays;
/*
    에라토스테네스의 체를 사용하여 미리 소수를 구합니다.
    소수를 구한 배열을 이용하여,
    모든조합의 합이 소수인지 판별합니다.

    주의점. 각 조합의 합은 같을 수 있습니다.
    ex) 3 7 1 = 11
    ex) 4 5 2 = 11
    이 둘은 합은 같지만 서로 다른 조합입니다.

 */

public class Decimal {
    static boolean[] isDecimal = new boolean[50000];

    public static void main(String[] args){
        int[] nums = {1,6,4};

        int total=0;
        for (int n : nums) { total+=n; }
        setDecimal(total);

        int len = nums.length;
        int cnt = 0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    if(isDecimal[nums[i] + nums[j] + nums[k]]){ cnt+=1; }
                }
            }
        }
        System.out.println(cnt);
    }
    static void setDecimal(int n){
        Arrays.fill(isDecimal,0,n+1,true);
        for(int i=2; i*i<=n; i++){
            for(int j=i; i*j<=n; j++){
                if(!isDecimal[i * j]) continue;
                isDecimal[i*j]=false;
            }
        }
    }
}
