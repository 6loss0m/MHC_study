package CodeChallenge2;
/*
    짝수는 +1 하여 반환하면되지만,
    홀수일 경우에 하나하나 구해주면 시간초과가 납니다.

    규칙을 찾기위해
    0111 -> 1011    7->11
    1001 -> 1010    9->10
    1011 -> 1101    11->13
    01111 -> 10111  15->23
    ..
    .

    오른쪽부터 탐색하여 가장 먼저나오는 0과 그 전의 1 의 자리를 바꾸면 문제의 조건을 충족합니다.

 */

public class Bit {
    public static void main(String[] args) {
        long[] numbers = {2,7};
        int len = numbers.length;
        long[] result = new long[len];
        for(int i=0;i<len;i++){
            if((numbers[i]&1)==0){result[i]=numbers[i]+1; }
            else{
                long bit = 1;
                while ((numbers[i]&bit) != 0){ bit*=2; }    // 가장 오른쪽의 0 찾기.
                bit/=2;
                result[i]=numbers[i]+bit;       // 0111 + 0100 = 1011 이므로 결과적으로 0111 -> 1011
            }
        }
        for(long n : result) {System.out.println(n);}
    }
}
