package Programmers.blindrecruitment_2020;

import java.util.Stack;

public class bracket {
    public String solution(String p) {
        if(p.isEmpty()) {
            return p;
        }
        if(check(p)){
            return p;
        } else {
            String u = p.substring(0,divideUV(p));
            String v = p.substring(divideUV(p));

            if (check(u)) {
                return u + solution(v);
            }

            StringBuilder answer = new StringBuilder("(" + solution(v) + ")");
            for (int i = 1; i < u.length()-1; i++) {
                if(u.charAt(i)=='(') {
                    answer.append(")");
                } else {
                    answer.append("(");
                }
            }
            return answer.toString();
        }
    }
    static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
            } else {    // ')'일때
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    static int divideUV(String p) {
        int l = 0;
        int r = 0;
        int pos;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i)=='(') {
                l++;
            } else {
                r++;
            }
            if (r==l) {
                return i+1;
            }
        }
        pos = p.length();
        return pos;
    }

    public static void main(String[] args) {
        bracket bc = new bracket();
        System.out.println(bc.solution("(()())()"));
        System.out.println(bc.solution(")("));
        System.out.println(bc.solution("()))((()"));
    }
}
