package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1978_Decimal {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] strArr = br.readLine().split(" ");
        int cnt=0;
        for(int i=0; i<strArr.length; i++){
            if(isDecimal(Integer.parseInt(strArr[i]))){cnt++;}
        }
        System.out.println(cnt);
    }
    public static Boolean isDecimal (int n){
        if(n==1){return false;}
        for(int i=2; i<n; i++){
            if(n%i==0){return false;}
        }
        return true;
    }
}
