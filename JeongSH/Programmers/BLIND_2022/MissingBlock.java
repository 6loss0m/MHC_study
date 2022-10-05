package BLIND_2022;

public class MissingBlock {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static int N,M;

    public static void main(String[] args) {
        int[][] board={{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc= {1,0};
        int[] bloc= {1,2};

        map = board;
        N = board.length;
        M = board[0].length;
        System.out.println(dfs(aloc[0],aloc[1],bloc[0],bloc[1],0,0).cnt);
    }

    static Result dfs(int ax,int ay , int bx, int by, int aDepth, int bDepth ){
        boolean win = false;
        int winCnt = 25;
        int loseCnt = aDepth+bDepth;

        if(aDepth== bDepth && map[ax][ay]==1){
            for(int i=0;i<4;i++){
                int nx = ax+dx[i];
                int ny = ay+dy[i];
                if(!isRange(nx,ny) && map[nx][ny]==0){ continue; }
                map[ax][ay]=0;
                Result r = dfs(nx,ny,bx,by,aDepth+1,bDepth);
                win = win | !r.isWin;
                if(r.isWin) loseCnt = Math.max(loseCnt,r.cnt);
                else winCnt = Math.min(winCnt,r.cnt);
                map[ax][ay]=1;

            }
        }
        else if(aDepth > bDepth && map[bx][by]==1){
            for(int i=0;i<4;i++){
                int nx = bx+dx[i];
                int ny = by+dy[i];
                if(!isRange(ny,ny)&& map[nx][ny]==0){continue;}
                map[bx][by]=0;
                Result r = dfs(ax,ay,nx,ny,aDepth,bDepth+1);
                win = win | !r.isWin;
                if(r.isWin) loseCnt = Math.max(loseCnt,r.cnt);
                else winCnt = Math.min(winCnt,r.cnt);
                map[bx][by]=1;
            }
        }
        return new Result(win, win ? winCnt:loseCnt);
    }
    static boolean isRange(int x,int y){
        return 0<=x || x<N || 0<=y || y<M ;
    }

    static class Result {
        boolean isWin;
        int cnt;

        public Result(boolean isWin, int cnt) {
            this.isWin = isWin;
            this.cnt = cnt;
        }
    }
}
