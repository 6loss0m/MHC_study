package Programmers.MonthlycodeChallenge.MCC2022_08_01;

public class Quadtree {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        int len = arr.length;
        quad(arr, 0,0,len);
        return answer;
    }
    public static void quad(int[][] arr, int x, int y, int n){
        int check = arr[x][y];
        out : for (int i = x; i < x+n; i++) {
            for (int j = y; j < y+n; j++) {
                if(check != arr[i][j]){
                    check = -1;
                    break out;
                }
            }
        }
        if(check== -1){
            n /= 2;
            quad(arr, x , y, n);
            quad(arr, x, y+n,n);
            quad(arr, x+n, y, n);
            quad(arr, x+n, y+n, n);
        }
        else if(check==1){
            answer[1] += 1;
        }
        else{
            answer[0] += 1;
        }
    }
    public static void main(String[] args) {
        Quadtree qt = new Quadtree();
        int[][] arr = new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        qt.solution(arr);
        System.out.println(answer[0] +" "+answer[1]);
    }
}
