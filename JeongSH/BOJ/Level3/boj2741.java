import java.io.*;

public class boj2741 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        for(int i=1; i<=input; i++){
            bw.write(i+"\n");
        }
        bw.close();
    }
}
