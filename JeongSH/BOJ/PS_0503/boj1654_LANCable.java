package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    입력의 크기를 보고 이분탐색임을 눈치채면 편한문제 입니다..
    이분탐색을 합니다.
    계산과정 그리고 답, 모두 int 범위를 넘을 수 있습니다.
    long 으로 선언합니다.

 */

public class boj1654_LANCable {
    static int[] cable = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int maxLen = 0;
        for(int i=0; i<K; i++){
            cable[i]=Integer.parseInt(br.readLine());
            if(maxLen<cable[i]){maxLen = cable[i];}
        }

        long left = 1;
        long right = maxLen;
        long mid=0;
        long cnt=0;
        long max = 0;
        while (left <= right){
            mid = (left+right)/2;
            cnt = 0;
            for(int i=0; i<K; i++){
                cnt += cable[i]/mid;
            }
            if(cnt >= N) { left = mid+1; if(max<mid){max=mid;}}
            else {right = mid-1;}
        }
        System.out.println(max);
    }
}
