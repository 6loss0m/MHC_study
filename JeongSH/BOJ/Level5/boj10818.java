import java.io.*;
import java.util.StringTokenizer;

public class boj10818{
    public static void main(String args[]) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t= Integer.parseInt(br.readLine());
        int max;
        int min;
        st = new StringTokenizer(br.readLine());
        max=min=Integer.parseInt(st.nextToken());
        for(int i=1; i<t; i++){
            int e = Integer.parseInt(st.nextToken());
            if(e>max) max=e;
            if(e<min) min=e;
        }
        bw.write(min+" "+max);
        bw.close();
    }
}
