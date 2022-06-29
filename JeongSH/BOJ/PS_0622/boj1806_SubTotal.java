package BOJ.PS_0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

    투포인터 문제입니다
    현재의 부분합이 M 보다 크거나 같다면 길이를 계산하여 최솟값을 저장합니다.(구간합의 시작점을 줄여가며)
    현재의 부분합이 M 보다 작다면 구간을 늘려줍니다.

 */

public class boj1806_SubTotal {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[100000];

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        input=br.readLine().split(" ");
        for (int i = 0; i < N; i++) { arr[i]=Integer.parseInt(input[i]); }

        int s=0, e=0, sum=arr[0], len=N+1;
        while (s<=e && e<N){
            if(sum<M){ sum+= arr[++e]; }
            else { len=Math.min(len,e-s+1); sum-= arr[s++]; }   // 길이를 계산하고 구간합의 시작점을 줄입니다.
        }

        if(len==N+1){ len=0; }
        System.out.println(len);

    }
}
