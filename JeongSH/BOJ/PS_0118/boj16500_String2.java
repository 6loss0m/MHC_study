package BOJ.PS_0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
    풀이1과 아이디어는 같지만
    중복적으로 문자열을 자르는것을 줄인 방법입니다.

    이미 목록에 있어서
    true 가 된 문자열 부터 자르기때문에
    문자열을 자르는 횟수가 매우많이 줄어들게됩니다.

 */

public class boj16500_String2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int T = Integer.parseInt(br.readLine());

        HashSet<String> A = new HashSet<>();
        int len = S.length();

        for(int t=0;t<T;t++){ A.add(br.readLine()); }

        Boolean[] possible = new Boolean[len+1];
        possible[0]=true;

        for(int i=0;i<len; i++){
            int pre = i;
            if(possible[pre]==null){continue;}
            for(int j=i+1; j<=len; j++){
                if(A.contains(S.substring(pre,j))){ possible[j]=true; }
            }
        }

        if(possible[len]!=null){ System.out.println(1); return;}
        System.out.println(0);

    }
}
