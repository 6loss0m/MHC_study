
/*
    DFS 풀이는 효율성이 떨어져 DP 로 접근해보았습니다.

    규칙 : [A1,A2 ~ An]의 숫자가 있을경우
        최대값은 [A1] (+/-) [A2~An 의 연산]
               [A1~A2] (+/-) [A3~An 의 연산]
               ...
               [A1~Ak] (+/-) [Ak+1 ~ An 의 연산]
        들의 최대값을 비교하는 것입니다.

    이 문제의 특징은 +연산과 -연산의 최대값을 구하는 방식이 다른 것입니다.
    1. + : 최대값 + 최대값 -> 최대값
    2. - : 최대값 - 최소값 -> 최대값
    여기서 최소값도 계산에 필요함을 알았습니다.

    + : 최대값 + 최대값 -> 최대값
        최소값 + 최소값 -> 최소값

    - : 최대값 - 최소값 -> 최대값
        최소값 - 최대값 -> 최소값

   {"1", "-", "3", "+", "5", "-", "8"} 문제로 예를 들면
   -> 보기 쉽게 숫자만 따로 뽑아보았습니다.
   {1,3,5,8}
   maxDp[시작인덱스][끝인덱스] : 시작인덱스부터 끝인덱스까지 연산의 최대값

   maxDp[n][n]=arr[n]
   min        =arr[n] 입니다.

   dp 배열
   [1][][][]
   [][3][][]
   [][][5][]
   [][][][8]

   topdown 방식으로 보면,

   maxDp[0][3] -> 우리가 구하고자하는 답
   (maxDp[0][0] - minDp[1][3]) vs (maxDp[0][1]+maxDp[2][3]) vs (maxDp[0][2]-minDp[3][3]) 값을 비교해야합니다.

   minDp[1][3] ->
   (minDp[1][1]+minDp[2][3]) vs (minDp[1][2]-maxDp[3][3]) 값을 비교해야합니다.

   min[2][3] ->
   (minDp[2][2] - maxDp[3][3])

   이것을 뒤집어서 배열을 채워나가면 됩니다.
   [0][1][2][3]
   [ ][0][1][2]
   [ ][ ][0][1]
   [ ][ ][ ][0]
   순서로 배열이 채워지게 됩니다.

 */




import java.util.Arrays;

public class Operation2 {
    public static void main(String args[]){
        System.out.println(solution(new String[] {"1", "-", "3", "+", "5", "-", "8"}));
        System.out.println(solution(new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"}));

    }
    public static int solution(String arr[]){
        int opCnt = (arr.length/2)+1;
        int[][] maxDp = new int[opCnt][opCnt];
        int[][] minDp = new int[opCnt][opCnt];

        for(int i=0; i<opCnt ; i++){
            Arrays.fill(maxDp[i],Integer.MIN_VALUE);
            Arrays.fill(minDp[i],Integer.MAX_VALUE);
            maxDp[i][i]=Integer.parseInt(arr[i*2]);
            minDp[i][i]=Integer.parseInt(arr[i*2]);
        }
        for(int cnt=1 ; cnt < opCnt; cnt++) {
            for (int i = 0; i < opCnt - cnt; i++) {
                int j = i + cnt;
                for (int k = i; k < j; k++) {
                    if (arr[k * 2 + 1].equals("+")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);
                    } else {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k + 1][j]);
                    }

                }

            }
        }
        return maxDp[0][opCnt-1];
    }

}
