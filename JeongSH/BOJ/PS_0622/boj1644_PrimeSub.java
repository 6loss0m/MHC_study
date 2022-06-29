package BOJ.PS_0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    N 까지의 모든 소수를 에라토스테네스의 체를 통해 모두 구하여
    배열로 만들고
    부분 연속수열의 합은 투포인터로 풀이했습니다.


 */

public class boj1644_PrimeSub {
    static boolean[] notPrime = new boolean[4000001];
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        setIsPrime(N);

        int s=0, e=0, sum=0, cnt=0;
        int size=primes.size();
        while(true){
            if(sum<N){
                if(e==size){break;}     // e 가 마지막 인덱스를 가리키면 더이상 연속부분수열로는 N을 만들 수 없습니다.
                sum+=primes.get(e++);
            }
            else{ sum-= primes.get(s++); }
            if(sum==N){ cnt+=1; }
        }
        System.out.println(cnt);

    }
    static void setIsPrime(int N){
        notPrime[0]=true;
        notPrime[1]=true;
        for(int i=2; i<N/2+1; i++){
            for(int j=2; i*j<N+1; j++){
                if(notPrime[i*j]==true) continue;
                notPrime[i*j]=true;
            }
        }
        int idx=0;
        while(idx<=N){
            if(!notPrime[idx]){primes.add(idx);}
            idx++;
        }
    }
}
