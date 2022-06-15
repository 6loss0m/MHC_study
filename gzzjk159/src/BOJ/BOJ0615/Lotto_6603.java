package BOJ.BOJ0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto_6603 {
    static int k;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] input = br.readLine().split(" ");
            k = Integer.parseInt(input[0]);

            if(k==0){ break; }

            arr = new int[k];
            visited = new boolean[k];
            for (int i = 1; i < k+1; i++) { arr[i-1]=Integer.parseInt(input[i]); }

            choicelotto(0,0);
            System.out.println();
        }
    }
    public static void choicelotto(int start, int cnt) {
        if(cnt==6){
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        for (int i = start; i < arr.length; i++) {
            visited[i]=true;
            choicelotto(i+1,cnt+1);
            visited[i]=false;
        }
    }

}
