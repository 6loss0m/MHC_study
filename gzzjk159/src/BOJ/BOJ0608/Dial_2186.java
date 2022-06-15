package BOJ.BOJ0608;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Dial_2186 {
    static int n,m,k;
    static char[][] dial;
    static char[] word;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int answer = 0;
    static int[][][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dial = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            if (m >= 0) System.arraycopy(input, 0, dial[i], 0, m);
        }
        word = br.readLine().toCharArray();
        check = new int[n][m][word.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(check[i][j], -1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dial[i][j]==word[0]){
                    answer+=dfs(i,j,0);
                }
            }
        }
        System.out.println(answer);
    }
    public static int dfs(int x, int y, int idx){
        if(idx==word.length-1) return check[x][y][idx]=1;
        if(check[x][y][idx]!=-1) return check[x][y][idx];
        check[x][y][idx]=0;
        for(int i=0; i<4; i++) {
            for(int c=1; c<=k; c++) {
                int nx=x+dx[i]*c;
                int ny=y+dy[i]*c;
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(dial[nx][ny]==word[idx+1]) {
                    check[x][y][idx]+=dfs(nx,ny,idx+1);
                }
            }
        }
        return check[x][y][idx];
    }
}
