package CodeChallenge1_2;
/*
    스타수열길이의 최대값은,
    교집합으로 정한 원소의 총 갯수(*2) 보다 작거나 같습니다.

    즉, 임의의 원소를 교집합으로 구한 스타수열의 길이가 6일 경우.
    원소의 등장 횟수가 3이하(3*2=6) 의 원소는 계산할 필요가 없습니다.

    조건1. 교집합으로 정한 원소가 포함되어있어야함.
    조건2. x[0]!=x[1] , x[2]!=x[3]

 */

public class StarSequence {
    public static void main(String[] args) {
        int[] a = {5,2,3,3,5,3};
        int ret=0;
        int[] count = new int[a.length];    // 각 숫자가 몇번 나오는지
        int len = count.length;
        for(int i=0;i<len;i++) { count[a[i]]+=1; }

        for(int i=0;i<len; i++){    // 교집합 원소로 선택할 값
            if(count[i]==0) continue;   // 0개면 교집합 원소가 안되므로
            if(count[i]<= ret ) continue; // 여태 가장 많이 사용된 횟수보다 적으면 x
            int tmp =0;
            for(int j=0;j<len-1; j++){
                if(a[j]!=i && a[j+1]!=i) continue;  // 인접한 두 원소중 교집합 원소가 하나는 있어야 함. 조건1
                if(a[j]==a[j+1]) continue;          // 조건2
                tmp+=1; j+=1;
            }
            ret = Math.max(ret,tmp);
        }
        System.out.println(ret*2);
    }
}
