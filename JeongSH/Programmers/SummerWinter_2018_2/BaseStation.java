package SummerWinter_2018_2;
/*

    각 기지국 범위를 기준으로 모든 구간을 나누어서 생각합니다.
    1~2 | 기지국 | 6~9 | 기지국 |
    (2)           (4)
    모든 구간을 나누고나면
    각 구간의 길이로 몇개의 기지국을 설치해야하는지 계산할 수 있습니다.

 */

public class BaseStation {
    static int N;
    static int W;

    public static void main(String[] args) {
        int[] stations = {4, 11};
        int n = 11;
        int w = 1;

        N=n;
        W=w;
        int len = stations.length;
        int count=0;
        int left,right;

        left = cal(1,stations[0]-w-1);  // 첫기지국의 왼쪽 구간
        count += left;

        if(len == 1){
            right= cal(stations[0]+w+1,N);  // 기지국이 하나라면, 오른쪽 구간도 구해서 리턴
            System.out.println(left+right);
            return;
        }

        for (int i = 1; i < len; i++) { // 각 구간은,  (이전 기지국의 마지막범위+1) ~ (현재 기지국의 시작범위-1)
            left=cal(stations[i-1]+w+1,stations[i]-w-1);
            count+=left;
        }

        if(stations[len-1]+w+1<N){  // 마지막 구간이 N 보다 작으면 마지막구간의 오른쪽도 구해야함
            right=cal(stations[len-1]+w+1,N);
            count+=right;
        }

        System.out.println(count);
    }

    static int cal(int start, int end){
        int length = end-start; // 구간 길이는 end-start+1 이지만 밑의 count를 계산하기 편하게 하기위해
        if(length<0) return 0;  // 설치하지않아도 됨
        if(length==0) return 1; // 0은 나누기가 안되서
        int count = length/(2*W+1)+1;   // 1~3 까지의 구간은 1개를 설치해야하는데 , w=1 기준
        return count;                   // (1~2)/3 = 0 , 3/3=1 이므로 위의 length 에서 +1을 하지않음
    }
}
