/*

    무지성 dfs 풀이법. 정확성 모두 통과 효율성 모두 시간초과
    이유: worst-case dfs 시간복잡도.
    모든 길을 전부 들어가서 answer 값을 ++ 하는 방식.

    시간복잡도:T(n) = O(V+E)

 */
public class RoadToSchool {
    static int DIV_VALUE = 1000000007;
    static int answer=0;
    public static void main(String args[]){
        int m=4;
        int n=3;
        int[][] puddles = {{2,2}};
        dfs(puddles,m,n,0,0);
        System.out.println(answer);
    }
    public static void dfs (int[][] puddle , int targetX, int targetY, int nowX,int nowY){
        if(nowX==targetX-1 && nowY==targetY-1){ answer=(answer+1)%DIV_VALUE;return;}    // 목적지에 도달한 경우이므로 answer+1

        if(nowX>= targetX || nowY >= targetY) {return;}                                 // 목적지를 넘어선 경우. 맵을 넘어감

        for(int i=0; i<puddle.length; i++){
            if(nowX == (puddle[i][0]-1) && nowY == (puddle[i][1]-1)) { return; }        // puddle을 만남.
        }

        dfs(puddle,targetX,targetY,nowX+1,nowY);                                 // 위의 경우가 아닌경우 x+1
        dfs(puddle,targetX,targetY,nowX,nowY+1);                                 // 위의 경우가 아닌경우 y+1
    }
}
