package BLIND_2018_2;
/*
    0 ~ 계속
    1. 돌면서 모든 숫자를 n진수 시킵니다.( while 문 )
    2. n 진수화 된 숫자를 쪼개서 튜브의 차례가 맞다면 추가합니다. for(0:strNum.length)
    3. t 갯수만큼 추가했다면 모든 반복문을 탈출합니다.

 */

public class BaseGame {
    public static void main(String[] args) {
        int n=16;  //진수
        int t=16;  // 미리구할 숫자 갯수
        int m=2;  // 참가인원
        int p=2;  // 튜브의 순서

        p--;
        int num=0;
        int turn=0;
        int cnt=0;
        boolean end = false;
        StringBuilder sb= new StringBuilder();
        while (!end){
            String strNum = Integer.toString(num,n);    // n 진수화
            for(int j=0;j<strNum.length();j++){     // n 진수화 된 숫자를 하나하나 쪼개서 탐색
                if(turn%m==p){ sb.append((""+strNum.charAt(j)).toUpperCase()); cnt++; } // 튜브차례
                turn++;                                     // turn 증가
                if(cnt==t){ end=true; break; }              // 모두 찾았으면 모든 반복문 탈출.
            }
            num++;
        }
        System.out.println(sb.toString());
    }
}
