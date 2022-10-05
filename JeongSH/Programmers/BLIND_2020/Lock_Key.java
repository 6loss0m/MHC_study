package BLIND_2020;
/*
    아이디어를 잡고나서도 구현이 햇갈려서 오래걸린 문제입니다.

    문제 아이디어
    1. 자물쇠의 크기를 3배 확장시키고 가운데에 자물쇠를 둡니다.
    2. 자물쇠[ty][tx] = 열쇠[y][x]*-1 에 넣어 열쇠를 자물쇠에 맞는지 확인합니다.
    3. 맞지않다면 열쇠만 오른쪽으로 90도 돌려줍니다.

    1~3번을 반복.


 */

public class Lock_Key {
    static int[][] map ;
    static int N;       // lock size
    static int M;       // key size

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        N = lock.length;
        M = key.length;
        map = new int[N*3][N*3];

        // lock 을 map 에 복사
        for(int y=0; y<N; y++){
            for(int x=0;x<N;x++){
                map[N+y][N+x]=lock[y][x];
            }
        }

        for(int ny = 0; ny<M+1 ; ny++){
            for(int nx = 0; nx< M+1; nx++){
                int startY = N-(M-1)+ny;
                int startX = N-(M-1)+nx;

                for(int spin=0; spin<4; spin++) {
                    for (int y = 0; y < N; y++) {
                        for (int x = 0; x < N; x++) {

                            if (!isRange(startY + y, startX + x)) { continue; }
                            if (map[startY + y][startX + x] == 1) { continue; }
                            map[startY + y][startX + x] = key[y][x]*-1;
                        }
                    }
                    if(isUnlock()){ System.out.println(true);return;}
                    mapRestore();
                    key = rightSpin(key);
                }
            }
        }

        System.out.println(false);
    }


    static int[][] rightSpin(int[][] key){  //열쇠를 90도 회전
        int[][] newKey = new int[M][M];

        for(int y=0;y<M;y++){
            for(int x=0;x<M;x++){
                newKey[x][M-y-1]=key[y][x];
            }
        }
        return newKey;
    }

    static boolean isUnlock(){      // 열렸는지 확인
        for(int y=0; y<N;y++){
            for(int x=0;x<N;x++){
                if(map[N+y][N+x]==0){ return false;}
            }
        }
        return true;
    }

    static void mapRestore(){       // 자물쇠 복구
        for(int y=0; y<N;y++){
            for(int x=0;x<N;x++){
                if(map[N+y][N+x]==-1){ map[N+y][N+x]=0; }
            }
        }
    }

    static boolean isRange(int y, int x){ return N<=y && y<N+N && N<=x && x<N+N; }
}
