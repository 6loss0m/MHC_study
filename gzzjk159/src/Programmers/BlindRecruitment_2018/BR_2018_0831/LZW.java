package Programmers.BlindRecruitment_2018.BR_2018_0831;
import java.util.*;
public class LZW {
    public int[] solution(String msg){
        ArrayList<Integer> array = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        //처음 map에 A~Z까지 초기화 시킴
        char ch = 'A';
        for(int i = 1; i<27;i++){
            map.put(ch +"",i);
            ch +=1;
        }
        int startin = 27;

        // 문자열의 끝인지를 확인하기 위한 boolean이다.
        boolean flag = false;
        for(int i = 0; i<msg.length();i++){
            String word = msg.charAt(i)+"";

            while(map.containsKey(word)){
                i++;
                if(i == msg.length()){
                    flag = true;
                    break;
                }
                word += msg.charAt(i);
            }
            if(flag){
                array.add(map.get(word));
                break;
            }
            //현재 word에는 지금 사전에 넣을 단어이므로 뒤에서 문자 하나를 제거해야 사전에 있는 단어이다.
            array.add(map.get(word.substring(0,word.length()-1)));
            //사전에는 현재 순서보다 +1된 값을 더한다.
            map.put(word,startin++);
            // 현재 i는 단어를 만들면서 다음문자를 가리키고 있기 때문에 -1을 해줘야 한다.
            i--;
        }

        int[] answer = new int[array.size()];
        for(int i = 0; i<array.size();i++){
            answer[i] = array.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
