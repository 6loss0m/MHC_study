package BOJ.PS_0517;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    구간합을 사용하여 풀이하였습니다.
    먼저 가로 줄의 구간합을 구하고
    구한 가로 줄의 구간합을 사용하여 직사각형의 구간합을 구할 수 있습니다.


    1. 각 행의 구간 합을 구해줍니다. sum1[][]
    2. 위에서 구한 sum1[][] 를 사용하여 열의 구간합을 구해줍니다.
    3. 2를 통해 얻은 배열은 (0,0) ~ (x,y) 의 합이됩니다.
    4. 큰 직사각형 - (0,0)~(0,y) - (0,0)~(x,0) + 작은 직사각형  이 답이됩니다.

    다른 사람 풀이를 보니 각각 구간합을 따로 구하지않고 입력과 같이 받기도 하는데
    O(N^2) 의 복잡도는 같아 통과가 된거같습니다.

 */

public class boj11660_Sum5 {
    static int[][] rowSum = new int[1025][1025];
    static int[][] columnSum = new int[1025][1025];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int[][] arr = new int[1025][1025];
        String[] inputs=br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        for (int i = 1; i <= N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                arr[i][j]=Integer.parseInt(inputs[j-1]);
                columnSum[i][j] = columnSum[i][j-1]+arr[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                rowSum[j][i]=rowSum[j-1][i]+columnSum[j][i];
            }
        }

        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int x1 = Integer.parseInt(inputs[0]);
            int y1 = Integer.parseInt(inputs[1]);
            int x2 = Integer.parseInt(inputs[2]);
            int y2 = Integer.parseInt(inputs[3]);
            sb.append(getSum(y1, x1, y2, x2)).append("\n");
        }
        System.out.println(sb);

    }

    static int getSum(int startX, int startY, int endX, int endY){
        return rowSum[endY][endX] - rowSum[startY-1][endX] - rowSum[endY][startX-1] + rowSum[startY-1][startX-1];
    }
}
