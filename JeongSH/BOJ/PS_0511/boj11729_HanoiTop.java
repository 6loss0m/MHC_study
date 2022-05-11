package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    하노이탑 문제..
    재귀식으로 풀이합니다.
    1번 -> 3번 으로 옮기기 위해서는
    n-1 개의 원판을 2번 장대로 옮겨야합니다. (가장 큰 원판은 바로 3번 으로 보내기 위해)
    가장큰 원판을 3번 장대로 옮기고
    n-1 개의 원판을 2 -> 3 번 장대로 옮기면 됩니다.

 */

public class boj11729_HanoiTop {
    static StringBuffer sb = new StringBuffer();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        hanoi(1,3,N);
        System.out.println(cnt);
        System.out.println(sb);
    }
    static void hanoi(int from, int to, int n){
        if(n==0){return;}
        hanoi(from,6-from-to,n-1);      // from=1, to=3, n=3 일 경우, hanoi(1,2,2) 를 호출합니다. 그리고 hanoi(1,3,1) 을 호출합니다.
        cnt+=1;                                 // 즉, 맨 위의 원판은 3번으로 옮겨집니다.
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(6-from-to,to,n-1);
    }
}
