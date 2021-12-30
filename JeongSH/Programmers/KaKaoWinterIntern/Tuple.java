package KaKaoWinterIntern;

/*

    문자열 처리하는 문제입니다.
    문제 파악
        문제 파악이 조금 느렸는데, 문제의 요지는
        "{}" 안에 있는 인자들은 순서가 바뀔 수 있다는 것입니다.
        그리고 특정 튜플을 가리키는 s 의 집합은 항상 올바르게 표현되어있습니다.
        {2,3},{3},{1,3,2} 을 가지고있는 튜플의 인자의 순서는
        {3} -> [3]
        {2,3} -> [3,2] // 집합안의 순서는 바뀔수 있습니다.
        {1,3,2} -> [3,2,1] // 집합의 순서는 바뀔수 있습니다.
        정답 : [3,2,1]

    "{" , "}" 문자열을 없앤 뒤 오름차순 정렬을 하면 튜플 인자의 순서를 알 수 있습니다.
    오름 차순으로 정렬된 인자들을 LinkedHashSet 의 중복 제거,순서 보장을 이용하여 풀이해보았습니다.

    두 번째 풀이는 이후 다른사람 풀이를 보고 정말 좋다고 생각하여 가져왔습니다.

 */

import java.util.*;

public class Tuple {
    public static void main (String args[]){
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution("{20,111},{111}")));
        System.out.println(Arrays.toString(solution("{{123}}")));
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    public static int[] solution (String s){
        String[] str = s.split("\\{|\\}");
        Arrays.sort(str, (s1, s2) -> s1.length()-s2.length());
        LinkedHashSet<Integer> set = new LinkedHashSet<>();        // 중복을 제거해 주고, 인자의 순서를 먼저들어온 순서로 보장해 줍니다.
        for(String e : str){
            if(!e.equals("") && !e.equals(",")){
                if(e.length()==1){set.add(Integer.parseInt(e));}
                else{
                    String[] eStr = e.split(",");
                    for(String ee: eStr){ set.add(Integer.parseInt(ee));}
                }
            }
        }
        int[] answer= new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int i=0;
        while(iter.hasNext()){
            answer[i++]=iter.next();                        // 순서 보장을 해주므로
        }

        return answer;
    }
    public static int[] solution2 (String s){
        Set<String> set = new HashSet<>();
        // replaceAll 은 정규식을 사용하여 문자열을 바꿔줄 수 있습니다.
        // trim 은 문자열 "앞뒤" 공백을 지워줍니다.
        // 각 집합의 구분자는 "," 아닌 " , " 입니다.
        // ex) {n1,n2},{n2,n3,n1} "}" ->" "  변하고 "{"-> " " 로 변하기 때문에 각 집합의 구분자는 앞뒤 공백을 포함한 " , " 입니다.
        String[] arr = s.replaceAll("[}]"," ").replaceAll("[{]", " ").trim().split(" , ");
        Arrays.sort(arr,(o1,o2)->{return o1.length()-o2.length();});
        int index=0;
        int[] answer= new int[arr.length];
        for(String e : arr){
            for(String ee: e.split(",")){
                // set.add() 의 반환값은 set 에 새로운 인자가 추가되었을 때, true 아닐때 false 를 반환합니다.
                // 즉, 중복일 땐 false 중복이 아닐때 true 를 반환합니다.
                if(set.add(ee))answer[index++]=Integer.parseInt(ee);}
        }
        return answer;
    }
}
