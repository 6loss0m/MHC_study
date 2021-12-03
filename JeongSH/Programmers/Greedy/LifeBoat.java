
import java.util.Arrays;

/*

    문제 아이디어:
    1. 가장 가벼운 사람과 가장 무거운 사람이 태워지는지 확인
    2. 태워지지 않는다면 가장 무거운 사람만 태워보내기.

    시간복잡도 : O(n)

 */

public class LifeBoat {
    public static void main(String args[]){
        int[] people = {70, 50, 80, 50};                                // 50,50,70,80
        int limit = 100;
        int answer=0;
        Arrays.sort(people);                                            // 무게 순서 오름차순으로 정렬
        int max = people.length-1;
        int mini = 0;
        while(mini <= max){
            if(mini == max){answer ++; break;}                          // 남은 사람이 혼자일 경우 혼자 태워보내고 반복문 중단.
            else if(people[mini]+people[max]<= limit){mini ++;}         // 가장 가벼운 사람과 가장 무거운 사람을 태워 보낼 수 있다면, 가장 가벼운 사람 한명을 태워 보냅니다.
            max--;                                                      // 가장 무거운 사람은 가장 가벼운 사람과 탈수있건 못타건 태워 보내야합니다.
            answer++;
        }
        System.out.println( answer);

    }
}
