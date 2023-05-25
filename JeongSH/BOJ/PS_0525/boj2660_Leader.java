package BOJ.PS_0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
    아이디어
    회원이 50명이기 때문에 최대 깊이가 50이 됩니다.
    각 회원 별로 깊이를 조사하기때문에
    O(N^2) 고 충분히 가능할거라고 생각했습니다.

    관계가 그래프 형식을 띄고 각 노드마다 깊이를 구하므로 bfs 를 사용하였습니다.
    1. 각 회원별로 각각의 깊이를 구합니다.
    2. 한 회원의 점수는 가장깊은 깊이가 됩니다.
    3. 가장 낮은 점수의 회원이 회장이 되기때문에 위에서 구한 깊이를 기준으로 최저점이 몇명인지, 누구안지 구해줍니다.

 */

public class boj2660_Leader {
    static int N;
    static ArrayList<Integer>[] tree = new ArrayList[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb =new StringBuffer();

        N = Integer.parseInt(br.readLine());

        String[] inputs;
        for (int i = 0; true ; i++) {
            inputs = br.readLine().split(" ");
            int from = Integer.parseInt(inputs[0]);
            int to = Integer.parseInt(inputs[1]);
            if(from==-1){ break; }
            if(tree[from]==null){ tree[from] = new ArrayList<>();}
            if(tree[to]==null){ tree[to]=new ArrayList<>(); }
            tree[from].add(to);
            tree[to].add(from);
        }

        int[] arr = new int[N+1];
        int min = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++){
            arr[i] = search(i);
            min = Math.min(min, arr[i]);
        }

        sb.append(min).append(" ");
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if(min == arr[i]){
                sb.append(i).append(" ");
                cnt++;
            }
        }
        sb.insert(2,cnt+"\n");
        System.out.println(sb);
    }

    static int search(int n){
        Queue<Integer[]> q = new LinkedList<>();
        int[] visit = new int[N+1];

        q.add(new Integer[]{n,0});
        visit[n]=1;

        while (!q.isEmpty()){
            Integer[] poll = q.poll();
            int now = poll[0];
            int depth = poll[1];

            for(int next : tree[now]){
                if(visit[next]==0){
                    q.add(new Integer[]{ next,depth+1 });
                    visit[next]=depth+1;
                }
            }
        }

        int max=-1;
        for(int m : visit){
            if(m==0){continue;}
            max = Math.max(max,m);
        }
        return max;
    }
}
