/*

dfs를 사용하여 풀었습니다.
answer은 depth를 나타냅니다. (N을 몇 번 사용하였는가)
ex) N=5 , number=12    :     answer == depth == 4

 */



public class Nnumber {
    static int n;
    static int target;
    static int answer=Integer.MAX_VALUE;

    public static void main(String args[]){
        int N=5;
        int number=12;
        n=N;
        target=number;
        dfs(0,0);
        if(answer>8){answer=-1;}                                    // Integer.MAX_VALUE 가 나오길래 추가.
        System.out.println(answer);
    }

    static public void dfs(int count, int prev){
        if(count > 8){ answer = -1; return;}                        // depth가 8보다 깊어지면 -1
        if(prev == target){ answer=Math.min(answer,count); return;} // 제한된 depth 안에 target 즉, number 를 찾는 다면
                                                                    // 현재의 depth와 지금까지의 answer후보중 최소값을 비교

        int temp = n;                                               // ex) N = 5 경우 5, 55, 555, 5555 같은 숫자를 구하기위한 digit 역할
        for(int i=0; i<8-count; i++){
            int nextCount = count + i+ 1;                           // 다음 깊이로 들어가기위해
            dfs(nextCount,prev+temp);
            dfs(nextCount,prev-temp);
            dfs(nextCount, prev*temp);
            dfs(nextCount,prev/temp);
            temp = temp*10 + n;                                     // ex) N=5 인경우, 기본 depth는 1
                                                                    // N=5 일 때, 55 는 기본 depth는 2
        }
    }
}
