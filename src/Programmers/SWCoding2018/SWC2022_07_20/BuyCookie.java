package Programmers.SWCoding2018.SWC2022_07_20;

public class BuyCookie {
    public int solution(int[] cookie) {
        int answer = 0;

        for (int i = 0; i < cookie.length - 1; i++) {
            int left = i;
            int leftSum = cookie[i];

            int right = i + 1;
            int rightSum = cookie[i + 1];

            while (true) {
                if (leftSum == rightSum && answer < leftSum) {
                    // 두 형제의 쿠키의 합이 같으며, 쿠키의 합이 기존 answer에 저장했던 값보다 큰 경우
                    answer = leftSum; // answer에 새로 저장
                } else if (leftSum <= rightSum && left != 0) { // 오른쪽이 더 많은 경우, 왼쪽을 늘려야함
                    leftSum += cookie[--left];
                } else if (leftSum > rightSum && right != cookie.length - 1) { // 왼쪽이 더 많은 경우, 오른쪽을 늘려야함
                    rightSum +=  cookie[++right];
                } else { // 더 이상 조절할 수 없을 때
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}