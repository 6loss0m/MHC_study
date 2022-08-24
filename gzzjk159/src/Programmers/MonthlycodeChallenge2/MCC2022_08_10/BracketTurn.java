package Programmers.MonthlycodeChallenge2.MCC2022_08_10;
import java.util.*;

public class BracketTurn {
    public int solution(String s) {
        int answer = 0;
        String new_s = s;
        for(int i = 0; i < s.length(); i++){
            if(checkString(new_s)) answer++;
            new_s = new_s.substring(1, s.length()) + new_s.charAt(0);
        }

        return answer;
    }

    boolean checkString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            try{
                switch (s.charAt(i)) {
                    case '[' -> stack.add('[');
                    case ']' -> {
                        if (stack.peek() != '[') return false;
                        stack.pop();
                    }
                    case '{' -> stack.add('{');
                    case '}' -> {
                        if (stack.peek() != '{') return false;
                        stack.pop();
                    }
                    case '(' -> stack.add('(');
                    case ')' -> {
                        if (stack.peek() != '(') return false;
                        stack.pop();
                    }
                }
            } catch(Exception e){
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {

    }
}
