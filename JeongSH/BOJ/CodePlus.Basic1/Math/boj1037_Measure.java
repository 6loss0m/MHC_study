package CodePlus.Basic1.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1037_Measure {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int max=2;
        int min=1000000;
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        System.out.println(min*max);
    }
}
