package BOJ.BOJ0601;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class Waterbottle_2251 {
    static boolean[][] check;
    static int[] max;
    static Set<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = new int[3];
        check = new boolean[201][201];
        for (int i = 0; i < 3; i++) {
            max[i] = Integer.parseInt(st.nextToken());
        }
        answer = new TreeSet<>();
        move(0,0,max[2]);
        for (int num : answer){
            System.out.println(num+" ");
        }
    }
    public static void move(int a, int b, int c) {
        if (check[a][b]) return;

        if (a == 0) {
            answer.add(c);
        }
        check[a][b] = true;
        // a -> b
        if (a + b > max[1]) {
            move((a + b) - max[1], max[1], c);
        } else {
            move(0, a + b, c);
        }
        // b -> a
        if (a + b > max[0]) {
            move(max[0],(a+b)-max[0], c);
        } else {
            move(a+b, 0, c);
        }
        // c -> a
        if (a + c > max[0]) {
            move(max[0], b, a+c-max[0]);
        } else {
            move(a+c, b, 0);
        }
        // c -> b
        if (b+c > max[1]) {
            move(a, max[1], b+c-max[1]);
        }
        else {
            move(a, b+c, 0);
        }
        // b -> c
        move(a,0,b+c);
        // a -> c
        move(0,b,a+c);
    }
}
