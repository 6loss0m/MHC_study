package BLIND_2022;
/*
    단순히 모든 배열에 접근하여 풀이했을 경우
    시간복잡도는 최악의 경우
    1000 * 1000 * 250000 == 250000000000 -> 2500억
    이므로 1초에 약 1억번 계산을 한다고 가정해도 2500 초가 걸립니다.

    풀이법이 떠오르지않아 검색해보니
    누적합을 이용해서 풀었고, 주요개념은
    더할 값을 5 로 정의하면
    시작인덱스 1,  끝인덱스 3
    arr[시작인덱스]+=x , arr[끝인덱스+1]-=x 로 체크합니다.
    {0,0,0,0,0}
    ->
    {0,5,0,0,-5}

    각각 인덱스를 누적합으로 더해줍니다.
    {0,5,5,5,0}

    누적합의 장점은 필요한 곳에만 체크를 해둔 뒤,
    한번의 계산으로 변화량을 구할 수 있습니다.


 */

public class Building {
    public static void main(String[] args) {
        int[][] board={{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] skill={{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}};

        // type(1:적,2:아군)/r1/c1/r2/c2/degree
        int N = board.length;
        int M = board[0].length;
        int[][] sum= new int[N+1][M+1];

        for(int i=0;i<skill.length;i++){
            int degree = skill[i][5];
            if(skill[i][0]==1){ degree*=-1; }
            int r1=skill[i][1];
            int c1=skill[i][2];
            int r2=skill[i][3];
            int c2=skill[i][4];
            sum[r1][c1]+=degree;
            sum[r1][c2+1]-=degree;
            sum[r2+1][c1]-=degree;
            sum[r2+1][c2+1]+=degree;
        }
        for(int i=0;i<=N;i++){          // 가로 누적합
            for(int j=1;j<=M;j++){
                sum[i][j]+=sum[i][j-1];
            }
        }

        for(int i=0;i<=M;i++){          // 세로 누적합
            for(int j=1; j<=N; j++){
                sum[j][i]+=sum[j-1][i];
            }
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M; j++){
                if(board[i][j]+sum[i][j]>0){cnt++;}
            }
        }
        System.out.println(cnt);

    }
}
