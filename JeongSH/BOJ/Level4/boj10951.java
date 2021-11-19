import java.io.*;
import java.util.StringTokenizer;

public class boj10951 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String input="";
        while((input = br.readLine())!=null){
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            bw.write(a+b+"\n");
        }
        bw.close();
    }
}