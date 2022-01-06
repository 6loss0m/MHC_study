/**
 *
 *  절반이 효율성이 떨어져 풀이를 참고하였습니다.
 *  기존 방식 :
 *      map 은 가장 최신 보석의 인덱스를 가지고있습니다.
 *      보석의 종류와 map 사이즈가 같고, map 보석인덱스의 최소값이 변했다면
 *      가장 먼저들어온 보석과 마지막에 들어온 보석이 같다는 뜻이므로 최소구간이 될 가능성이 있기에 저장해 둡니다.
 *      단점:
 *          보석 종류와 map 사이즈가 같을 때, map 에 접근하여 모든인자를 불러들여와 정렬을 해주므로
 *          최악의 경우 시간복잡도가 높아 짐.
 *
 *  참고방식 :
 *      큐를 사용하여 맨 처음 들어온 보석이 2개 이상인 경우 맨앞의 보석을 구간에서 제외하는 일을 반복.
 *
 *      기본적으로 큐 와 map 을 이용합니다.
 *      map 은 (보석이름,갯수) 를 key-value 값으로 갖고있습니다.
 *      큐는 보석이 들어온 순서데로 저장합니다.
 *      start 는 범위지정에서 시작지점을 의미합니다.
 *
 *     1. 큐와 map 에 보석을 넣어줍니다.
 *     2. 큐를 보고 최상단(가장먼저)의 보석이 2개 이상인 경우 (큐에서 최상단을 보고, 그걸 이용해 맵에서 보석갯수 조회.)
 *     3. 맨 앞의 보석을 구간에서 제외합니다. (start 지점을 ++ ) // 맨앞의 보석과 맨뒤의 보석이 같다면 맨앞의 보석을 구간에 포함시킬 이유가 없기떄문.
 *     4. 반복.
 *
 */

import java.util.*;

public class JewelryShopping {
    public static void main(String args[]) {
//        String[] s1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        System.out.println(Arrays.toString(solution(s1)));
//        String[] s2 = {"AA", "AB", "AC", "AA", "AC"};
//        System.out.println(Arrays.toString(solution(s2)));
//        String[] s3 = {"XYZ", "XYZ", "XYZ"};
//        System.out.println(Arrays.toString(solution(s3)));
//        String[] s4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//        System.out.println(Arrays.toString(solution(s4)));
        String[] s5 = {"1", "2", "2", "2", "3", "1", "1", "3", "2"};
        System.out.println(Arrays.toString(solution(s5)));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();                          // <보석,갯수>
        Queue<String> q = new LinkedList<>();
        int start = 0;
        int leng = Integer.MAX_VALUE;

        for (String gem : gems) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);         // map<보석,갯수> 최신화
            q.add(gem);                                                    // 큐에 추가.
            while (true) {
                if (map.get(q.peek()) > 1) {                                // 큐의 최상단을 보고 map 을 조회해 보석이 2개이상라면
                    String tmp = q.poll();                                  // 큐에서 중복된 보석을 삭제하고
                    map.put(tmp, map.get(tmp) - 1);                         // 맵에서 보석의 갯수를 기존-1 로 최신화
                    start++;                                                // start++ 해줍니다.
                } else {
                    break;
                }
            }
            if (map.size() == set.size() && leng > q.size()) {              // 맵사이즈 == 보석종류 &&  큐사이즈 < leng(기존 큐사이즈의 최소값)
                leng = q.size();                                            // leng 최신화
                answer[0] = start + 1;
                answer[1] = start + leng;
            }
        }
        return answer;
    }
}
