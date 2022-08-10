package Programmers.SWCoding2018.SWC2022_07_13;

public class RoadLength {
    static class Solution {
        public int solution(String dirs) {
            int answer = 0;
            boolean[][][] map = new boolean[11][11][4];
            int[] dx = {-1,0,1,0};
            int[] dy = {0,1,0,-1};
            int cx = 5;
            int cy = 5;

            for(int i=0; i<dirs.length(); i++){
                char d = dirs.charAt(i);
                int nx;
                int ny;

                if(d=='U'){
                    nx = cx + dx[0];
                    ny = cy + dy[0];
                    if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                    if(!map[nx][ny][0]) answer++;
                    map[nx][ny][0] = true;
                    map[cx][cy][2] = true;
                }
                else if(d == 'R'){
                    nx = cx + dx[1];
                    ny = cy + dy[1];
                    if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                    if(!map[nx][ny][1]) answer++;
                    map[nx][ny][1] = true;
                    map[cx][cy][3] = true;
                }
                else if(d == 'D'){
                    nx = cx + dx[2];
                    ny = cy + dy[2];
                    if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                    if(!map[nx][ny][2]) answer++;
                    map[nx][ny][2] = true;
                    map[cx][cy][0] = true;
                }
                else{
                    nx = cx + dx[3];
                    ny = cy + dy[3];
                    if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
                    if(!map[nx][ny][3]) answer++;
                    map[nx][ny][3] = true;
                    map[cx][cy][1] = true;
                }
                cx = nx;
                cy = ny;
            }
            return answer;
        }
    }
}
