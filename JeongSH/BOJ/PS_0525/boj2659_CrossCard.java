package BOJ.PS_0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어
    1. 1111 ~ 9999 까지 순회하며 시계수를 만들어줍니다.
    2. 중복을 피하기위해 이미 찾은 시계수는 카운트 하지않습니다.
    3. 입력받은 수의 시계수와 같다면 카운트를 반환합니다.

 */

public class boj2659_CrossCard {
    static StringBuilder newStrNum = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10000];
        String[] input = br.readLine().split(" ");
        String strNum = "";
        for(int i=0;i<4;i++){
            strNum+=input[i];
        }
        int n = Integer.parseInt(strNum);
        n = getMinNewValue(n);

        int cnt = 0;
        for(int i=1111;i<=9999;i++){
            if(String.valueOf(i).contains("0")){ continue; }

            int tmp = getMinNewValue(i);

            if(arr[tmp]==0){ arr[tmp]=1; cnt++; }
            if(n == getMinNewValue(i)){
                System.out.println(cnt);
                return;
            }
        }
    }

    static int getNewValue(int n, int idx){
        String strNum = String.valueOf(n);
        newStrNum.setLength(0);
        for(int i=1; i<5; i++){
            newStrNum.append(strNum.charAt((idx+i)%4));
        }
        return Integer.parseInt(newStrNum.toString());
    }
    static int getMinNewValue(int n){
        int min = n;
        for(int i=0;i<3;i++){
            min = Math.min(min,getNewValue(n,i));
        }
        return min;
    }
}
