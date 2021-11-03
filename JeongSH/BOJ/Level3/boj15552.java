import java.io.*;
import java.util.StringTokenizer;

public class boj15552 {
    public static void  main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for(int i=0; i<t; i++){
            String input = bf.readLine();
            st=new StringTokenizer(input);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            bw.write((a+b)+"\n");
        }
        bw.close();
    }
}