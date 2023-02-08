package BOJ.PS_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    메모리 초과 해결을 못했습니다.

    아이디어
    1~10000 소수를 미리 구한 뒤,
    행복한 숫자인지 아닌지 판단하였습니다.
    행복한 숫자는 연산과정중 1 이 되는 숫자이고,
    아닌 숫자는 사이클이 생기게됩니다.

    문제점
    1. 시간초과
        - n 이 행복한 숫자인지 판단하는 과정.
        - 행복한 숫자가 아닌 숫자는 사이클이 생기게되기때문에 연산과정 중 다시 n이 된다면 행복한 숫자 x
        - 사이클 중 이전에 이미 행복한 숫자가 아님을 판단한 숫자가 있다면 중복계산이 일어나게되어 시간초과라 판단.
    1-1 해결
        - list 를 만들어 연산과정 중 나오는 숫자를 모두 추가.
        - 행복한 숫자가 아님이 판단되면 list 의 모든 숫자를 체크하여 다음에 중복계산을 방지

    2. 메모리 초과
        - 매번 새로운 리스트를 만들기 때문에 메모리 초과라고 생각하였지만, clear 로 재사용을 하더라도 메모리 초과라고 뜸

 */

public class boj10434_Happy {
    static int[] prime = new int[10001];
//    static ArrayList<Integer> cycle = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        setPrime();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String input = br.readLine();
            sb.append(input);
            String[] split = input.split(" ");
            int n = Integer.parseInt(split[1]);

            if(prime[n]==1){ sb.append(" NO\n"); }
            else{
                if(isHappy(n)){sb.append(" YES\n");}
                else{sb.append(" NO\n"); }
            }
        }
        System.out.println(sb);
    }

    static void setPrime(){
        prime[0]=1; prime[1]=1;
        for(int i=2; i<=Math.sqrt(10001);i++){
            for(int j=i; i*j<10001; j++){
                if(prime[i*j]==1){continue; }
                prime[i*j]=1;
            }
        }
    }

    static boolean isHappy(int n){
//        int origin = n;
        int[] isCycle = new int[500];
        while (true){
            if(n==1) return true;
            int sum = 0;
            while (n>0){
                sum+= (n%10)*(n%10);
                n/=10;
            }
            n=sum;
            System.out.println(n);
            if(isCycle[n]==1){ return false;}
            isCycle[n]=1;
//            cycle.add(n);
//            if(origin==sum){
//                for (int i = 0; i < cycle.size(); i++) { prime[cycle.get(i)]=1; }
//                cycle.clear();
//                return false;
//            }
        }
    }
}
