package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    팩토리얼의 0 을 세는 문제와 비슷합니다.
    다만 조합의 계산방법은
    nCr = n! / r!(n-r)!


    팩토리얼 문제는 2의 갯수가 항상 5의 갯수보다 많아 5의 갯수를 세었지만
    이번 문제는 나누기 연산이 들어가게됩니다.
    즉, 2의 갯수도 세어야합니다.

    결국 2와 5 중 적게 세어진 갯수가 정답이 됩니다.

 */

public class boj2004_Combination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        System.out.println(Math.min(towOrFive(N,M,5),towOrFive(N,M,2)));
    }
    public static int towOrFive(int n, int m, int t){
        int nm = n-m;

        int nCnt = 0;
        while(n>=t){ n/=t; nCnt+=n; }

        int mCnt = 0;
        while (m>=t){ m/=t; mCnt+=m; }

        int nmCnt = 0;
        while (nm>=t){ nm/=t; nmCnt+=nm; }

        return nCnt - mCnt - nmCnt;
    }
}
