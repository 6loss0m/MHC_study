package BOJ.BOJ0601;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrintStar9_2446 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < (2*n -1)-(2*i); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = 1; j < (n-1)-i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 3+2*i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
