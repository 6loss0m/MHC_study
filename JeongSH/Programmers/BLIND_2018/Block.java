package BLIND_2018;
/*
    구현문제입니다.
    삭제는 일괄적으로 이루어져야하기때문에, 삭제할 수 있는 블록을 바로 삭제하지않고 체크만 해두고
    삭제는 일괄적으로 한 뒤, 한칸씩 밑으로 내려주어야합니다.

    순서
    1. 삭제할 수 있는 모든 블록들을 체크만 해둡니다.
    2. 체크된 블럭을 모두 삭제합니다.
    3. 빈공간이 있다면 밑으로 내려줍니다.

 */

public class Block {
    static char[][] map;
    static boolean[][] del;
    public static void main(String[] args) {
        int m=6;
        int n=6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        map = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j]=board[i].charAt(j);
            }
        }

        int ret = 0;
        while (true){
            search(m,n);                // 삭제할 수 있는 블록을 체크만
            int cnt = delete(m,n);      // 삭제한고 삭제한 갯수를 반환
            if(cnt==0){ break; }        // 삭제한게 없다면 끝
            ret+=cnt;
            drop(m,n);                  // 아래로 내려줍니다.
        }
        System.out.println(ret);


    }
    static void search(int m, int n){
        // 현재 블록기준 왼쪽 위방향으로 4개가 같은지 확인
        del= new boolean[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char now = map[i][j];
                if(now==' '){ continue; }
                if(map[i][j-1]==now && map[i-1][j]==now && map[i-1][j-1]==now){
                    del[i][j]=true;
                    del[i][j-1]=true;
                    del[i-1][j]=true;
                    del[i-1][j-1]=true;
                }
            }
        }
    }
    static int delete(int m, int n){
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(del[i][j]){
                    count++;
                    map[i][j]=' ';
                }
            }
        }
        return count;
    }
    static void drop(int m, int n){
        for(int i=m-1; i>0; i--){
            for(int j=0; j<n; j++){
                if(map[i][j]==' '){
                    for(int k=i-1; k>=0; k--){
                        if(map[k][j]!=' '){
                            map[i][j]=map[k][j];
                            map[k][j]=' ';
                            break;
                        }
                    }
                }
            }
        }
    }
}
