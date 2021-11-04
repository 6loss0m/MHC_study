import java.util.Scanner;

public class boj1330 {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] tokens = input.split(" ");

        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        if (a>b) System.out.println(">");
        if (a<b) System.out.println("<");
        if (a==b) System.out.println("==");
    }
}
