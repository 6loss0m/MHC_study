package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    B진법은 N을 B로 몫이 0이 될때까지 나누고,
    그 과정에서 생긴 나머지를 역순으로 이어주면 됩니다.

 */

public class boj11005_Base {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ret = "";
        String[] input =br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        while(true){
            int q = N/B; // 몫
            int r = N%B;  // 나머지
            N = q;
            if(r>9) {r-= 10; ret = (char)('A'+r)+ret; }
            else { ret = r+ret; }
            if(q==0){break;}
        }
        System.out.println(ret);
    }
}
