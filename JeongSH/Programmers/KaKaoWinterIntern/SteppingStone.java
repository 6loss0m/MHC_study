package KaKaoWinterIntern;
/*

    이분탐색으로 풀이해보았습니다.
    탐색범위는 0 부터 ~ 배열의 가장 큰 값 까지 입니다.
    이분탐색의 속도를 올리는 방법은 탐색범위를 좁히는것과 정렬되어있는 데이터일 경우 mid 값이 충족하지않다면 바로 빠져나와야합니다.
    점프를 할 수 있는 최대값이 k 일 때, 지나칠 수 있는 돌의 갯수는 k-1 입니다.
    (k=3)
    4 0 0 3 4    두 개의 돌을 지나침 -> 성립
      1 2

    4 0 0 0 3    세 개의 돌을 지나침 -> 성립 x
      1 2 3

 */
public class SteppingStone {
    public static void main(String args[]){
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
    public static int solution(int[] stones, int k) {
        int mid = 0;            // 지나가는 니니즈 친구들의 숫자.
        int high = 0;
        int low = 0;
        for (int s : stones)
            high = Math.max(high, s);

        while (low <= high) {
            mid = (low + high) / 2;
            int jump = 0;
            boolean isJump = true;
            for (int s : stones) {
            if (s - mid < 0) {          // 돌-mid 가 음수면 니니즈는 점프를 해야합니다.
                    jump++;
                    if (jump >= k) { isJump = false; break; }
                }
                else { jump = 0; }
            }
            if (isJump == true) { low = mid + 1; }
            else { high=mid-1; }
        }
        return low-1;
    }
}
