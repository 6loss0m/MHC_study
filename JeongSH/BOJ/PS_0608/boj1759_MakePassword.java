package BOJ.PS_0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    문자열을 만드는 문제입니다.
    처음에 문자열을 정렬한다면 세부적으로 다시 정렬할 필요없이 조합문제로 풀 수 있습니다.
    그리고 정렬을 하였기때문에 마지막 출력때도 다시 정렬할 필요가없습니다.

    dfs 탐색을 하며 현재의 모음,자음 갯수 그리고 문자열 길이를 인자로 넘겨줍니다.
    넘겨진 인자들이 조건을 충족한다면 추가해줍니다.

 */

public class boj1759_MakePassword {
    static int L,C;
    static int mo = 1;  // 최소 모음갯수
    static int ja = 2;  // 최소 자음갯수
    static char[] words = new char[15];
    static boolean[] visit = new boolean[15];
    static StringBuffer sb = new StringBuffer();    // list 대신 사용하였습니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        input=br.readLine().split(" ");
        for (int i = 0; i < C; i++) { words[i]=input[i].charAt(0); }
        Arrays.sort(words,0,C);

        dfs(0,0,"",0,0);

        System.out.print(sb);

    }

    static void dfs(int nowM, int nowJ, String str, int depth, int idx){
        if(nowM >= mo && nowJ>= ja && depth==L) { sb.append(str).append("\n"); }

        for (int i = idx; i < C; i++) {
            if(!visit[i]){
                visit[i]=true;
                if( isMo(words[i])){ dfs(nowM+1,nowJ,str+words[i], depth+1, i);}
                else{ dfs(nowM,nowJ+1,str+words[i], depth+1, i); }
                visit[i]=false;
            }
        }
    }

    static boolean isMo(char c){ return (c=='a'|| c=='e'|| c=='i' || c=='o'|| c=='u'); } // a, e, i, o, u
}
