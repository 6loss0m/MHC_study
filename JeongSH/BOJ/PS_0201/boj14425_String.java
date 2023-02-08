package BOJ.PS_0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
    set 을 사용한 기본 문제.

 */

public class boj14425_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        for (int i = 0; i < N; i++) { set.add(br.readLine()); }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if(set.contains(br.readLine())){cnt++;}
        }

        System.out.println(cnt);
    }
}
