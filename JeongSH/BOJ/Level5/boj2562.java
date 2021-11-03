import java.io.*;

public class boj2562 {
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int max,maxIndex;
        max=Integer.parseInt(br.readLine());
        maxIndex=1;
        for(int i=1; i<9; i++){
            int x=Integer.parseInt(br.readLine());
            if(max<x) {max=x; maxIndex=i+1;}
        }
        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(maxIndex));
        bw.close();
    }
}
