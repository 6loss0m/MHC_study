package BOJ.PS_0615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    간단한 조합을 만드는 문제입니다.
    이미 오름차순으로 입력이 주어지므로 따로 정렬할 필요가없습니다.

 */

public class boj6603_Lotto {
    static int S;
    static int[] arr = new int[13];
    static boolean[] visit = new boolean[13];
    static StringBuffer sb = new StringBuffer();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        while (!(input = br.readLine().split(" "))[0].equals("0")) {
            Arrays.fill(arr, 0);
            Arrays.fill(visit, false);

            S = Integer.parseInt(input[0]);
            for (int i = 0; i < S; i++) {
                arr[i] = Integer.parseInt(input[i+1]);
            }
            dfs(0,"",0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, String str, int idx){    // 문자열을 인자로 주고받으면 따로 문자열 추가 삭제가 필요없습니다.
        if(depth==6){ sb.append(str.trim()).append("\n"); return;}

        for(int i=idx;i<S; i++){    // i 는 idx 부터 시작해야합니다. 조합이기때문
            if( !visit[i] ){
                visit[i]=true;
                dfs(depth+1, str+" "+arr[i],i);
                visit[i]=false;
            }
        }
    }

}
