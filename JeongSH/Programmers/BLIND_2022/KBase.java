package BLIND_2022;

/*
    문제의 조건을 보면
    우리가 임의로 숫자의 문자열을 잘라서 소수를 만들 수 없습니다.
    ex) 2110.. -> 211(O)
               -> 11 (X)
    그러므로 이미 주어진 0으로 문자열을 잘라 나온 숫자가 소수인지 판단하면 됩니다.
    211020101011
    211 / 2 / 1 / 1 / 11
    이므로 답은 3이 됩니다.

 */

public class KBase {

    public static void main(String[] args) {
        int n=437674;
        int k=3;

        String[] input = Integer.toString(n,k).split("0");

        int cnt=0;
        for(int i=0;i<input.length; i++){
            if(input[i].equals("")){continue;}
            long num = Long.parseLong(input[i]);
            if(isPrime(num)) {cnt++;}
        }

        System.out.println(cnt);

    }
    static boolean isPrime(long n){
        if(n<2){return false;}
        for(long i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){ return false;}
        }
        return true;
    }
}
