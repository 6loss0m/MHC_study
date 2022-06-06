package BOJ.BOJ0601;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class PrintStar16_10991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = n-i-1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
