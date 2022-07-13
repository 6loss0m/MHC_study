package BOJ.BOJ0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class partSum_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int[] num = new int[n];
        for (int i = 0; i < n ; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        int start = 0;
        int end = 0;
        int total = 0;
        int answer = Integer.MAX_VALUE;
        while(start<n && end<n){
            if(total>=s&& answer > end-start){
                answer = end -start;
            }
            if(total<s){
                total+=num[end++];
            }
            else total-= num[start++];
        }
        if(answer== Integer.MAX_VALUE){ System.out.println("0"); }
        else { System.out.println(answer); }
    }
}
