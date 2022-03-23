package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10952_Sum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] input;
        while (true){
            input = br.readLine().split(" ");
            if(input[0].equals("0") && input[1].equals("0")){break;}
            sb.append(Integer.parseInt(input[0])+Integer.parseInt(input[1])).append("\n");
        }
        System.out.println(sb);
    }
}
