
import java.util.HashSet;
import java.util.Set;

/*

    set 의 중복제거를 사용하여 풀어보았습니다.
    최대한 많은 포켓몬 종류를 선택하기 위해서 종류 별로 몇 가지 인지 확인합니다.
    문제의 조건인 최대 n/2 마리의 포켓몬을 선택할 수 있기때문에,
    총 포켓몬의 종류가 n/2 보다 많다면 n/2 마리만 가져갈 수 있습니다.
    ex) {3,1,2,3}  n = 4 , 종류 = 3   --> n/2 인 2마리만 가져갈 수 있습니다.

    총 포켓몬의 종류가 n/2 보다 적거나 같으면 포켓몬 종류만큼 가져갈 수 있습니다.
    ex) {3,3,3,2,2,4} n = 6 , 종류 = 3  --> n/2 인 3마리를 가져갈 수 있습니다.

    ex) {3,3,3,2,2,2} n = 6 , 중류 = 2  --> n/2 인 3마리를 가져갈 수 있지만,
    총 종류가 2종류 이기때문에 가져가는 포켓몬의 종류는 최대 2개 입니다.

    시간복잡도: O(n)

    코드보다 주석을 더 오래쓴 문제..

 */


public class Pokemon {
    public static void main(String args[]){
        System.out.println(solution(new int[] {3,1,2,3}));
    }

    public static int solution(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int n : nums)
            set.add(n);
        if(set.size()>(nums.length/2)){ return nums.length/2; }
        return set.size();
    }
}