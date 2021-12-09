
import java.util.Arrays;

/*
    문제 아이디어:
    0. 먼저 나가는 순서데로 정렬합니다. (기준점: '나가는' 지점)
        0-1. 나가는 기준으로 정렬 하면, (n+1의 시작점) < (n의 나가는 지점) 의 경우
             n의 나가는 지점에 카메라를 설치하면 카메라를 하나만 설치해도 되기때문입니다.
    1. 가장 먼저 나가는 위치에 카메라를 설치합니다.
    2. 카메라가 커버할 수 있는 범위( 마지막 카메라위치 > 다른 차량 시작점) 안에있는 길에는 카메라 설치 X
        2-1 카메라가 커버할 수 없는 범위 ( 마지막 카메라 위치 < 다른 차량 시작 점) 일 경우 카메라 설치.

    시간복잡도: O(n)

 */

public class CCTV {
    public static void main(String args[]){
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int answer=0;
        Arrays.sort(routes,(int[] o1, int[] o2)-> o1[1]-o2[1]);             // 먼저나가는 차량 순서로 정렬
        int last = Integer.MIN_VALUE;

        for(int[] r : routes){
            if(last < r[0]){                                                // (마지막 카메라 위치) < (다른 차량 시작지점)
                last = r[1];                                                // 이 경우는 카메라를 추가로 설치해야합니다. (다른 차량의 나가는 지점)
                answer++;
            }
        }
        System.out.println(answer);
    }
}
