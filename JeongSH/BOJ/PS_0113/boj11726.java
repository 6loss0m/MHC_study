package BOJ.PS_0113;

/**
 *  문제 아디이어
 *      값의 규칙성을 찾고자 하나하나 계산을 해보면
 *  n=1 -> 1
 *  n=2 -> 2
 *  n=3 -> 3
 *  n=4 -> 5
 *  n=5 -> 8
 *  까지 구하고 피보나치 수열을 의심하여 n=9 -> 55 임을 문제에서 확인하여 피보나치 수열로 문제를 풀었습니다.
 *
 *  팁:
 *      나머지 연산 % 의 특징
 *      (A+B) % p = (A%p + B%p)%p = C%p
 *
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11726 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pib =new int[1001];
        pib[1]=1;
        pib[2]=2;
        for(int i =3; i<n+1; i++){
            pib[i]=(pib[i-1]+pib[i-2])%10007;
        }
        System.out.println(pib[n]);
    }
}
