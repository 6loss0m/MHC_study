import java.util.Scanner;

public class boj8393 {
    public static void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int input =sc.nextInt();
        int answer=0;
        for(int i=1; i<=input ; i++) {answer+=i;}
        System.out.println(answer);
    }
}
