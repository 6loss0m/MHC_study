import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class boj3052 {
    public static void main(String args[])throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<10; i++)
            set.add(Integer.parseInt(br.readLine())%42);
        bw.write(String.valueOf(set.size()));
        bw.close();
    }
}
