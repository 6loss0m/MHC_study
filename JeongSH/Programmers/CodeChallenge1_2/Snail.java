package CodeChallenge1_2;

import java.util.ArrayList;
/*
    규칙을 찾아내는 문제
    동작은 크게 세개로 나누어서 볼 수있습니다.
    1. 아래로 내려가며 숫자가 1씩 증가 (n번)
    2. 오른쪽으로 가며 숫자가 1씩 증가 (n-1번)
    3. 대각선 위로 가며 숫자가 1씩 증가 (n-2번)

    총 세개의 동작을 계속해서 반복합니다.


 */

public class Snail {
    public static void main(String[] args) {
        int n=4;
        int[][] top =new int[n][n];
        int y=-1;
        int x=0;
        int val=1;

        for(int i=n; i>0; i-=3){
            for(int j=0;j<i; j++){ top[++y][x]=val++; }
            for(int j=0;j<i-1; j++){ top[y][++x]=val++; }
            for(int j=0;j<i-2; j++){ top[--y][--x]=val++; }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                list.add(top[i][j]);
            }
        }
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++){ret[i]=list.get(i);}
        System.out.println(list.toString());


    }
}
