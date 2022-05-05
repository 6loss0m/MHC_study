package BOJ.PS_0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    이분탐색 문제입니다.
    보통 입력제한 조건을 보고 감을 잡을 수 있습니다.

    - 다른 알고리즘 문제들은 보통,
    과정 -> 답
    통해서 답을 도출하는데

    - 이분탐색은
    가설 -> 검증 -> 참,거짓 판단
    과 유사합니다.
    참이라면 더 큰 수를 넣거나 거짓이면 더 작은 수가 들어갈 수 있게하여
    가설 -> 검증 -> 참,거짓 판단
    과정에서 원하는 답을 찾아냅니다.

 */

public class boj2110_Wifi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] houses = new int[200000];

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        for(int i=0; i<N; i++){
            houses[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses,0,N);

        long left=1;
        long right=houses[N-1];
        long mid;
        long cnt;
        long max = 0;
        while (left<=right){
            mid = (left+right)/2;
            cnt = 1;
            int now = houses[0];
            for(int i=1; i<N; i++){
                if(houses[i]-now >= mid){ now = houses[i]; cnt+=1; }
            }
            if(cnt >= C) { max = mid ; left = mid+1; }
            else {right = mid-1;}
        }
        System.out.println(max);

    }
}
