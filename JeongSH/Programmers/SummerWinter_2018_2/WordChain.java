package SummerWinter_2018_2;

import java.util.HashSet;
/*
    기본적으로 끝말잇기이기 떄문에 각 끝문자와 다음 문자열의 시작문자가 같은지 확인합니다.
    1. set 을 사용하여 중복을 검사하고,
    2. % 연산과 / 연산을 사용하여 몇번째 사람, 몇번째 차례 인지 계산합니다.

 */

public class WordChain {
    public static void main(String[] args) {
        String[] words={"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int n=3;    // [3,3]
//        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
//        int n=5;    // [0,0]
//        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
//        int n=2;    // [1,3]

        int len = words.length;
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        int[] result = new int[2];      // {사람번호,몇번째차례}
        for(int i=1;i<len; i++){
            if(set.contains(words[i]) || (words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0))){
                result[0]=(i%n)+1;
                result[1]=(i/n)+1;
                break;
            }
            else{ set.add(words[i]); }
        }
        System.out.println(result[0]+", "+result[1]);
    }
}
