/*
    7                (n=0층)
    3 8              (n=1층)
    8 1 0            (n=2층)
    2 7 4 4           ...
    4 5 2 6 5          .

    n=1층의 삼각형으로 생각했을 때,
    각각의 삼각형 갈림길의 기댓값은
    7
    (7+3) (7+8) 가됩니다.

    n=2층의 삼각형으로 생각했을 때,
    7
    (7+3) (7+8)
    (7+3+8) (Max((7+3),(7+8))+1) (7+8) 가 됩니다.

    시간복잡도: T(n) = n^2 = O(n^2)

 */
public class Triangle {
    public static void main(String args[]) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                answer = Math.max(triangle[i][j], answer);
            }
        }
        System.out.println(answer);
       return;
    }
}
