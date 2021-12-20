
/*

    오히려 DFS 가 핵심이었던 문제
    dfs 로 모든 문자열 조합을 뽑은 뒤에,
    소수를 구하여 반환합니다.

 */

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FindDecimal {
    static Boolean[] visit;         // dfs 에서 중복 문자열을 체크하기 위해.
    static Set<Integer> set ;       // 모든 조합에서 중복이 존재하기 떄문에 set 으로 중복을 제거
    public static void main(String args[]){
        int s1=solution("17");
        int s2=solution("011");
        System.out.println(s1);
        System.out.println(s2);
    }

    public static int solution(String numbers){
        visit = new Boolean[numbers.length()];
        set = new LinkedHashSet<>();
        for(int i=0; i<numbers.length(); i++){      // 각각 문자열 부터 조합을 시작하기위해 ex) "1" 부터 시작하는 문자열, "7"부터 시작하는 문자열.
            Arrays.fill(visit,false);           // 배열 초기화
            visit[i]=true;                          // 문자열 중복사용 방지
            dfs(numbers,0,String.valueOf(numbers.charAt(i)));
        }
        System.out.println(set.toString());
        int answer=0;
        for(int i : set)                            // 중복 제거
            if(isDecimal(i)){answer++;}
        return answer;
    }

    public static boolean isDecimal(int n){         // 소수 구하기
        if(n<=1){return false;}
        for(int i=2; i<n; i++){
            if(n%i==0){return false;}
        }
        return true;
    }

    public static void dfs(String number, int depth, String preNum){
        if(depth==0){set.add(Integer.parseInt(preNum));}        // 문자열을 하나만 사용하는 경우도 포함해야 함.
//        if(depth>number.length()){return;}                    // 원래 문자열 길이보다 깊이 들어가면 안됨. 근데 생각해보니까 원래 깊이 못들어감.. 삭제
        for(int i=0; i<number.length(); i++){
            if(visit[i]!=true) {                                // 방문하지 않았다면
                visit[i] = true;                                // 더 깊게 들어가는 dfs 에서 이미 사용한 문자열을 사용하면 안되므로.
                String s = preNum + number.charAt(i);           // 문자열 조합
                int n = Integer.parseInt(s);
                dfs(number, depth + 1, s);               // 새 문자열과 depth+1로 dfs 반복
                set.add(n);
                visit[i]=false;                                // i번 째 방문이 끝났으므로. 
            }                                                  // 만약 false 로 안하면 다음 문자열 시작할 때, 이미 모두 방문했다고 표시되어 있음.
        }                                                      // ex) "1" 부터 시작하는 조합을 전부 방문했으므로 이미 방문한 모든 문자열을 사용못함.
    }
}
