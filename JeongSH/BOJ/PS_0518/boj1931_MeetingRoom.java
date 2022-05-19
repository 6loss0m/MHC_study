package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    그리디 문제로
    시작 시간으로 해결하려고하면   start:1/ end:100
                               start:2/ end:3
                               start:3/ end:4
                               의 문제 해결에 오류가 생깁니다.
   회의의 종료시간을 기준으로 오름차순 정렬 하여 해결합니다.
   회의의 종료시간이 같다면 시작시간 기준으로 오름 차순으로 정렬합니다.

 */

public class boj1931_MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] time = new int[100000][2];  // [][0] = 시작 시간  /  [][1] = 끝 시간
        String[] input ;

        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            time[i][0]=Integer.parseInt(input[0]);
            time[i][1]=Integer.parseInt(input[1]);
        }
        Arrays.sort(time,0,N, (o1, o2) -> {
            if(o1[1]!=o2[1]) return o1[1]-o2[1];
            else { return o1[0] - o2[0];}
        });

        int end = time[0][1];   // 가장 빨리 끝나는 회의의 끝시간
        int ret = 1;
        for(int i=1;i<N;i++){
            if(time[i][0]<end){ continue;}  // 다음 회의 시작 시간 < 이전 회의 끝 시간     이면 무시
            end = time[i][1];               // 회의 배정
            ret+=1;
        }
        System.out.println(ret);
    }
}
