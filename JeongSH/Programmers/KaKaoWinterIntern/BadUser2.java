package KaKaoWinterIntern;
/*

    과거에 풀지못하여 남의 코드를 참고한거같습니다.
    문제해결 아이디어.
    모든 순열을 LinkedHashSet 에 넣고, 해당 LinkedHashSet 이 banned_id 목록을 충족하는지 확인하는 방식.
    LinkedHashSet 은 HashSet 과 달리 인자가 들어온 순서를 보장합니다.
    그렇기 때문에 LinkedHashSet 을 순회하며 banned_id 목록과 대조할 때,
    이중 반복문이 아닌 하나의 반복문으로 banned_id 목록과 대조할 수 있습니다.

 */
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class BadUser2 {
    private static HashSet<HashSet<String>> result = new HashSet<>();       // 결과값을 저장할 set
    public static void main(String args[]) {
        System.out.println(solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        dfs(user_id, banned_id, new LinkedHashSet<>());                 // LinkedHashSet 은 인자의 들어온 순서를 보장합니다.
        return result.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, Set<String> set) {
        System.out.println(set.toString());
        if (set.size() == banned_id.length) {
            if (isBannedUsers(set, banned_id)) {
                result.add(new HashSet<>(set));
            }

            return;
        }

        for (String userId : user_id) {             // 모든 조합을 만듭니다.
            if (!set.contains(userId)) {
                set.add(userId);
                dfs(user_id, banned_id, set);
                set.remove(userId);
            }
        }
    }

    private static boolean isBannedUsers(Set<String> set, String[] banned_id) {
        int i = 0;

        for (String user : set) {                           // LinkedHashSet 은 순서를 보장하기 때문에
            if (!isSameString(user, banned_id[i++])) {      // 반복문 하나로 검사를 할 수 있습니다.
                return false;
            }
        }

        return true;
    }

    private static boolean isSameString(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.charAt(i) == '*') continue;

            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
