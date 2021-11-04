
import java.io.*;
import java.util.StringTokenizer;

public class boj8958 {
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int score;

        for(int i=0; i<t; i++){
            score=0;
            String input = br.readLine();
            st =new StringTokenizer(input,"X");
            String e;
            while(st.hasMoreTokens()){
                e=st.nextToken();
                score+=scoreO(e);
            }
            bw.write(String.valueOf(score)+"\n");
        }
        bw.close();
    }
    public static int scoreO(String input){
        int n = input.length();
        int result =0;
        for(int i=1; i<=n; i++) result+=i;
        return result;
    }
}
