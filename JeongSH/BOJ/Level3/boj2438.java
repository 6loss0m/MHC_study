import java.io.*;

public class boj2438 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());

        for(int l=1; l<=input; l++){
            for(int c=0;c<l;c++)
                bw.write("*");
            bw.write("\n");
        }
        bw.close();
    }
}