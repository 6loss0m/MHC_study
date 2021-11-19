/*
    점화식
    dp[i]는 i 까지 턴 돈의 최댓값.
    dp[i]=max(dp[i-2]+money[i],dp[i-1])

    이 문제는 크게 두가지로 나누어서 볼 수 있다.
    무조건 0번째 집을 털경우,(마지막 집은 못 텀.)
    무조건 0번째 집을 안 털경우.

 */
public class Thievery {
    public static void main(String args[]){
        int[] money = {1,2,3,1};
        int answer=0;
        int N = money.length;
        int[] dpFirstDo = new int[N];
        int[] dpFirstNot = new int [N];

        //0번째 집을 털 경우.
        dpFirstDo[0]=money[0];
        dpFirstDo[1]=Math.max(dpFirstDo[0],dpFirstDo[1]);
        
        //0번째 집을 안 털 경우
        dpFirstNot[0]=0;
        dpFirstNot[1]=money[1];
        
        for(int i=2;i<N; i++){
            dpFirstNot[i]=Math.max(dpFirstNot[i-2]+money[i],dpFirstNot[i-1]); // 0번째집을 안터는 경우 
            if(i==N-1) break;
            dpFirstDo[i]=Math.max(dpFirstDo[i-2]+money[i],dpFirstDo[i-1]);    // 0번째 집을 터는경우엔 마지막 집을 못 털기때문에 마지막 집 전에서 break
        }
        answer = Math.max(dpFirstDo[N-2],dpFirstNot[N-1]);                    // 0번째 집을 턴 경우에는 마지막 집을 못 털기 때문에 N-2 와
                                                                              // 0번째 집을 안 턴 경우엔 마지막 집까지 털었으므로 N-1 비교
        

        System.out.println(answer);
    }
}