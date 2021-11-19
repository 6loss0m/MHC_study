import java.util.LinkedHashMap;
import java.util.Map;
/*
    시간복잡도: O(n)
 */
public class Marathon {
    public static void main(String args[]){
        
        //test case
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        
        //HashMap 선언
        Map<String,Integer> hash = new LinkedHashMap<>();

        //HashMap에 모든 참가자를 넣고 동명이인들은 +1씩 해주기.
        for(String s : participant)
        {
            if(hash.get(s)==null){hash.put(s,1);}
            else{hash.put(s,hash.get(s)+1);}
        }
        
        //완주자들은 자기의 Key Value 에서 Value를 -1씩 해주기.
        for(String s: completion){
            hash.put(s,hash.get(s)-1);
        }
        
        //참가는 했지만 완주는 못한상태인 Value가 1인 사람을 리턴.
        for(String s: hash.keySet()){
            if(hash.get(s)==1){
                System.out.println(s);}
        }


    }
}
