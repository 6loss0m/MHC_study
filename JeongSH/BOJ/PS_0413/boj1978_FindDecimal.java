package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/*
    에라스토테네스의 체를 사용하여 풀어보았습니다.
    입력받은 숫자의 최대값까지 먼저 소수를 전부 구하고
    각각 입력받은 숫자가 소수인지 판단합니다.

 */

public class boj1978_FindDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] decimal = new int[1001];
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){ arr[i]=Integer.parseInt(input[i]); }
        Arrays.sort(arr, Collections.reverseOrder());
        int max = arr[0]+1;

        decimal[0]=decimal[1]=1;
        for(int i=2; i<max; i++){
            for(int j=2; j*i<max; j++){
                if(decimal[j*i]==1){continue;}
                decimal[j*i]=1;
            }
        }
        int ret=0;
        for(int i=0; i<N; i++){ if(decimal[arr[i]]==0){ret+=1;} }
        System.out.println(ret);
    }
}
