package CodeChallenge2;
/*
    문자열에서 110 을 모두 제거하고, 110의 갯수를 세어줍니다.
    110을 모두 제거한 문자열은
    1,11,111
    101,10,01
    011,001,00
    100,000,0
    이런 패턴을 가지게됩니다.
    사전순으로 가장 앞에오는 방법으로 110을 삽입해야 하므로,
    앞쪽에 0이 존재한다면 가장 마지막 0 뒤에 110을 삽입하는게 사전순으로 가장 앞으로 올 수 있습니다.
    ex) 100000000 -> 100000000110
    ex) 101      ->  101101
    ex) 1001     ->  1001101
    왜냐하면,
    패턴1. 1010101... : 0,1 이 번갈아 나오는 방식. 하지만 110 보단 1010101 이 사전순의 앞순이기 때문에
                      가장 마지막 0과 1 사이에 삽입하는것이 가장 사전순의 앞순.
    패턴2. 011111... : 0 이 하나 혹의 두개가 나온뒤에 1 이 연속하여 나오는 경우.
    패턴3. 10000.... : 1 이 하나 나온뒤에 0이 연속하여 나온는 경우.
    등등 이지만
    110 앞에 나오면 안되는 패턴만 생각하면 됩니다.

    주의점
    java 의 delete(start,end) 는 삭제후 뒤의 문자열과 이어주는 부분에서 O(N) 의 시간복잡도를
    가지므로, 반복문으로 매번 delete() 메소드를 호출하면 O(N^2) 의 시간복잡도를 가지게됩니다.
    스택을 사용해서
    가장 마지막 문자가 '0' 일 경우 스택의 siez-2 ~ size-1 이 모두 '1' 인지 확인하여
    push, pop 을 합니다.

 */

import java.util.Arrays;
import java.util.Stack;

public class _110 {
    public static void main(String[] args) {
        String[] s={"11001","100111100","0111111010"};
        StringBuilder sb;
        String[] result = new String[s.length];
        for(int i=0;i<s.length;i++){
            Stack<Character> stack = new Stack<>();
            int count = 0;
            for(int j=0;j<s[i].length(); j++){
                char tmp = s[i].charAt(j);
                int lastIdx = stack.size();
                if(tmp == '0' && lastIdx>=2 && stack.get(lastIdx-1)=='1' && stack.get(lastIdx-2)=='1'){
                    stack.pop();stack.pop();
                    count+=1;
                }
                else { stack.add(tmp); }
            }
            sb = new StringBuilder();
            while (!stack.isEmpty()){ sb.append(stack.pop()); }
            sb.reverse();   // 스택을 pop 하여 문자열을 추가했으므로 역순으로 되어있기때문에

            for(int j=sb.length()-1; j>=0; j--){
                if(sb.charAt(j)=='0'){ sb.insert(j+1,"110".repeat(count)); break;}  // 가장 마지막 0 뒷부분에 추가
                if(j==0){ sb.insert(0,"110".repeat(count)); }   // 모두 '1' 로 이루어져있을 경우
            }
            if(sb.length()==0){ sb.append("110".repeat(count)); }   // ""같이 아무것도 없는 문자열 일경우에는 count 만큼 110 추가
            result[i]=sb.toString();
        }
        System.out.println(Arrays.toString(result));

    }
}
