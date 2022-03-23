package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제접근
    레이저를 제외한 괄호는 스택의 성질을 가지고있습니다.
    - 가장 먼저 들어온 괄호'(' 은 가장 나중에 들어오는 ')' 와 짝을 이룹니다.
    - 레이저로 막대를 자를 경우 여태 겹쳐진 막대의 갯수만큼 잘린 막대들이 생겨납니다.
    - ')' 는 막대의 끝 지점으로 자르지 않아도 막대의 갯수가 1개 늘어납니다.


    그러므로 (이하 레이저는 @ 로 표시)
    1. '(' 들어오면 stack 크기 +1 .
    2. @가 들어오면 stack 의 크기만큼 ret 값 증가.
    3. ')' 들어오면 ret 값은 +1, stack 사이즈는 -1
    스택처럼 작동한다는 것이지 굳이 스택으로 값을 반환하지 않기 때문에, 이 원리대로 size 만 이용.

 */

public class boj10799_IronRod {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().replaceAll("\\(\\)","@").toCharArray();
        int len = input.length;
        int size=0;     // 굳이 스택을 만들필요는 없기때문에
        int ret =0;

        for(int i=0; i<len; i++){
            if(input[i]=='@'){ ret+=size; }
            else if(input[i]=='('){ size+=1; }
            else if(input[i]==')'){ ret+=1; size-=1; }
        }
        System.out.println(ret);
    }
}
