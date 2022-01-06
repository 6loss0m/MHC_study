import java.util.HashMap;
/**
 *    간단한 구현 문제.
 *    아이디어
 *       HashMap 을 사용하여 각 번호의 xy 값을 <번호,{x값,y값}> 쌍으로 저장해 두었습니다.
 *       가운데 줄을 칠 땐, 현재 xy 값과 map 에서 가져온 xy 값을 비교하여 정하게 하였습니다.
 *
 */

public class KeyPad {
    static boolean isRight;
    static HashMap<Integer,Integer[]> map;
    static String answer;
    public static void main(String args[]){
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right" )); // LRLLLRLLRRL
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left")); // LRLLRRLLLRR
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},"right")); // LLRLLRLLRL
    }
    public static String solution(int[] numbers, String hand){
        answer="";
        isRight=false;
        if(hand.equals("right")){isRight=true;}
        map = new HashMap<>();
        int n=1;
        map.put(0,new Integer[]{1,3});
        for(int i=0;i<3; i++){                      // map 초기화
            for(int j=0; j<3; j++){
                map.put(n++,new Integer[]{j,i});
            }
        }
        Hand right = new Hand(2,3);         // 오른손 초기위치.
        Hand left = new Hand(0,3);          // 왼손 초기위치.

        for(int i=0; i<numbers.length; i++){
            Integer[] xy = map.get(numbers[i]);     // 번호의 xy 값을 조회
            if(numbers[i]==1 | numbers[i]==4 | numbers[i]==7 ){ putOn(left,xy,"L");}            // 왼쪽 줄
            else if(numbers[i]==3 | numbers[i]==6 | numbers[i]==9){ putOn(right,xy,"R");}       // 오른쪽 줄
            else {                                                                                 // 가운데 줄
                Integer rDiff = Math.abs(xy[0]-right.x) + Math.abs(xy[1]-right.y);
                Integer lDiff = Math.abs(xy[0]-left.x) + Math.abs(xy[1]-left.y);
                if(lDiff > rDiff){putOn(right,xy,"R");} // 오른손으로 쳐야 됨.
                else if(lDiff < rDiff){putOn(left,xy,"L");} // 왼손으로 쳐야 됨.
                else{
                    if(isRight){putOn(right,xy,"R");} // 오른손으로 쳐야 됨.
                    else{putOn(left,xy,"L");} // 왼손으로 쳐야 됨.
                }
            }
        }
        return answer;
    }
    public static class Hand {
        int x;
        int y;
        public Hand(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void putOn(Hand hand,Integer[] xy, String lr){
        hand.x=xy[0];
        hand.y=xy[1];
        answer += lr;
    }
}
