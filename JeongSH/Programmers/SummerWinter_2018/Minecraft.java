package SummerWinter_2018;
/*
    이분탐색을 약간 응용하여 풀이하였습니다.

    이분탐색의 mid 값은 기준높이입니다.
    start = 최소높이
    end = 최대높이
    mid = (start+end)/2

    블럭들의 mid 높이를 구한 뒤, 비용을 계산합니다.
    블럭들의 mid+1 높이를 구한 뒤, 비용을 계산합니다.

    (mid)Cost < (mid+1)Cost 경우,
    최소값이 있을 수 있는 범위는
    start ~ mid 입니다.

    (mid)Cost > (mid+1)Cost 경우,
    최소값이 있을 수 있는 범위는
    mid+1 ~ end  입니다.

 */

public class Minecraft {
    static int[][] lands = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}};
    static int P = 3;   // 건설
    static int Q = 5;   // 제거
    static int len;

    public static void main(String[] args) {
        len = lands.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int l = lands[i][j];
                if (max < l) { max = l; }
                if (min > l) { min = l; }
            }
        }

        long start = min;
        long end = max;
        long mid = start + end / 2;
        long minCost = getCost(mid);

        while (start <= end) {
//            long startCost = getCost(start);      // 처음엔 statCost, endCost 가 필요할거라 생각했지만, 필요 X
//            long endCost = getCost(end);
            mid = (start + end) / 2;
            long midCost = getCost(mid);
            long midRightCost = getCost(mid+1);

            long tmp = Math.min(midCost, midRightCost);
            if(minCost>tmp){ minCost=tmp; }

            if(midCost < midRightCost){ end=mid-1; }
            else { start = mid+1; }

        }
        System.out.println(minCost);

    }

    static long getCost(long level) {
        long cost = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int l = lands[i][j];
                if (l > level) { cost = cost + (l - level) * Q; }
                else if (l < level) { cost = cost + (level - l) * P; }
            }
        }
        return cost;
    }
}
