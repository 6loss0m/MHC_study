package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    재귀식으로 풀이하였습니다.
    순회하며 각 종이안에 서로 다른 숫자가 적혀있으면 더 작게 분할하여
    탐색합니다.

 */

public class boj1780_Paper {
    static int[][] paper;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        count = new int[3];
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                paper[i][j]=Integer.parseInt(input[j]);
            }
        }
        dfs(0,0,N);
        System.out.println(count[0]+"\n"+count[1]+"\n"+count[2]);
    }
    static void dfs(int y, int x, int cur){
        int now = paper[y][x];
        boolean isSame = true;          // 종이의 첫부분
        for(int i=y;i<y+cur;i++) {
            for (int j = x; j < x + cur; j++) {
                if (now != paper[i][j]) { isSame = false;break; }   // 종이의 첫 부분과 다르다면 종이를 더 잘라야합니다.
            }
            if (!isSame){break;}
        }
        if(isSame){ count[now+1]+=1; return;}   // 만약 종이안의 모든 숫자가 같다면 갯수 증가
        int k = cur/3;                          // 종이를 9등분하기위해 ..
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                dfs(y+i*k,x+j*k,k);       // 9짜리 종이었다면 -> dfs(0,0,3) , dfs(0,3,3), dfs(0,6,6)
            }                                   //                   dfs(1,0,3) , dfs(1,3,3), dfs(1,6,6)
        }                                       //                   dfs(2,0,3) , dfs(2,3,3), dfs(2,6,6) 호출하게됩니다.
    }
}
