package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    입출력..

 */

public class boj11718_Re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String in;
        while (true){
            in = br.readLine();
            if(in == null) {break;}
            sb.append(in).append("\n");
        }
        System.out.println(sb);
    }
}
