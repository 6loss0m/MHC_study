package CodeChallenge1_2;
/*
    옛날에 풀이했던, 별찍기 문제와 비슷합니다.
    재귀식으로 돌며 모두 같은 숫자라면 카운트를 세고,
    다르다면, 4개로 쪼개는 행위를 반복합니다.

 */

public class QuadTree {
    static int zero=0;
    static int one =0;
    static int[][] arr2;

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        arr2 = new int[arr.length][arr.length];
        arr2=arr;
        quad(0,0,arr.length);
        int[] ret = new int[2];
        ret[0]=zero;
        ret[1]=one;
        System.out.println(ret[0]+","+ret[1]);
    }
    static void quad(int x, int y, int size){
        boolean all0=true;
        boolean all1=true;

        for(int i=x;i<x+size; i++){
            for(int j=y;j<y+size; j++){
                if(arr2[i][j]==0) all1 = false;
                if(arr2[i][j]==1) all0 = false;
            }
        }
        if(all0==true){ zero+=1; return;}
        if(all1==true){ one+=1; return;}

        quad(x,y,size/2);
        quad(x,y+size/2, size/2);
        quad(x+size/2, y, size/2);
        quad(x+size/2, y+size/2, size/2);
    }
}
