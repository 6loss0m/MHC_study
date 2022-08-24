// 68644 - 두개 뽑아서 더하기
// 배열리스트는 Collections.sort()로 정렬도 가능
import java.util.*;

class Solution {
    public int[] solution(int[] numbers){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] answer;

        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int n = numbers[i] + numbers[j];

                if (list.indexOf(n)<0) { //n이 리스트에 없다면
                    list.add(n);
                }
            }
        }
        answer = new int[list.size()];

        for (int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}