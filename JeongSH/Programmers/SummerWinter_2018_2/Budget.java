package SummerWinter_2018_2;

import java.util.Arrays;
/*
    오름차순으로 정렬한 뒤, 예산을 분배합니다.

 */

public class Budget {
    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int budget = 9;
        int len = d.length;

        Arrays.sort(d);
        int cnt=0;
        for(int i=0; i<len; i++){
            if(d[i]<=budget){ budget -= d[i]; cnt+=1; }
            else {break;}
        }
        System.out.println(cnt);
    }
}
