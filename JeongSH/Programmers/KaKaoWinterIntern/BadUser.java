package KaKaoWinterIntern;
import java.util.*;
/*

    dfs 문제로 풀어보았습니다.
    모든 조합을 구한 뒤, set 을 사용하여 중복을 없애 주었습니다.

 */
class BadUser {
    static HashSet<String> list;    // 제재 아이디가 들어갈 list set 을 사용한 이유는 조합은 순서가 없기 때문에
    static int[] userVisit;         // dfs 의 순회는 줄이기위한 visit
    static int[] banVisit;          // dfs 의 순회는 줄이기위한 visit
    static HashSet<String> set;     // 최종 결과에서 중복을 없앨 set

    public static void main(String args[]){
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        userVisit=new int[user_id.length];
        banVisit=new int[banned_id.length];
        list=new HashSet<>();
        set=new HashSet<>();
        dfs(user_id,banned_id,0,0);
        return set.size();
    }
    public static void dfs(String[] user_id,String[] banned_id, int depth,int ban){
        System.out.println(list.toString());
        if(depth==banned_id.length){
            set.add(list.toString());       // depth 가 증가할 때마다 재제목록의 아이디가 하나 추가되기때문에
            return;                         // depth 가 banned_id 의 길이와 같아지면 string 으로 변환하여 set 에 넣어줍니다.
        }
        else{
            for(int u=0; u<user_id.length; u++){
                if(userVisit[u]==1){continue;}              // dfs 순회를 줄이기 위해
                userVisit[u]=1;
                for(int b=ban; b<banned_id.length; b++) {
                    if(banVisit[b]==1){continue;}           // dfs 순회를 줄이기 위해
                    banVisit[b]=1;
                    if (isTrance(user_id[u], banned_id[b])) {
                        list.add(user_id[u]);
                        dfs(user_id,banned_id,depth+1,ban+1);
                        list.remove(user_id[u]);            // 재귀식으로 되감길 때 목록에서 빼줘야 하므로
                    }
                    banVisit[b]=0;
                }
                userVisit[u]=0;
            }
        }


    }

    public static boolean isTrance(String user_id, String banned_id){       // user_id 가 banned_id로 변환가능한지
        if(user_id.length()!=banned_id.length()){return false;}
        for(int i=0; i<user_id.length(); i++){
            if(banned_id.charAt(i)=='*'){continue;}
            if(user_id.charAt(i)!=banned_id.charAt(i)){return false;}
        }
        return true;
    }
}