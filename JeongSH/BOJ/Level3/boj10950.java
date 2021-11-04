import java.util.Scanner;

public class boj10950 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<t; i++) {
            String input = sc.nextLine();
            String[] token = input.split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            System.out.println(a+b);
        }
    }
}