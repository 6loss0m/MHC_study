package BOJ.PS_1214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
    최소한의 점프로 목적지까지가는 문제입니다.
    최소한으로 점프하기위해 bfs 탐색을 사용하였습니다.

    조건
    1. 방문한적있고, 이미 저장된 cnt 값이 더 작다면 큐에 넣지않습니다.
    2. 방문한적없는 돌은 cnt+1 저장합니다.
    3. 방문한적있고, 이번 방문의 cnt 값이 더 작다면 큐에 넣습니다.

 */

public class StoneBridge {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int[] map = new int[100001];

        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);
        int end = Integer.parseInt(input[3]);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});  // {위치,cnt}

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int pos = now[0];
            int cnt = now[1];
            int[] nx ={pos+1, pos-1, pos+A, pos-A, pos+B, pos-B, pos*A, pos*B};

            if(pos==end){ System.out.println(map[pos]); return;}

            for(int i=0; i<8; i++){
                if(0<=nx[i] && nx[i]<=100000){
                    if(0<map[nx[i]] && map[nx[i]]<=cnt+1 ){ continue; }     // 방문한적있고, 기존값이 더 작다면 방문 x
                    if(map[nx[i]]==0){ map[nx[i]]= cnt+1; }                 // 방문한적없다면 cnt+1
                    else{ map[nx[i]]= Math.min(map[nx[i]],cnt+1); }         // 방문한적있고, 현재값이 더 작다면 최신화
                    queue.add(new int[]{nx[i],cnt+1});
                }
            }
        }
    }
}
