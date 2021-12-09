
/*

    이진탐색으로 풀어보았습니다.
    탐색에 앞서, 좁은 탐색 범위를 지정하는것이 반복문을 최소로 돌리기때문에
    탐색의 최소 범위를 지정해 줍니다.

    심사관이 각각 걸리는 시간을 오름차순으로 정렬한 뒤,

    탐색의 left 를 지정하는 방법은
    times[0]*n/times.length 입니다.

    탐색의 right 를 지정하는 방법은
    times[times.length-1]*n/times.length 입니다.

    여기서 mid = (left + right)/2 입니다.
    한 가지 주의 할 점은 mid 라는 시간동안 n명이 심사를 받는다고 하더라도
    문제가 원하는 답을 충족하지않을 수 있습니다.
    왜냐하면, n명이 심사하는 최소시간을 보장하지 않기 때문입니다.
    문제를 그대로 가져올경우
    28분 뿐만 아니라 29분도 6명이 심사를 받기때문입니다.

    최소 시간을 보장하기위해 n과 심사받은 인원이 같더라도 right 의 값을 줄여나갑니다.
    계속 줄여나가다가 더이상 충족하지않은 mid 값이 나오면 바로 그 전의 mid 값이 최소시간이 됩니다.

    시간복잡도: O(logN)

 */
import java.util.Arrays;

public class Immigration {
    public static void main(String args[]){
        int n=6;
        int[] times = {7,10};
        long answer=0;

        Arrays.sort(times);
        long left = (long)times[0]*(long)n/times.length;                  // 가장 적은 시간은 7*6/2 = 21
        long right =(long)times[times.length-1]*(long)n/times.length;     // 가장 오래걸리는 시간은 10*6/2 = 30
        long mid=0;
        answer = right;
        while(left<=right){
            mid = (left + right)/2;
            long sum =0;
            for(int i=0; i<times.length; i++){
                sum += mid/times[i];                                // 몇명이 심사를 받는지 확인하기 위한 sum
            }
            if(n>sum){left=mid+1;}                                  // mid 값이 너무 작은 경우
            else{right=mid-1; answer=mid;}                          // mid 값이 너무 큰 경우
        }
        System.out.println(answer);
    }
}
