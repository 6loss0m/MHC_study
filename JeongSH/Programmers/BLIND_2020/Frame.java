package BLIND_2020;

import java.util.Arrays;
/*
    구현하기 까다로운 문제였습니다.
    그림과 달리 배열로 옮기게되면 옆으로 돌아가게되어 많이 햇갈려서
    x,y 값을 반대라고 생각하고 풀이하였습니다.

    삭제명령
        1. 일단 삭제를 합니다.
        2. 삭제를 한 뒤 구조물에 이상이없다면 끝냅니다.
        3. 삭제를 한 뒤 구조물에 이상이 있다면 복구합니다.

    건설명령
        1. 건설 할 수 있는지 체크합니다.
        2. 걸설 할 수 있다면 건설합니다.

    건설할 오브젝트의 갯수를 미리파악해두면
    마지막에 건설한 오브젝트들을 반환할때 몇개의 오브젝트를 담아야하는지 알기 쉽습니다.

 */

public class Frame{
    static boolean[][] pillar;
    static boolean[][] bo;

    public static void main(String[] args) {
        int n=5;
        int[][] build_frame={{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1},
                {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        int obj = 0;
        pillar = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];

        for(int[] cmd : build_frame){
            int x=cmd[0];
            int y=cmd[1];
            int type = cmd[2];
            int action = cmd[3];

            if(action==0){  //삭제
                if(type==0){    // 기둥
                    pillar[x][y]=false;
                    if(checkAll(n)){ obj--; }
                    else{ pillar[x][y]= true; }     // 복구
                }
                else{       // 보
                    bo[x][y]=false;
                    if(checkAll(n)){ obj--; }
                    else { bo[x][y]= true; }    // 복구
                }
            }

            else{   // 건설
                if(type==0){        // 기둥
                    if(checkPillar(x,y,n)){ pillar[x][y]=true; obj++; }
                }
                else{       // 보
                    if(checkBo(x,y,n)){ bo[x][y]=true; obj++; }
                }
            }
        }

        int[][] ret = new int[obj][3];
        int idx=0;
        for(int x=0; x<=n; x++){
            for(int y=0; y<=n; y++){
                if(pillar[x][y]){
                    ret[idx][0]=x;
                    ret[idx][1]=y;
                    ret[idx][2]=0;
                    idx++;
                }
                if(bo[x][y]){
                    ret[idx][0]=x;
                    ret[idx][1]=y;
                    ret[idx][2]=1;
                    idx++;
                }
            }
        }
        for(int arr[] : ret){
            System.out.println(Arrays.toString(arr));
        }

    }
    static boolean checkAll(int n) {    // 기둥, 보 둘 다 체크
        for(int x=0 ; x<=n ; x++) {
            for(int y=0 ; y<=n ; y++) {
                if(pillar[x][y]) {
                    if(!checkPillar(x, y, n)) return false;
                }
                if(bo[x][y]) {
                    if(!checkBo(x, y, n)) return false;
                }
            }
        }
        return true;
    }

    static boolean checkPillar(int x, int y, int n) {       // 기둥 체크
        if(y==0) {return true;} // 바닥

        if(pillar[x][y-1]) {return true;} // 기둥위

        if((x-1>=0 && bo[x-1][y]) || bo[x][y]) {return true;} // 보의 끝부분 위치
        return false;
    }

    static boolean checkBo(int x, int y, int n) {       // 보 체크
        if(x+1<=n && pillar[x+1][y-1]) { return true; } // 기둥의 끝부분 위치

        if(pillar[x][y-1]) { return true; } // 기둥의 시작부분 위치

        if(x-1>=0 && x+1<=n && bo[x-1][y] && bo[x+1][y]) { return true; } // 양 옆 보 위치
        return false;
    }
}
