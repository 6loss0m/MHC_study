package Programmers.blindrecruitment_2019.br_2019_0906;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChatroom {
    public String[] solution(String[] record) {
        ArrayList<String> chatlog = new ArrayList<>();
        HashMap<String, String> nickMap = new HashMap<>();

        for (String str : record) {
            String[] log = str.split(" ");
            String command = log[0];
            String userId = log[1];
            String nickname = "";
            if(!command.equals("Leave")){
                nickname = log[2];
            }

            if(command.equals("Enter")) {
                nickMap.put(userId, nickname);
                chatlog.add(userId+"님이 들어왔습니다.");
            } else if(command.equals("Leave")) {
                chatlog.add(userId+"님이 나갔습니다.");
            } else {
                nickMap.put(userId, nickname);
            }
        }
        String[] answer = new String[chatlog.size()];
        int logidx = 0;
        for(String str : chatlog){
            int endofId = str.indexOf("님");
            String userId = str.substring(0, endofId);

            answer[logidx++] = str.replace(userId, nickMap.get(userId));
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
