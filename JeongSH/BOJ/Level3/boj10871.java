import java.io.*;
import java.util.StringTokenizer;

public class boj10871 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        st=new StringTokenizer(input);

        for(int i=0; i<n; i++){
            int e = Integer.parseInt(st.nextToken());
            if(e<x) bw.write(e+" ");
        }
        bw.close();
    }
}
