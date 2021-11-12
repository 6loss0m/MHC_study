/*
    dfs 로 풀어보았습니다.
 */
public class TargetNumber {
    static int MAX_DEPTH;
    static int TARGET;
    static int answer;
    public static void main(String args[]){
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        answer=0;
        TARGET = target;
        MAX_DEPTH=numbers.length;
        dfs(numbers,0,0);
        System.out.println(answer);
    }

    //numbers 를 순회하며 count == numbers.length 라면
    //numbers 배열의 모든 인자를 사용한 것.
    static void dfs(int[] numbers, int count, int prev){
        if(count==MAX_DEPTH){
            if(prev==TARGET) {answer++; return;} // 두 조건을 충족하면 answer이기에 ++
            return;}
        dfs(numbers,count+1, prev+numbers[count]); // 더하기 연산
        dfs(numbers,count+1,prev-numbers[count]);  // 뺴기 연산
        return;
    }
}
