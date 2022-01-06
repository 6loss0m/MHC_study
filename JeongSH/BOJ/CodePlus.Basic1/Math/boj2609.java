package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2609 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int max = Math.max(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]));
        int min = Math.min(Integer.parseInt(strArr[0]),Integer.parseInt(strArr[1]));
        int result1 = 0;
        for(int i=min; i>0; i--){
            if((max%i==0)&&(min%i==0)){result1=i; break;}
        }
        int result2 = 0;
        for(int i=1; i<=min ; i++){
            if((max*i)%min==0){result2=i*max; break;}
        }
        System.out.println(result1);
        System.out.println(result2);
    }
}
