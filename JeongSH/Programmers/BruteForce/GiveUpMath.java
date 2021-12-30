
/*

    간단한 구현문제.

    시간복잡도 : O(n)

 */

import java.util.ArrayList;
import java.util.Arrays;

public class GiveUpMath {
    public static void main(String args[]){
        int[] s1 = solution(new int[] {1,2,3,4,5});
        int[] s2 = solution(new int[] {1,3,2,4,2});
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }
    public static int[] solution(int[] answers){
        int[] p1= {1, 2, 3, 4, 5};
        int[] p2= {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int h1,h2,h3 = h1 = h2= 0;
        int max=0;
        for(int i=0; i<answers.length; i++){                        //각 사람의 반복인덱스 만큼 % 연산을 하여 맞은 문제 갯수 구하기.
            if(answers[i]==p1[i%5]){h1++;max = Math.max(h1,max);}
            if(answers[i]==p2[i%8]){h2++;max = Math.max(h2,max);}
            if(answers[i]==p3[i%10]){h3++;max = Math.max(h3,max);}
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==h1){list.add(1);}                                   // 최대값과 같으면 list 오름차순으로 넣기 위해
        if(max==h2){list.add(2);}
        if(max==h3){list.add(3);}
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)                            // arr 로 변환
            answer[i]=list.get(i);
        return answer;
    }
}
