package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    이분탐색 문제입니다.
    입력조건을 보고 알아챈다면 쉽게 풀 수 있습니다.
    mid 값을 어떤 걸로 삼아야 할지 잘 모르겠다면,
    보통 이분탐색의 mid 값은 답과 관련이 있습니다.

    결국 톱의 높이를 구하는 문제이기 때문에
    톱의 높이를 mid 로 생각하면 쉽게 접근할 수 있습니다.

 */

public class boj2805_Felling {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] trees = new int[1000000];
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int maxLen = 0;
        for(int i=0;i<N; i++){
            trees[i]=Integer.parseInt(input[i]);
            if(maxLen<trees[i]){maxLen=trees[i];}
        }

        long left = 1 ;
        long right = maxLen;
        long mid = 0;
        long total,tmp;
        long max = 0;
        while (left<=right){
            mid = (left+right)/2;
            total = 0;
            for(int i=0; i<N; i++){
                tmp = trees[i]-mid;
                if(tmp>0){ total += tmp; }
            }
            if(M<=total){ left=mid+1; if(max<mid){ max = mid;} }
            else{ right = mid-1; }
        }
        System.out.println(max);
    }
}
