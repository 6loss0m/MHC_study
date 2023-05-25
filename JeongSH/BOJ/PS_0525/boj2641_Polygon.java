package BOJ.PS_0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    아이디어
    문제를 보고 같은 모양은 수열의 시작 점만 다를뿐 수열이 같다는 힌트를 얻었습니다.
    1411433322
    3221411433 (오른쪽으로 밀기)
    ->
           322
    1411433

    1. 각각 시작 인덱스를 다르게하여 두 수열을 비교하여 같은지 확인 할 수있습니다.
    2. 역 방향으로 돌아도 같은 모양이기 때문에
        1->3 , 2->4, 3->1, 4->2
        바꾸어서 비교해야합니다.
    3. 방향을 바꾸었기 떄문에 탐색도 역순으로 해야합니다.
        저는 만들어둔 함수를 재사용하기 위해 입력 배열자체를 뒤집었습니다.

 */

public class boj2641_Polygon {
    static int len;
    static int N;
    static final int[] reverse = {0,3,4,1,2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        len = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] origin1 = new int[len];           // 정방향
        int[] origin2 = new int[len];           // 역방향

        for (int i = 0; i < len; i++) {
            origin1[i]=Integer.parseInt(inputs[i]);
            origin2[len-i-1]=reverse[origin1[i]];   // 역방향, 역순
        }

        N = Integer.parseInt(br.readLine());

        int[][] comp = new int[N][len];
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < len; j++) {
                comp[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int cnt = 0;
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(isSame(origin1,comp[i])){ cnt++; ret.add(i); }
            else if(isSame(origin2,comp[i])){ cnt++; ret.add(i); }  // 역방향의 역순과도 비교
        }

        System.out.println(cnt);
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < len; j++) {
                sb.append(comp[ret.get(i)][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static boolean isSame(int[] a, int b[]){
        for (int i = 0; i < len; i++) {
            int cnt=0;
            for (int j = 0; j < len; j++) {
                if ( a[j] == b[(i+j)%len] ){ cnt++; }
            }
            if(cnt==len){ return true;}
        }
        return false;
    }
}
