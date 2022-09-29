package Programmers.blindrecruitment_2022.br_2022_0915;

import java.util.*;

public class report {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportHash = new HashMap<>();
        HashMap<String, HashSet<String>> resultHash = new HashMap<>();
        for (String r : report) {
            String[] str = r.split(" ");
            if (!reportHash.containsKey(str[0])){
                reportHash.put(str[0], new HashSet<>());
            }
            reportHash.get(str[0]).add(str[1]);

            if (!resultHash.containsKey(str[1])){
                resultHash.put(str[1], new HashSet<>());
            }
            resultHash.get(str[1]).add(str[0]);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < answer.length; i++) {
            String user = id_list[i];
            if (!reportHash.containsKey(user)) { continue; }
            for (String bad : reportHash.get(user)) {
                if(resultHash.get(bad).size() >= k){ answer[i]++; }
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
