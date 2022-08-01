package CodeChallenge1_2;

public class CountEven {
    static final int MOD=  10000019;
    static long[][] nCr;
    static int[][] map;
    static int[] arrOneCnt;

    public static void main(String[] args) {
        int[][] a= {{0, 1, 0}, {1, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        map=a;
        nCr = new long [a.length+1][a.length+1];
        arrOneCnt = new int[a.length];
        int row = a.length;
        int col = a[0].length;
        CalCombination(row);
        CalOneCnt();
        long[][] dp = new long[row+2][col+2];
        dp[1][row-arrOneCnt[0]]=nCr[row][row-arrOneCnt[0]];
        for(int c=1; c<col;c++){
            int OneCnt = arrOneCnt[c];;
            for(int evenNum=0;evenNum<=row;evenNum++){
                if(dp[c][evenNum]==0)continue;
                for(int k=0;k<=OneCnt;k++){
                    if(evenNum<k)continue;
                    int beEvenRow = evenNum+OneCnt-(2*k);
                    if(beEvenRow>row)continue;
                    long result = (nCr[evenNum][k]*nCr[row-evenNum][OneCnt-k])%MOD;
                    dp[col+1][beEvenRow]= (dp[col+1][beEvenRow]+dp[col][evenNum]*result);
                    dp[col+1][beEvenRow]%=MOD;
                }
            }
        }
        System.out.println(dp[row][col]);
    }
    static void CalCombination(int row){
        nCr[0][0]=1;
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row; j++){
                if(j==0) nCr[i][j]=1;
                else if(i==j) nCr[i][j]=1;
                else nCr[i][j]=nCr[i-1][j-1]+nCr[i-1][j];
                nCr[i][j]%= MOD;
            }
        }
    }

    static void CalOneCnt(){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                arrOneCnt[j]+=map[i][j];
            }
        }
    }

    static class nCr{
        int[][] V;
        public nCr(int row) { V = new int[row+1][row+1]; }
    }
}
