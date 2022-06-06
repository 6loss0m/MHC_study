package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
    쫄지말고 BFS로 접근합니다..
    결국 시작숫자에서 목표숫자까지의 최단거리를 출력하는 문제입니다.
    문자열을 추가로 계속 연결하는것은 메모리와 속도 두 측면 다 좋지않습니다.
    연산을 통해 구할 수 있기다면 연산을 통해 문제를 풀이합니다.

    시작숫자에서 갈 수 있는 모든 값을 BFS 탐색을 합니다.
    방문 한 숫자는 또 방문하지않는것이 좋기떄문에 방문을 체크합니다. (ex LRLRLRLR... )

 */

public class boj9019_DSLR {
    static boolean[] isVisit = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb= new StringBuffer();
        Queue<Register> queue = new LinkedList<>();
        int T = Integer.parseInt(br.readLine());

        String[] input;
        for(int t=0; t<T; t++){
            Arrays.fill(isVisit,false);
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int target = Integer.parseInt(input[1]);
            queue.add(new Register(start,""));
            isVisit[start]=true;

            while(!queue.isEmpty()){
                Register tmp = queue.poll();
                if(tmp.num==target){ sb.append(tmp.cmd).append("\n"); }
                int D = tmp.D();
                int S = tmp.S();
                int L = tmp.L();
                int R = tmp.R();
                if(!isVisit[D]){ queue.add(new Register(D,tmp.cmd+"D")); isVisit[D]= true; }
                if(!isVisit[S]){ queue.add(new Register(S,tmp.cmd+"S")); isVisit[S]= true; }
                if(!isVisit[L]){ queue.add(new Register(L,tmp.cmd+"L")); isVisit[L]= true; }
                if(!isVisit[R]){ queue.add(new Register(R,tmp.cmd+"R")); isVisit[R]= true; }

            }
            queue.clear();
        }
        System.out.println(sb);
    }
    static class Register{
        int num;
        String cmd;

        public Register(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }

        public int D(){ return (num*2)%10000; }
        public int S(){ return num == 0 ? 9999 : num-1; }
        public int L(){ return (num%1000)*10 + num/1000; }  // 결과적으로 네자리숫자를 왼쪽으로 한 칸 씩 미는것과 같습니다.
        public int R(){ return num/10 + (num%10)*1000; }    // 결과적으로 네자리숫자를 오른쪽으로 한 칸 씩 미는것과 같습니다.
    }
}
