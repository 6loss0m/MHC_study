package BLIND_2018_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
    문제이해가 어려웠던 문제..
    1. 입력값을 본다.(앞에서 부터)
    2. 사전에 존재하는 가장 긴 입력값을 list 에 담는다.
    3. list 에 담은 입력값을 삭제한다.(앞에서 부터)

 */

public class Compression {
    public static void main(String[] args) {
        String msg="ABABABABABABABAB";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<26; i++){
            char c = (char) ('A'+i);
            map.put(String.valueOf(c),i+1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder(msg);
        StringBuilder now = new StringBuilder();
        int idx = 0;
        while (true){
            now.append(sb.charAt(idx));
            if(map.containsKey(now.toString())){    // 입력값이 사전에 존재하므로, 더 긴 입력값이 있나 찾기.
                idx++;
                if(idx==sb.length()){ list.add(map.get(now.toString())); break;}    // 맨 마지막 문자열
            }
            else{                                   // 입력값이 사전에 없으므로, 입력값길이-1 까지는 사전에 있음
                list.add(map.get(now.substring(0,now.length()-1)));     // list 에 담아주기
                map.put(now.toString(),map.size()+1);                   // 사전 추가
                sb.delete(0,now.length()-1);                            // 사전에 담은 입력값 삭제
                now.setLength(0);                 // StringBuilder 를 초기화하는 가장 좋은 방법
                idx = 0;
            }

        }
        int[] ret = list.stream().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(ret));
    }
}
