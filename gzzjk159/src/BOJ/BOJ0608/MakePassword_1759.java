package BOJ.BOJ0608;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.*;

public class MakePassword_1759 {
    static int max;
    static int n;
    static boolean[] check;
    static String vowels = "aeiou";
    static String temp = "";
    static String ch = "";
    static PriorityQueue<String> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        max = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append(st.nextToken());
        }
        temp = sb.toString();

        for (int i = 0; i < n-max; i++) {
            check = new boolean[n];
            dfs("",0,0,0);
        }
        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.poll());
        }
    }
    public static void dfs(String str, int cnt, int vow, int con){
        char[] sortchar = str.toCharArray();
        Arrays.sort(sortchar);
        String sortstr = new String(sortchar);

        if (cnt==max && vow>0 && con>1){
            if(!pq.contains(sortstr)){
                pq.add(sortstr);
            }
        }
        else if(cnt<max){
            for (int i = cnt; i < n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    ch = Character.toString(temp.charAt(i));
                    if (vowels.contains(ch)) {
                        dfs(sortstr + ch, cnt + 1, vow + 1, con);
                    } else {
                        dfs(sortstr + ch, cnt + 1, vow, con + 1);
                    }
                    check[i] = false;
                }
            }
        }
    }
}
