package BOJ.PS_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    아이디어
    000101101100100011
    00000100100011
    000001111
    1 : 4
    0 : 5
    앞에서 부터 1 지우기
    뒤에서 부터 0 지우기

 */
public class boj20310_Thanos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();
        char[] arr = new char[length];

        int oneCnt = 0;
        int zeroCnt = 0;
        for (int i = 0; i < length; i++) {
            arr[i] = input.charAt(i);
            if(arr[i]=='1'){ oneCnt++; }
            else{ zeroCnt++; }
        }
        oneCnt/=2;
        zeroCnt/=2;

        for (int i = 0; i < length; i++) {
            if(oneCnt==0){break;}
            if(arr[i]=='1'){arr[i]=' '; oneCnt--;}
        }
        for(int i =length-1; i>=0 ; i--){
            if(zeroCnt==0){break;}
            if(arr[i]=='0'){ arr[i]=' '; zeroCnt--;}
        }

        System.out.println(String.valueOf(arr).replaceAll(" ",""));
    }

}
