import java.io.*;
import java.util.StringTokenizer;

public class boj1546 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int t= Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        st=new StringTokenizer(br.readLine());
        arr[0]= Integer.parseInt(st.nextToken());
        int M = arr[0];
        double answer=0;
        for(int i=1; i<t; i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(M<arr[i]){M=arr[i];}
        }
        for(int i=0; i<t; i++){
            answer += (double) arr[i]/M*100;
        }
        bw.write(String.valueOf(answer/t));
        bw.close();

    }
}
