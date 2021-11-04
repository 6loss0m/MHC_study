
import java.io.*;

public class boj1110 {
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        if(input.length()<2){
            input="0"+input;
        }
        int answer=0;
        int s=0;
        int a = Integer.parseInt(String.valueOf(input.charAt(0)));
        int b = Integer.parseInt(String.valueOf(input.charAt(1)));
        String newNum="";
        do{
            answer=a+b;
            String tmp = String.valueOf(answer);
            newNum = b + tmp.substring(tmp.length()-1);
            a=Integer.parseInt(String.valueOf(newNum.charAt(0)));
            b=Integer.parseInt(String.valueOf(newNum.charAt(1)));
            s++;
        }while(!input.equals(newNum));
        bw.write(String.valueOf(s));
        bw.close();
    }
}
