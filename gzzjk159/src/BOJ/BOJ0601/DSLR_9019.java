package BOJ.BOJ0601;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DSLR_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            String[] command = new String[10000];
            boolean[] visited = new boolean[10000];

            Queue<Integer> q = new LinkedList<>();
            visited[a] = true;
            q.add(a);
            Arrays.fill(command, "");
            while(!q.isEmpty() && !visited[b]){
                int now = q.poll();
                int d = (2*now)%10000;
                int s = (now==0) ? 9999 : now -1 ;
                int l = (now%1000)*10 + now/1000;
                int r = (now % 10) *1000 + now/10;

                if (!visited[d]){
                    q.add(d);
                    visited[d]=true;
                    command[d] = command[now] + "D";
                }
                if (!visited[s]){
                    q.add(s);
                    visited[s]=true;
                    command[s] = command[now] + "S";
                }
                if (!visited[l]){
                    q.add(l);
                    visited[l]=true;
                    command[l] = command[now] + "L";
                }
                if (!visited[r]) {
                    q.add(r);
                    visited[r] = true;
                    command[r] = command[now] + "R";
                }
            }
            System.out.println(command[b]);
        }
    }
}
