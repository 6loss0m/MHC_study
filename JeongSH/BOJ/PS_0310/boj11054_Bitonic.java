package BOJ.PS_0310;

/*
    문제 접근.
    정방향 증가 수열의 길이를 구하고,
    역방향 증가 수열의 길이를 구한 뒤,
    각 N 번째의 정방향과 역방향 수열의 길이의 합 중 가장 큰 값을 구합니다.

    팁.
    - 정방향과 역방향의 수열 길이의 합을 구한 뒤, -1 을 해주어야 함.
        바이토닉 수열중 가장 큰값이 두번 계산되었기 때문.



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11054_Bitonic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        int[] lds = new int[N];

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){ arr[i]= Integer.parseInt(input[i]); }

        int max;
        for(int i=0; i<N; i++){
            max = 0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    max = Math.max(max,lis[j]);
                }
            }
            lis[i] = max+1;
        }

        for(int i=N-1; i>=0; i--){
            max = 0;
            for(int j=N-1; j>i; j--){
                if(arr[i]>arr[j]){
                    max = Math.max(max,lds[j]);
                }
            }
            lds[i] = max +1;
        }

        int ret =0;
        for(int i=0; i<N; i++){
            ret = Math.max(lis[i]+lds[i],ret);
        }
        System.out.println(ret-1);
    }
}
