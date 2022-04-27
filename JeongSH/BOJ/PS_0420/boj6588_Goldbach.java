package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    에라토스테네스의 체를 사용하여 풀이합니다.
    반복문은 홀수인 소수를 돌아야 하기때문에 idx +=1 이 아닌 idx+=2 로 하는게 빠릅니다.

    중요..
    조건문을 작성할때, idx 도 소수인지 확인해야합니다.


 */

public class boj6588_Goldbach {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] prime = new int[1000001];

        for(int i=2; i<1001; i++){
            for(int j=2; j*i<1000001; j++){
                if(prime[i*j] == 1) {continue;}
                prime[i*j]=1;
            }
        }

        int N;
        while ((N=Integer.parseInt(br.readLine()))!=0){
            int idx=3;
            while(idx<N){
                if(prime[idx]==0 && prime[N-idx]==0){sb.append(N).append(" = ").append(idx).append(" + ").append(N-idx).append("\n"); break;}
                idx+=2;
            }
        }
        System.out.print(sb);
    }
}
