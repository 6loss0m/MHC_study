package CodeChallenge3;
/*
    이분탐색을 사용하였습니다.
    미리 시간을 설정해놓고 (mid)
    이 시간내에 옮길 수 있는 금,은 양을 확인합니다.

    1. 총 옮길수 있는 양 구하기.
    운행에 걸리는 시간은 편도로 주어지기때문에
    mid/(왕복시간) 을 통해 총 몇번을 왕복하는지 알아내고,
    mid%왕복시간 > 편도 라면
        -> n왕복 + 1편도 가 가능한지 알 수 있습니다.
    이를 통해 총 옮길 수 있는 양을 구할 수 있습니다.

    2. 총 옮길 수 있는 금,은,전체 광물 양을 계산.
    ex) a=40, b=40
    옮길 수 있는 금의양 : 40
    옮길 수 있는 은의양 : 40
    옮길 수 있는 전체광물양 : 40

    각각의 a,b는 충족하지만 a+b 즉 전체 광물양은 80이기때문에 위의 예는 옮길 수 없습니다.
    그러므로, 옮긴 전체 광물의 양이 a+b 를 충족하는지도 확인해야 합니다.

 */
public class Gold_Silver {
    public static void main(String[] args) {
        int a=90;  // 금
        int b=500;  // 은
        int[] g={70,70,0};    // 금
        int[] s={0,0,500};    // 은
        int[] w={100,100,2};    // 적재량
        int[] t={4,8,1};    // 편도 시간

        int len = g.length;

        int max=0;
        for(int n: t){ if(max<n){max=n;} }

        long start=0;
        long end= (long)(a+b)*(long)max*2;
        long ret=end;

        while(end>=start){
            long mid = (start+end)/2;
            long totalGold = 0;
            long totalSilver = 0;
            long total = 0;
            for(int i=0; i<len;i++){
                long time = t[i];
                long roundTime = time*2;    // 왕복시간
                long moveCnt = mid/roundTime;  // 주어진 시간 / 왕복시간 -> 몇번 왕복하는지
                if(mid%roundTime >= time){ moveCnt+=1; }   // 왕복운행이후 마지막 편도로 운반하는 경우.
                long maxTotal = w[i] * moveCnt;   // 최대한 가져갈 수 있는 G+S 양

                totalGold += Math.min(g[i], maxTotal);
                totalSilver += Math.min(s[i], maxTotal);
                total += Math.min(g[i]+s[i],maxTotal);  // 옮긴 총 광물의 양이 a+b를 충족하는지 알기위해
            }
            boolean isPossible = false;
            if(totalGold >= a && totalSilver>=b && total >= a+b){ isPossible = true; }

            if(isPossible){ ret = Math.min(ret,mid);end = mid-1; }
            else{ start = mid+1;}
        }
        System.out.println(ret);

    }
}
