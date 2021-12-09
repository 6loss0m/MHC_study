
import java.util.Stack;
/*
    문제 아이디어:
    number 값 중 앞에서 부터 작은 수를 지우는게 큰 수를 만드는 방법이라고 생각했습니다.

    시간복잡도: O(n^2)

 */


public class MakeMax {
    public static void main(String args[]){
        String number = "987654321";
        int k=4;
        char[] result = new char[number.length()-k];
        Stack<Character> stack = new Stack<>();
        for(int i=0; i< number.length(); i++){
            char c= number.charAt(i);

            while(!stack.empty() && stack.peek()<c && k-- > 0){     // stack의 최상단을 확인하여 i번 째의 수가 가장 큰 수인지 확인합니다.
                stack.pop();                                        // stack의 최상단이 i보다 작다면 pop을 해줍니다. 최대 k번 까지.
            }
            stack.push(c);
        }
        for(int i=0; i<result.length; i++){
            result[i]= stack.get(i);                                // 앞에서 작은 숫자를 지웠으나 k번 보다 덜 지워졌을 경우
        }                                                           // ex) 987654321 같은 경우 뒤에서 남은 k번 만큼 지워야합니다.
        System.out.println(new String(result));
    }
}
