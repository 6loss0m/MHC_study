import java.io.*;

public class boj2577 {

    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int c=Integer.parseInt(br.readLine());
        String mul = String.valueOf(a*b*c);
        for(int i=0; i<=9; i++)
            bw.write(String.valueOf(countNum(mul,i))+"\n");
        bw.close();
    }
    public static int countNum(String input, int n){
        return input.length() - input.replace(String.valueOf(n),"").length();
    }

}