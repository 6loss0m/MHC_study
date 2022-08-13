package BOJ.BOJ0608;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakePassword_1759_2 {
    static int l,c;
    static char[] newarr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        newarr = new char[c];
        visited = new boolean[c];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++) {
            newarr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(newarr);

        combination(0, 0);
    }
    static void combination(int start,int cnt) {
        if(cnt==l) {
            int v = 0;
            int cc = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<c;i++) {
                if(visited[i]) {
                    sb.append(newarr[i]);

                    if(newarr[i]=='a'||newarr[i]=='e'||newarr[i]=='i'||newarr[i]=='o'||newarr[i]=='u') {
                        v++;
                    }else {
                        cc++;
                    }
                }
            }
            if(v>=1 && cc>=2) System.out.println(sb);
        }
        //백트래킹
        for(int i=start;i<c;i++) {
            visited[i]=true;
            combination(i+1,cnt+1);
            visited[i]=false;
        }
    }
}
