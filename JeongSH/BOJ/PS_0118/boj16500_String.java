package BOJ.PS_0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
/*
    첫번째 풀이 : 시간초과

    아이디어
    1. 앞에서부터 i 번째까지 자른 문자열이 문자열 목록에 있는지 확인합니다.
    2. 문자열 목록에 포함되어있다면 재귀식으로 i번 째부터 시작하는 문자열을 만들어나갑니다.
    ex)
    softwarecontest
    software            : 문자열 존재
          [7]           : boolean[7] = true
            func(7)     : 같은 식으로 반복
    ex)
    softwarecontest
    soft , software, contest
    func(3) 호출  : boolean[3] = true
        재귀식으로 탐색하지만 충족 x
    func(7) 호출  : boolean[7] = true
        충족

    시간초과 이유
    재귀식으로 호출되는 모든 문자열을 자르기때문


 */

public class boj16500_String {
    static String S;
    static int len;
    static Boolean[] possible;
    static HashSet<String> A = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){ A.add(br.readLine()); }

        len = S.length();
        possible = new Boolean[len];

        for(int i=1;i<=S.length();i++){
            String split = S.substring(0,i);
            if(A.contains(split)){ go(i); }
        }
        System.out.println(possible[len-1]==null? 0:1);
    }

    static void go(int start){
        if(start>len){return;}

        possible[start-1]=true;
        for(int i=start; i<=len;i++){
            String split = S.substring(start,i);
            if(A.contains(split)){ go(i); }
        }
    }

}
