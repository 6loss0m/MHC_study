import java.io.*;

public class boj2439 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());

        for(int l=1; l<=input ; l++){
            for(int b=input-l; b>0; b--)
                bw.write( " ");
            for(int s=0; s<l ; s++)
                bw.write("*");
            bw.write("\n");
        }
        bw.close();
    }
}
