/*

    정확성은 전부 맞았지만 효율성 테스트는 통과하지 못했습니다.
    문제 접근:
    각각의 인자들을 3개 씩묶어서 먼저 계산하는 모든 경우의 수를 계산하는 방식.
        {"1", "-", "3", "+", "5", "-", "8"} 인자가 주어졌을 때,
        1. (1 - 3) + 5 - 8   : 이렇게 먼저 계산하는 경우의 수
            1-1. (-2 + 5) - 8   : 계산하는 경우의 수
                1-1-1. 3 - 8        : 답 -5
            1-2. -2 + (5 - 8)   : 계산하는 경우의 수
                1-2-1. -2 + -3      : 답 -5

        2. 1 - (3 + 5) - 8   : 이렇게 먼저 계산하는 경우의 수
            2-1. (1 - 8) - 8      : 계산하는 경우의 수
                2-1-2. -7 - 8        : 답 -15
            2-2. 1 - (8 - 8)      : 계산하는 경우의 수
                2-2-1. 1 - 0         : 답 1

        3. 1 - 3 + (5 - 8)   : 이렇게 먼저 계산하는 경우의 수
        .....
    이런 식으로 3개의 인자들을 묶어서 모든 경우의 수를 dfs 로 계산하고 최대값을 구하는 식으로 풀었습니다.

    인식한 문제점:
        {"1", "-", "3", "+", "5", "-", "8"} 인자일 경우.
        문제에서 제시한 경우의 수는 5개 이지만,
        위의 방식대로 풀이한다면, 경우의 수가 6개가 됨.
        1-1-1 방식과 3-3-3 방식이 결국 같은 사칙연산을 하기때문.

 */

public class Operation {
    static int MAX_DEPTH;
    static int answer =Integer.MIN_VALUE;
    public static void main(String args[]){
        System.out.println(solution(new String[]{"1", "-", "3", "+", "5", "-", "8"}));
        System.out.println(solution(new String[]{"5", "-", "3", "+", "1", "+", "2", "-", "4"}));
    }
    public static int solution(String arr[]){
        answer=Integer.MIN_VALUE;
        MAX_DEPTH = (arr.length/2);
        dfs(arr,0);
        return answer;
    }
    public static void dfs(String[] arr,int depth){
        if(depth==MAX_DEPTH-1){answer=Math.max(answer,tmp(arr[0],arr[2],arr[1]));return;}

        String[] newArr = new String[arr.length-2];

        for(int i=0; i<arr.length-2; i=i+2){
            Queue<String> q = new LinkedList<>();
            String temp = "";
            temp = String.valueOf(tmp(arr[i],arr[i+2],arr[i+1]));
            for(int j=0; j<arr.length; j++){
                if(j==i){q.add(temp); j+=2;}
                else {q.add(arr[j]);}
            }
            for(int j=0; j<newArr.length; j++){
                newArr[j]=q.poll();
            }
            dfs(newArr,depth+1);
        }
    }

    public static int tmp(String a,String b, String op){
        int na,nb=0;
        na = Integer.parseInt(a);
        nb = Integer.parseInt(b);
        if(op.equals("+")){return na+nb;}
        return na-nb;
    }
}