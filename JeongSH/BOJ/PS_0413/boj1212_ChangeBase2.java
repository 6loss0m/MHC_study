package BOJ.PS_0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    1212 의 반대 버전 입니다.
    String 은 + 로 연결할 경우 O(n) 의 시간복잡도를 가진다고합니다.
    StringBuffer 의 append 를 사용하면 해결할 수 있습니다.

 */

public class boj1212_ChangeBase2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();
        int len = input.length();

        String ret ="";
        for(int i=0; i<len; i++){
            int n = input.charAt(i)-'0';
            String tmp;
            String _1="0";
            String _2="0";
            String _3="0";
            if(n> 3){ n-=4; _1 ="1"; }
            if(n> 1){ n-=2; _2 ="1"; }
            if(n> 0){ n-=1; _3 ="1"; }
            tmp = _1 + _2+ _3;
            if(i==0){ sb.append(String.valueOf(Integer.parseInt(tmp)));}
            else {sb.append(tmp);}
        }
        System.out.println(sb);
    }
}
