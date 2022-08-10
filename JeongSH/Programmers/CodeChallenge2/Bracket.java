package CodeChallenge2;

import java.util.Stack;
/*
    매 반복마다 문자열을 자를필요없이,
    문자열을 원형이라고 생각하고
    시작 인덱스 부터 + 길이 만큼 검사합니다.
    idx : 0 ~ length
    start : 시작할 위치.
    arr[ (start+idx)%length ]


    스택을 사용하여 괄호가 알맞은지 판단합니다.
    1. (,{,[ 는 무조건 push 하고,
    2. ),},] 는 peek 을 하여 최상위의 부호가 짝이 맞는지 검사합니다.
    검사하는 과정에서 알맞지않는다면 더이상 돌지않고 false 를 반환합니다.
    만약 중간에 멈추지 않는다면 stack 이 모두 비었는지 비어있지않은지 판단하여 반환합니다.

    stack 에 원소가 남아있다는 것은 "(,{,[" 갯수가 "),},]" 갯수보다 많다는 것이므로 틀린 식 입니다.

 */

public class Bracket {
    static char[] bracket;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) {
        String s="}}}";
        bracket = s.toCharArray();
        int len = bracket.length;
        int cnt=0;
        for(int i=0;i<len;i++){
            if(isValid(i,len)) { cnt+=1; }
        }
        System.out.println(cnt);
    }
    static boolean isValid(int start, int len){
        stack.clear();
        int idx=0;
        while (idx<len){
            int tmp = (start+idx)%len;
            char now = bracket[tmp];
            if(now==')' || now=='}' || now==']'){
                if(stack.isEmpty()){return false;}  // 닫는 괄호가 나왔는데 이전에 열린괄호가 없다면 무조건 거짓.
                if(now==')' && stack.peek()!='(') { return false; } // 짝이 맞는지 검사합니다.
                if(now=='}' && stack.peek()!='{') { return false; }
                if(now==']' && stack.peek()!='[') { return false; }
                stack.pop();    // 위의 조건에서 return 하지 않았으므로 일단은 올바른 식입니다.
            }
            else{ stack.add(bracket[tmp]); }    // 열린 괄호는 push
            idx+=1;
        }
        return stack.isEmpty();     // 원소가 남아있다면 열린괄호 > 닫힌괄호 이므로 틀린 식.
    }
}
