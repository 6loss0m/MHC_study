package Programmers.MonthlycodeChallenge2.MCC2022_08_10;
import java.util.*;

public class move110 {
    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;

        for(int i = 0 ; i < s.length; i++){
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0;

            for(int j = 0 ; j < str.length() ; j++){
                char z = str.charAt(j);

                if(stack.size() > 1){
                    char y = stack.pop();
                    char x = stack.pop();

                    if(x == '1' && y == '1' && z == '0')
                        cnt++;
                    else{
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                }
                else
                    stack.push(z);
            }

            int idx = stack.size();
            boolean flag = false;
            sb = new StringBuilder();

            // 0의 마지막 위치 찾기
            while(!stack.isEmpty()){
                if(!flag){
                    if(stack.peek() == '1')
                        idx--;
                    else
                        flag = true;
                }
                sb.insert(0, stack.pop());
            }

            if(cnt > 0){
                while(cnt-- > 0){
                    sb.insert(idx, "110");
                    idx += 3;
                }
                answer[i] = sb.toString();
            }
            else
                // 110 이 없다는 의미이므로 그대로
                answer[i] = s[i];
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
