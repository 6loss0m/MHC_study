import java.util.Arrays;
import java.util.Comparator;

/*

    문제 아이디어:
    1. numbers 를 문자로 바꾸어 정렬하면 될거같다라는 생각이 들었습니다.
        : 3,30,34,5,9 (문자화하고 내림차순 정렬)==> 9,5,34,30,3
        기대했던데로 9,5,34 순은 정렬되었으나 3과 30은 기대한것과 다르게 정렬 되었습니다. (사전식으로 정렬이니 당연한 것..)
    2. 3,34,30 을 비교할 때 기준을 생각해 보면 34,3,30 순서로 되어야합니다.
        : 3뒤에 3이 있다고 생각하고 비교를 하는것과 같음 3(3),34,30 => 34,3(3),30
    3. 그래서 모든 숫자를 제한사항인 각 원소는 100000이하를 사용하여 모든자리 숫자를 6번 반복하는 걸로 바꿔줍니다.
        : ex) 3 -> 333333 , 30 -> 303030303030
        변환 뒤, 정렬을 하면 기대한 결과값이 나오게됩니다.

    시간복잡도: O(n)

 */


public class Max2 {
    public static void main(String args[]){
        int[] numbers = {3, 30, 34, 5, 9};
        String answer="";
        String[] sNumbers=new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            sNumbers[i]=String.valueOf(numbers[i]).repeat(6);   // 모든 원소를 6번 반복하여 새로운 배열을 만들어줍니다.
        }
        Arrays.sort(sNumbers, Comparator.reverseOrder());       // 내림차순으로 정렬
        for(String s: sNumbers)
            answer+=s.substring(0,s.length()/6);                // 원소를 6번 반복하여서 만들었기 때문에 반환할 문자열은 length/6 을 해줍니다.
        if(answer.charAt(0)=='0'){answer="0";}                  // 결과 값이 "000000" 같은 경우는 "0" 으로 반환해야합니다.
        System.out.println(answer);                             // 테스트케이스 11번이 이런 경우입니다.
    }
}
