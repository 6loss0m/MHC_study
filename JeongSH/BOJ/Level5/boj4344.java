
import java.io.*;
import java.util.StringTokenizer;

public class boj4344 {
    public static void main(String args[]) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t= Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            double avg =0;
            int count=0;
            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                avg += arr[j];
            }
            avg= avg/n;
            for(int j=0; j<n; j++){
                if(arr[j]>avg){count++;}
            }
            bw.write(String.format("%.3f",((double)count/n)*100)+"%\n");
        }
        bw.close();
    }
}
