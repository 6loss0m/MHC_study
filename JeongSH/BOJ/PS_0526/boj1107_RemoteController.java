package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    완전탐색 문제입니다.

    이동하려는 채널을 가는 방법은 세가지입니다.
    1. +,- 를 이용해서 가는 방법     |목표채널 - 100|
    2. 채널을 눌러서 이동하는 방법     목표채널의 length
    3. 근처 채널로 이동해서 +,- 를 이용하는 방법    근처채널의 length + |목표채널 - 근처채널|

 */

public class boj1107_RemoteController {
    static boolean[] isErrorBtn=new boolean[10];
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strTarget = br.readLine();
        int target = Integer.parseInt(strTarget);
        int M = Integer.parseInt(br.readLine());

        if(M!=0){
            String[] errorBtn = br.readLine().split(" ");
            for(int i=0;i<M;i++){isErrorBtn[Integer.parseInt(errorBtn[i])]=true;}
        }
        min = Math.abs(target-100);         // 채널이동의 최대값은 |목표채널 - 현재채널|
        for(int i=0;i<1000001; i++){        // 목표채널이 500000이기때문에 0에서 부터 접근하는것과, 1000000 에서 접근하는것 둘다 고려해야됨.
            String s = String.valueOf(i);
            if(isTrance(s)){
                int len = s.length();
                min = Math.min(Math.abs(target-i)+len, min);    // 근처 채널로 이동해서 가는것을 비교.
            }
        }
        System.out.println(min);
    }
    static boolean isTrance(String s){  // 입력값 s 를 리모컨으로 만들수있는가.
        int m = s.length();
        for(int i=0;i<m;i++){
            int tmp = s.charAt(i)-'0';
            if(isErrorBtn[tmp]){return false;}
        }
        return true;
    }
}
