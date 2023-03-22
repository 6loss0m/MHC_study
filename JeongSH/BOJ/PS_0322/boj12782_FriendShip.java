package BOJ.PS_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어

    연산
    1. 1,0 자리를 교환
    2. 1을 0으로 0을 1로 바꿈

    1번 연산이 연산을 줄일 수 있는 최고의 방법입니다.

    이미 각 자리의 대응하는 숫자가 같다면 생각 할 필요가 없으므로
    서로 대응하는 숫자가 같지 않은 자리만 파악합니다.
    서로 대응하는 숫자가 같지않은 숫자를 바꾸는 것이 최고의 방법입니다.
    대응하는 숫자가 같지않은 숫자 중 1의 갯수를 파악합니다.

    ex)
    0 0 1 1 0 1 0 0      1
    1 0 0 1 0 1 1 1      3
    x o x o o o x x

    0번째와 2번째 숫자를 바꾸면
                                cnt : 1
    1 0 0 1 0 1 0 0     0
    1 0 0 1 0 1 1 1     2
    o o o o o o x x

    7,8 은 서로 교환할 숫자가 없으므로 0을 1로 바꿔줍니다. ( cnt+=2 )
    즉, 처음에 구한 대응하는 숫자가 같지 않은 경우의 1의 갯수 중 큰 값이 결과값이 됩니다. ( cnt : 3 )

 */

public class boj12782_FriendShip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int len = input[0].length();
            int[] num1 = new int[len];
            int[] num2 = new int[len];
            for(int i=0;i<len;i++){
                num1[i]=input[0].charAt(i)-'0';
                num2[i]=input[1].charAt(i)-'0';
            }
            int difOneCnt1=0;
            int difOneCnt2=0;
            for(int i=0;i<len;i++){
                if(num1[i]!=num2[i]){
                    if(num1[i]==1){difOneCnt1++;}
                    else{ difOneCnt2++; }
                }
            }
            System.out.println(Math.max(difOneCnt1,difOneCnt2));
        }
    }
}
