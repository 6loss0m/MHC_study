package BOJ.PS_0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
    아이디어
    1. 0부터 도착 지점까지 1칸씩 이동하기
    2. 지금 칸이 어느 지름길의 도착지점일 경우
        min(지름길사용,그냥이동) 비교

    주의점
    최소값을 비교하기때문에 초기 값으로 0을 세팅하면 옳바른 계산이 되지않습니다.


 */

public class boj1446_Shortcut {
    public static final int MAX_DIST = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] road = new int[MAX_DIST];

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int D = Integer.parseInt(inputs[1]);


        ArrayList<Shortcut>[] list = new ArrayList[MAX_DIST];
        for (int i = 0; i < MAX_DIST; i++) { list[i]=new ArrayList<>();}
        Arrays.fill(road,Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            int cost = Integer.parseInt(inputs[2]);

            if(end - start <= cost){continue;}
            if(end > D){continue;}

            list[end].add(new Shortcut(start,end,cost));
        }

        road[0]=0;
        for(int i=1 ;i <= D; i++){
            if(list[i].size()>0){
                for(Shortcut s :list[i]){
                    if (road[s.start]+s.cost > road[i]) { continue; }   // 중복 지름길 계산 할 때
                    road[i] = Math.min(road[i-1]+1, road[s.start]+s.cost);
                }
                continue;
            }
            road[i]=road[i-1]+1;
        }
        System.out.println(road[D]);
    }
    static class Shortcut{
        int start;
        int end;
        int cost;

        public Shortcut(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
