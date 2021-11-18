import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
    dfs 로 풀어보았습니다.
    dfs 로 짜면 보통 코드 작성이 간결하여 dfs 로 풀게되는듯 합니다..

 */


public class TravelRoute {
    public static void main(String args[]) {
        String[][] tickets = {{ "ICN", "SFO" },{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL", "SFO"}};
        String[] answer;

        Boolean[] visit = new Boolean[tickets.length];                              // 방문확인 배열
        Arrays.fill(visit,false);                                               // visit 배열  초기화
        ArrayList<String> route;                                                    // 경로를 담을 arraylist
        Comparator<String[]> comparator = new Comparator<String[]>() {              // 여러 경로가 존재한다면 알파벳 오름차순으로 경로를 만들어야하므로
            @Override                                                               // tickets 를 비교하기위한 익명클래스
            public int compare(String[] o1, String[] o2) {
                if(o1[0].equals(o2[0])){return o1[1].compareTo(o2[1]);}             // string 비교하여 오름차순으로 정렬하기 위한 comparator
                else return o1[0].compareTo(o2[0]);
            }
        };

        Arrays.sort(tickets,comparator);                                            // 배열 오름차순으로 정렬

        route = dfs(tickets,0,"ICN", new ArrayList<>(),visit);           // 시작위치가 ICN 이므로 ICN 부터 시작
        route.add("ICN");                                                           // 첫 시작위치가 ICN 이므로
        Collections.reverse(route);                                                 // dfs 의 특성상 depth 가 가장 깊은곳부터 되감겨 나오기때문에 역순으로 바꿔줘야 함.
        answer=new String[route.size()];
        for(int i=0; i<route.size(); i++){                                          // ArrayList 를 answer[] 로 바꾸기.
            answer[i]=route.get(i);
        }
        for(String s: answer){                                                      // 출력 확인.
            System.out.println(s);
        }

    }
    public static ArrayList<String> dfs(String[][] tickets, int count , String prev, ArrayList<String> arrayList, Boolean[] visit){
        String next="";
        if(count>tickets.length){return null;}                                      // depth 가 티켓보다 깊으면 안되기 때문에
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(prev)&&!visit[i]) {                             // prev 가 티켓의 [i][0]과 같다면 갈 수 있고, 아직 방문하지 않은 곳을 탐색
                next=tickets[i][1];                                                 // next 는 사용하려는 티켓의 [i][1]이므로
                visit[i]=true;                                                      // 방문 최신화
                dfs(tickets,count,next,arrayList,visit);                            // 다음 깊이로 들어가기
                arrayList.add(next);                                                // 가장 깊은곳에서 부터 arrayList 에 next 를 add
            }
        }
        if(arrayList.size()<tickets.length){return null;}                           // 모든 티켓을 사용하지않았다면 null 반환
        return arrayList;                                                           // 모든 티켓을 다 사용하였다면 arrayList 를 반환
    }
}
