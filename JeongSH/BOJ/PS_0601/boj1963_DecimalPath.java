package BOJ.PS_0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
    에라토스테네스의 체 와 bfs 를 사용하여 풀이하였습니다.

    1. 테스트케이스는 여러개가 존재 할 수 있므로, 네 자리 까지의 모든 소수를 먼저 구해주었습니다.
    2. bfs 를 사용하여 가장 먼저 목표 소수에 도달한다면 목표 소수까지의 변환 횟수는 항상 최소입니다.
        bfs 의 성질
    3. 각자리를 0~9까지 계속 변환하며 소수인지, 이미 방문을 했는지 체크합니다. (이미 방문했다면 또 방문할 필요가없습니다.)
    4. dist[] 를 두어 방문과 변환횟수를 저장합니다. ( -1 : 방문 안함. 0~n : 시작 소수와 해당 숫자의 변환 횟수 )

 */

public class boj1963_DecimalPath {
    static boolean[] isDecimal = new boolean[10000];  // 9999 까지의 소수 구하기
    static int[] dist = new int[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();
        setIsDecimal();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T; t++){
            Arrays.fill(dist,-1);       // 초기의 dist 는 -1 로 초기화합니다.
            String[] input= br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            queue.add(start);
            dist[start]=0;                  // 시작숫자와 목표숫자가 같을 경우 0을 반환해야합니다.
            boolean isPossible = false;     // 숫자를 변환할 수 있는지를 체크합니다.

            while (!queue.isEmpty()){
                int now = queue.poll();
                if(now == end){ sb.append(dist[now]).append("\n"); isPossible=true; break; }    // 시작숫자와 목표숫자가 같아지면 종료합니다.

                for(int i=0; i<4; i++){     // i번째 자리 숫자를 바꿉니다.
                    char[] crrNow = String.valueOf(now).toCharArray();
                    for(int j=0; j<10; j++){    //  i번째 자리 숫자를 j 로 바꿉니다.
                        crrNow[i] = (char) (j+'0');
                        int next = Integer.parseInt(new String(crrNow));

                        // 0039 같은 숫자는 제외해야하기 때문. dist[next]==-1 은 방문하지않은 곳.
                        if(next<1000 || !isDecimal[next] || dist[next]!=-1) { continue; }
                        queue.add(next);
                        dist[next] = dist[now]+1;   // 변환횟수를 늘려줍니다.
                    }
                }
            }
            if(!isPossible){ sb.append("Impossible").append("\n"); }    // 만들수없다면 Impossible 을 출력합니다.
            queue.clear();  // 중간에 break로 빠져나왔기 때문에 큐를 비워줍니다.
        }
        System.out.print(sb);
    }
    static void setIsDecimal(){     // 에라토스테네스의 체
        Arrays.fill(isDecimal,true);
        for(int i=2; i<5001; i++){
            for(int j=2; j*i<10000; j++){
                if(!isDecimal[i * j]){continue;}
                isDecimal[i*j]=false;
            }
        }
    }
}
