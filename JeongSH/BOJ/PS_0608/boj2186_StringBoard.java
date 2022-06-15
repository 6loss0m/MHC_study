package BOJ.PS_0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    dfs 탐색과 메모리제이션을 사용하여 풀이하였습니다.
    처음 문제를 풀었을 땐 dfs 만 사용하여 풀이하였더니 시간초과가 났습니다.

    이를 해결하고자 중복된 계산이있다면 최적화를 통해 불필요한 탐색을 줄이도록 하였습니다.
    불필요한 탐색이 있는경우.
    주어진 단어 : BREAK , K=1
    ex)
    K A E A K
    x x R B x
    x x B x x

    a. 맨 아랫줄의 B 부터 경우의 수를 센다고 가정했을 경우
        E A K     K A E                 dp  1 1 1    1 1 2
        R             R                     1            2
        B             B                     1            2
      두 가지 경우가 존재합니다.

    b. 이어서 두번째 줄의 B 부터 시작하게되면
        E A K    K A E                              dp   2 1 1      1 1 2
        R B          R B                                 2 1            2 1
      마찬가지로 두 가지 경우가 존재합니다.

    - 여기서의 중복 탐색은 R 부터 일어나게됩니다. B의 시작점은 다르나, R 을 만났을 때, 이미 a의 결과로 이 경로의 경우의 수 는 2가지임을
      미리 알 수 있습니다.
      그러므로 메모리제이션을 사용하여 불필요한 탐색을 줄이도록 합니다.

    팁:
    주어진 문자열이 BREAK 일 경우
    dp[y][x][index] index 가 의미하는것.
    dp[y][x][1] 해당 xy 에서 주어진 문자열의 1번 인덱스(=R) 경로

 */

public class boj2186_StringBoard {
    static int N,M,K;
    static char[][] board = new char[100][100];
    static int [][][] dp = new int[100][100][80];   // 메모리제이션을 사용할 배열
    static String answer;
    static int ansLen;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        String in;
        for(int i=0;i<N; i++){
            in = br.readLine();
            for(int j=0;j<M; j++){
                Arrays.fill(dp[i][j],-1);   // 초기값은 -1로 해둡니다.
                board[i][j]=in.charAt(j);
            }
        }
        answer = br.readLine();
        ansLen = answer.length();

        char start=answer.charAt(0);
        int count =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(start!=board[i][j]){continue;}
                dfs(i,j,0);
                count+=dp[i][j][0];
            }
        }
        System.out.println(count);
    }

    static void dfs(int y,int x, int depth){
        if(depth+1==ansLen){ dp[y][x][depth]=1; return;}    // depth+1 == ansLen 것은 정답문자열 하나의 경우의 수를 찾은 경우입니다.
        if(dp[y][x][depth]!=-1){ return; }                  // !-1 이라면 이미 방문을 한 곳입니다.
        dp[y][x][depth]=0;                                  // 방문을 한다면 일단 0으로 초기화합니다.

        for(int i=0; i<4;i++){
            for(int k=1;k<=K; k++){
                int nx = dx[i]*k + x;
                int ny = dy[i]*k + y;
                if(!isRange(ny,nx)){ continue; }
                if(answer.charAt(depth+1)==board[ny][nx]){
                    dfs(ny,nx,depth+1);
                    dp[y][x][depth]+= dp[ny][nx][depth+1];  // dp[ny][nx][depth+1] 은 이미 위의 dfs() 의 결과로 최신화가 되어있습니다.
                                                            // dp[y][x][depth]에 더해주는 이유는 위 설명 중 a 경우에서 E 에 2가 적혀야 하기때문입니다.
                }
            }
        }
    }
    static boolean isRange(int y,int x){ return 0<=y && y<N && 0<=x && x<M; }
}
