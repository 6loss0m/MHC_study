package SummerWinter_2018_2;
/*
    전형적인 dp 문제입니다.
    크게 두 부분으로 나누어 생각하였습니다.
    1.  맨 첫 스티커를 선택하면 , 마지막 스티커를 선택 할 수 없습니다.
    2.  맨 첫 스티커를 선택하지 않는다면, 마지막 스티커를 선택 할 수 있습니다.

    점화식
    dp[i] =MAX( dp[i-1], MAX(dp[i-2], dp[i-3]) +sticker[i] )

    1. dp[i-1] : 현재 스티커를 떼지않고 이전까지의 값을 봅니다.
    2. MAX(dp[i-2],dp[i-3])+sticker[i] : 현재 스티커를 뗄 때, 두 가지 경우가 있습니다.
                                         - 전전 스티커와 현재 스티커를 제거
                                         - 전전전 스티커와 현재 스티커를 제거
    ex) [1, 100, 1, 3, 100] / 100 두 개를 선택하는 경우



 */

public class Sticker {
    public static void main(String[] args) {
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        int N = sticker.length;

        if(N==1){System.out.println(sticker[0]);return;}
        if(N==2){System.out.println(Math.max(sticker[0],sticker[1])); return;}
        if(N==3){System.out.println(Math.max(sticker[0],Math.max(sticker[1],sticker[2]))); return;}


        int[] dp0 = new int[N];   // 0 ~ N-1 까지의 숫자로
        int[] dp1 = new int[N];   // 1 ~ N 까지의 숫자로

        dp0[0]=sticker[0];
        dp0[1]=sticker[1];
        dp0[2]=Math.max(sticker[0]+sticker[2], dp0[1]);

        for (int i=3;i<N-1;i++){
            dp0[i]=Math.max(dp0[i-1],Math.max(dp0[i-2],dp0[i-3])+sticker[i]);
        }

        dp1[0]=0;
        dp1[1]=sticker[1];
        dp1[2]=Math.max(sticker[1],sticker[2]);

        for(int i=3; i<N;i++){
            dp1[i]=Math.max(dp1[i-1],Math.max(dp1[i-2],dp1[i-3])+sticker[i]);
        }
        System.out.println(Math.max(dp0[N-2],dp1[N-1]));
    }

}
