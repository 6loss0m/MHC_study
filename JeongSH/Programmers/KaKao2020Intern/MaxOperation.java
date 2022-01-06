package KaKao2020Intern;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * 문제 아이디어:
 *      0. 연산자와 number 를 분리하여 저장합니다.
 *      1. 연산자 우선순위를 정하는 순열을 구합니다.
 *      2. 하나의 연산자 우선순위를 구하면, 해당 우선순위로 모든 연산을 적용하여 값을 구합니다.
 *      3. 최대값을 구합니다.
 *
 *  팁:
 *      0. Arraylist.remove(index) return 값은 Arraylist.get(index) 와 같고, index 번째 원소를 삭제합니다.
 *      1. numList, opList
 *          [100,200,300,500,20] / [-,*,-,+]
 *          연산 :
 *              numList.add(i, cal (numList.remove(i), numList.remove(i), opList.remove(i)))
 *              remove(i)를 두번하는 이유는 원소를 삭제하면 원소들이 앞쪽으로 인데싱 되기 때문입니다.
 *
 */

public class MaxOperation {
    static int [] visit=new int[3];
    static ArrayList<String> opList=new ArrayList<>();
    static ArrayList<Long> numList= new ArrayList<>();
    static long answer;

    public static void main(String args[]){
        long solution = solution("100-200*300-500+20");
        System.out.println(solution);
    }
    public static long solution(String expression){
        answer=0;
        expression = expression.replaceAll("[*]"," * ")
                .replaceAll("[+]"," + ")                                  // 연산자와 숫자를 구분하기 위해, 모든 연산자 앞뒤에 공백을 추가합니다.
                .replaceAll("[-]"," - ");
        String[] exSplit = expression.split(" ");                                   // 공백을 기준으로 문자열을 나눠줍니다. [100, -, 200, *, 300, -, 500, +, 20]
        for(String s: exSplit){                                                           // 숫자와 연산자를 나누어서 저장.
            if(Pattern.matches("^[0-9]*$",s)){numList.add(Long.parseLong(s));}
            else{ opList.add(s); }
        }
        priorityOp(" ",0);
        return answer;
    }
    public static void priorityOp(String pre,int depth){
        if(depth==3){                                                                       // 하나의 연산자 우선순위가 만들어 졌다면,
            System.out.println(pre);
            ArrayList<Long> nL =new ArrayList<>(numList);
            ArrayList<String> oL =new ArrayList<>(opList);
            String[] opPri = pre.trim().split(" ");
            for(int index=0; index<opPri.length; index++) {
                for(int i=0; i<oL.size(); i++){                                             // 연산자 우선순위를 보고 계산합니다.
                    if(oL.get(i).equals(opPri[index])){nL.add(i,cal(nL.remove(i),nL.remove(i),oL.remove(i))); i--;}
                }
            }
            answer=Math.max(answer,Math.abs(nL.get(0)));                                    // 최대값을 저장합니다.
        }
        else {
            for(int i=0 ; i<visit.length; i++){                                             // 연산자 우선순위 순열 만들기.
                if(visit[i]==1){continue;}
                else {
                    visit[i] = 1;
                    pre +=getOp(i)+" ";
                    priorityOp(pre, depth+1);
                    pre = pre.substring(0,pre.length()-2);
                    visit[i] = 0;
                }
            }
        }
    }
    public static Long cal (Long a, Long b, String op){
        if(op.equals("+")){return a+b;}
        if(op.equals("-")){return a-b;}
        return a*b;
    }
    public static String getOp(int n){
        if(n==0){return "+";}
        else if(n==1){return "-";}
        else return "*";
    }
}
