package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    구현 문제

 */

public class boj2875_Internship {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int team = N >= (M*2) ? M : N/2;    // 남,여 숫자중 팀을 구성하는 최대의 값을 구합니다.
        int rest = N+M - team*3;            // 팀을 구성하고 남은 인원을 구합니다.
        K -= rest;                          // 남은 인원으로 인턴쉽에 참여할 인원을 채웁니다.
        while (K>0){                        // 인턴쉽 인원이 다 차지않았다면 팀을 하나씩 없애며 채웁니다.
            team-=1;
            K-=3;
        }
        System.out.println(team);
    }
}
