package BOJ.PS_0331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제조건 꼼꼼히 읽기..

    int 범위를 벗어나기때문에,
    long 으로 계산해야합니다.

 */

public class boj10824_Num4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        System.out.println(Long.parseLong(in[0]+in[1]) + Long.parseLong(in[2]+in[3]));

    }
}
