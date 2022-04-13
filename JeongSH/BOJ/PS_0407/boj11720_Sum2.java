package BOJ.PS_0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11720_Sum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int ret=0;
        for(int i=0; i<N; i++){ ret+= (input.charAt(i)-'0'); }
        System.out.println(ret);
    }
}
