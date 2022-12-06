package BOJ.PS_1123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    123~999 사이의 숫자이므로 완전탐색을 하여도 문제가 없다고 생각합니다.
    입력값을 보고 123~999(K번) 를 순회한다고 가정하면
    O(N*K) 가 됩니다.

    아이디어
    입력값을 입력숫자,s,b 라고 본다면
    123~999 까지 숫자를 순회하며 입력숫자와 비교합니다.

    순회하는 123~999 를 정답후보라고 치면
    정답후보와 입력숫자의 결과 s,b 와 "일치하지않으면" 체크합니다.
    그러면 남은 체크하지않은 숫자들이 곧 정답 후보가 됩니다.

    예외처리
    1. 숫자야구에서 0을 사용하지 않으므로, 정답후보 각 자리에 0이 들어가있다면 무조건 일치하지 않는다고 체크합니다.
        ex) 102 는 정답후보가 될 수 없습니다
    2. 숫자야구에서 중복된 숫자는 답일 수 없으므로 중복된 숫자가 정답후보로 들어오면 일치하지않는다고 체크합니다.
        ex) 133 는 정답후보가 될 수 없습니다

 */

public class BullsAndCows {
    static boolean[] isNotRight = new boolean[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<K; i++){
            String[] input = br.readLine().split(" ");
            String now = input[0];
            int s = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            for(int j=123; j<1000;j++){
                if(isNotRight[j]){ continue; }  // 이미 정답후보가 아닌 후보는 볼 필요 없으므로
                String strJ = String.valueOf(j);
                if(!isRight(strJ,now,s,b)){     // 정답후보와 입력값이 일치하지않으면
                    isNotRight[j]=true;         // 정답후보가 아니라고 체크합니다.
                }
            }
        }
        int cnt = 0;
        for(int i=123; i<1000;i++){
            if(!isNotRight[i]){ cnt++; }
        }
        System.out.println(cnt);

    }

    static boolean isRight(String origin, String test, int s,int b){    // 정답후보와 입력값이 일치하는지
        int testS=0;
        int testB=0;

        if(origin.indexOf('0')!=-1){return false;}      // 정답후보는 0이 들어갈수 없으므로
        if(origin.charAt(0)==origin.charAt(1) ||        // 정답후보는 중복된 숫자가 있으면 안되므로
                origin.charAt(0)==origin.charAt(2) ||
                origin.charAt(1)==origin.charAt(2)
        ){ return false; }

        for(int i=0;i<3;i++){
            if( origin.charAt(i)==test.charAt(i) ){ testS++; }
            else{
                if(origin.indexOf(test.charAt(i))!=-1){ testB++; }
            }
        }
        return testS==s && testB==b;
    }
}
