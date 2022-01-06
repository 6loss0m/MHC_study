package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj4375_1 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while ((line= br.readLine()) != null){
            int n = Integer.parseInt(line);
            int tmp = 1;
            // (A+B)%C == (A%C+B%C)%C
            // (tmp*10+1)%n = 0
            // ((tmp*10)%n + 1 )%n= 0
            int cnt=0;
            while (tmp%n!=0){
                tmp = (tmp*10)%n + 1;
                cnt++;
            }
            System.out.println(cnt+1);
        }
    }
}
