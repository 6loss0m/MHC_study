package CodeChallenge3;
/*
    1. 쿼리를 역순이라고 생각하고 이동
    2. 결과는 면적.
    3. 벽과 만났을 때 처리

    벽에 부딫히게되면(벽을 초과해서 이동하려고) 목적지에 도착하는 여러 출발점이 생길 수 있습니다.
    ex) 목적지가 별 일 경우.
     * ㅁ ㅁ ㅁ    // 가장 마지막 쿼리가 왼쪽으로 두칸이동 일 때
    ㅁ ㅁ ㅁ ㅁ

     *  *  * ㅁ   // 마지막 전 쿼리때 현재 공의 위치를 표시
    ㅁ ㅁ ㅁ ㅁ

    우리의 목적은 이 조건을 충족하는 직사각형 범위의 왼쪽, 오른쪽, 아래, 위 를 구하여
    넓이를 구하면됩니다.

 */

public class Ball {
    public static void main(String[] args) {
        int n=2;
        int m=2;
        int x=0;
        int y=0;
        int[][] queries = {{2, 1}, {0, 1}, {1, 1}, {0, 1}, {2, 1}};
        long r1=x, r2=x, c1=y, c2=y;    // r:row , c:col , 1: 최소 , 2: 최대
        for(int i=queries.length-1; i>=0 ; i--){
            int dir = queries[i][0];
            int move = queries[i][1];
            if(dir==0){
                // 서
                if(c1>0){ c1+= move; }  // 벽과 맞닿아있지 않으면 c1,c2 둘다 증가
                c2 = Math.min(m-1,c2+move);
            }
            else if(dir==1){
                // 동
                if(c2<m-1){ c2-= move; }
                c1 = Math.max(0,c1-move);
            }
            else if(dir==2){
                // 북
                if(r1>0){ r1 += move; }
                r2 = Math.min(n-1,r2+move);
            }
            else{
                // 남
                if(r2<n-1){ r2-=move; }
                r1 = Math.max(0,r1-move);
            }
            if(r1>=n || r2<0 || c1>=m || c2<0) { System.out.println(0); return ;}   // 과정중에 범위를 넘기게되면 만족할 수 없으므로
        }
        System.out.println((r2-r1+1)*(c2-c1+1));
    }
}
