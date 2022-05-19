package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/*
    수학 문제입니다.
    3의 배수 성질 : 각 자리의 합이 3의 배수 인 수
    10의 배수 성질 : 마지막 자리가 0 인 수

 */

public class boj10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Integer[] arr = new Integer[100000];

        String N = br.readLine();
        int sum=0;
        int len = N.length();
        for(int i=0; i<len;i++){ arr[i]=N.charAt(i)-'0'; sum+=arr[i];}

        if(sum%3!=0){ System.out.println(-1); return; }
        Arrays.sort(arr,0,len, Collections.reverseOrder());
        if(arr[len-1]!=0){ System.out.println(-1); return;}

        for(int i=0;i<len;i++){sb.append(arr[i]);}
        System.out.println(sb);

    }

}
