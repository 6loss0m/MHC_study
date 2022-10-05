package BLIND_2020;

import java.util.Stack;
/*
    테스트케이스로도 문제를 파악하기 어려워서 문제파악이 어려운 문제입니다.
    머리를 비우고 하라는데로 구현하면됩니다.

    재귀로 풀 때, 어떤 인자를 보낼것인지랑 반환값이 어떻게 올지 생각하며 풀어야 햇갈리지 않습니다.

 */

public class Bracket {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
        System.out.println("()(())()");

    }

    static String solution(String p) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        if(p.length()==0){ return ""; }

        int left=0;
        int right=0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){ right++; }
            else{ left++; }

            // 균형잡힌 괄호
            if(left==right){
                u.append(p.substring(0,i+1));
                v.append(p.substring(i+1,p.length()));
                if(isPerfect(u)){   // 완벽한 괄호라면, v를 변환해야합니다.
                    u.append(solution(v.toString()));
                }
                else{
                    StringBuilder tmp = new StringBuilder();    // 해당 조건 파악이 어려웠습니다.
                    tmp.append("(");                            // 문제 그대로 빈 문자열을 만들어 괄호를 추가합니다.
                    tmp.append(solution(v.toString()));
                    tmp.append(")");
                    tmp.append(reverse(u));
                    return tmp.toString();
                }
                break;
            }
        }
        return u.toString();
    }

    static boolean isPerfect(StringBuilder s){      // 괄호가 올바른지는 스택을 사용하여 판단합니다.
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){ stack.push(1); }
            else {
                if(stack.isEmpty()){ return false;}
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    static String reverse(StringBuilder s){
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)=='('){ sb.append(")");}
            else{ sb.append("(");}
        }
        return sb.toString();
    }

}
