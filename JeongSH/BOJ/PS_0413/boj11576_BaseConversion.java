package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    입력받은
    A진수 숫자 -> 10 진수 숫자 -> B진수 숫자
    로 변환합니다.

 */

public class boj11576_BaseConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[25];
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);     // target base
        int B = Integer.parseInt(input[1]);
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        for(int m=0; m<M; m++){ arr[m]=Integer.parseInt(input2[m]); }

        int n=0;
        int tmp = 1;
        for(int m=M-1; m>=0; m--){
            n = n + (tmp * arr[m]);
            tmp *= A;
        }
        String ret = "";
        while(n!=0){
            int q = n/B;
            int r = n%B;
            ret = r+" "+ ret;
            n = q;
        }
        System.out.println(ret);
    }
}
