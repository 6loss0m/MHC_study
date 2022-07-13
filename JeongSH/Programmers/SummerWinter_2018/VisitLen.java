package SummerWinter_2018;
/*
    풀이 방법이 크게 두가지가 있다고 생각합니다.
    1. 각각 좌표를 기준으로 4방향 방문체크.
    2. 모든 좌표를 두배로 늘려서 2칸씩 이동하며 사이에 낀 좌표를 방문체크.

    2번의 구현이 더 간단할거 같아 2번 방식으로 풀이하였습니다.
 */

public class VisitLen {
    static int[] dx = {1,-1,0,0};   // 동서남북
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        int[][] visit = new int[21][21];    // 맵의 원래크기는 10x10 지만, 두배로 늘려서 구현
        String dirs = "LULLLLLLU";  // 7

        dirs = dirs.replace("R","0");   // R-> 0-> 동
        dirs = dirs.replace("L","1");   // L-> 1-> 서
        dirs =dirs.replace("D","2");    // D-> 2-> 남
        dirs = dirs.replace("U","3");   // U-> 3-> 북
        char[] cmd = dirs.toCharArray();
        int len = cmd.length;

        int x=10;       // 시작좌표는 (10,10) 입니다.  원래는 (5,5)
        int y=10;
        int cnt=0;
        for(int i=0; i<len; i++){
            int dir = cmd[i]-'0';
            int nx = x+dx[dir]*2;
            int ny = y+dy[dir]*2;
            if(0>nx||nx>20||0>ny||ny>20){continue;}

            if(visit[ny-dy[dir]][nx-dx[dir]]==0){   // 이동한 값은 두 배지만, 방문체크는 한칸만 이동한 좌표를 확인해야 합니다.
                cnt+=1;
                visit[ny-dy[dir]][nx-dx[dir]]=1;
            }
            x=nx;
            y=ny;
        }
        System.out.println(cnt);


    }
}
