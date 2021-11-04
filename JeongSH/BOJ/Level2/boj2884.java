import java.util.Scanner;

public class boj2884 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] token = input.split(" ");

        int inputH = Integer.parseInt(token[0]);
        int inputM = Integer.parseInt(token[1]);
        int h;
        int m;

        if(inputM-45 < 0){
            h=inputH-1;
            if(h<0) h=h+24;
            m=inputM+15;
        }
        else{
            h=inputH;
            m=inputM-45;
        }
        System.out.println(h+" "+m);
    }
}
