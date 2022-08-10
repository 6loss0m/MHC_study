package CodeChallenge2;
/*
    미리 약수의 갯수를 모두 구한뒤에
    left ~ right 사이의 약수의 갯수가 홀수인지 짝수인지 판단하면 더하고 뺍니다.
 */
public class Divisor {
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        int[] arr = new int[1001];
        for(int i=1;i<1001;i++){
            for(int j=1; j*i<1001;j++){ arr[i*j]+=1; }
        }
        int ret=0;
        for(int i=left; i<=right; i++){
            if((arr[i]&1)==0) ret+=i; // 짝수
            else ret-=i;    // 홀수
        }

        System.out.println(ret);
    }
}
