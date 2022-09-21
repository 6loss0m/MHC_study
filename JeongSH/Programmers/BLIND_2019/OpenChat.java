package BLIND_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*

    해시맵으로 유저아디와 닉네임을 관리합니다.

 */

public class OpenChat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan" };

        HashMap<String, String> map = new HashMap<>();
        for(int i=0;i< record.length;i++){
            String[] split = record[i].split(" ");
            if(split.length==3) {map.put(split[1],split[2]);}   // 나가는건 무시해도 되기때문
        }

        ArrayList<String> list= new ArrayList<>();
        for(int i=0;i<record.length;i++){
            String[] split = record[i].split(" ");
            if(split[0].equals("Enter")) { list.add(map.get(split[1])+"님이 들어왔습니다."); }
            else if(split[0].equals("Leave")){ list.add(map.get(split[1])+"님이 나갔습니다."); }
        }

        System.out.println(Arrays.toString(list.stream().toArray(String[]::new)));
    }
}
