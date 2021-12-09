
/*

    문제 아이디어:
    거리의 최솟값을 임의로 정해서, 그걸 기준으로 바위를 지워봅니다.
    ex) 거리의 최소값 = 6
    0   2   11  14  17  21  25
    (시작)                  (도착)
    0->2  :거리의 최솟값인 6 보다 작으므로 바위를 지워줍니다. count = 1
    바위를 지웠으므로 다시 시작점에서 다음 바위를 비교합니다.
    0->11  : 6보다 크기때문에 바위를 남겨둡니다.
    11->14  : 6보다 작기때문에 바위를 지웁니다.  count = 2
    11->17  : 6과 같으므로 바위를 남겨둡니다.
    17->21  : 6보다 작기때문에 바위를 지웁니다. count = 3
    count 가 n 보다 크기때문에 생각보다 더 많은 바위를 지운것으로 볼 수 있습니다.
    이는 거리의 최솟값이 너무 큰 수이기 때문으로 볼 수 있습니다.
    임의로 정한 거리의 최소값을 기준으로 지운 바위의 갯수와 n을 비교하면서 조절해 나가면됩니다.

    거리의 최소값 중 최대값을 보장해야 하므로.
    mid 가 조건을 충족하더라도 left 를 늘려줍니다.
    left 가 더이상 조건을 충족하지않으면 마지막 mid 값이 정답이 됩니다.

    시간복잡도: O(logN)

 */



import java.util.Arrays;

public class SteppingStone {
    public static void main(String args[]){
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17};
        int n = 2;
        int answer=0;

        Arrays.sort(rocks);
        long left=1;
        long right=distance;
        long mid;
        while(left<=right){
            int prev = 0;
            int count = 0;
            mid=(left+right)/2;
            for(int i=0; i<rocks.length; i++){
                int diff = rocks[i]-prev;           // 이전 바위와 현재 바위를 비교하여 차이를 저장.
                if(mid>diff){count++;}              // mid(임의의 거리의 최소값) 가 diff 크다면 바위를 지워야합니다.
                else{prev=rocks[i];}                // 바위를 지우지 않았다면 이전 바위가 됩니다.
            }
            if(n<count){right=mid-1;}               // count 가 n보다 크다면 mid 가 너무 큰것이므로 right 값을 줄여줍니다.
            else {left=mid+1; answer=(int)mid;}     // count 가 n보다 작다면 mid 가 너무 작은것이므로 left 값을 늘려줍니다.
        }                                           // 답은 지운바위 갯수가 n개 일 때의 최대값이므로, 가장 마지막에 나온 mid 값이 정답이 됩니다.
        System.out.println(answer);
    }
}
