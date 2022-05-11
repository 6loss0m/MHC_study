package BOJ.PS_0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    반복된 수열은 특정 숫자부터 시작되게됩니다.
    그러므로,
    list 를 만들어 각 자리의 P 승 만큼한 숫자를 list 에 추가해 줍니다.
    특정 숫자가 이미 list 안에 존재한다면 그 숫자부터 반복이 시작되는것이므로
    해당숫자의 인덱스를 반환해 버리면 반복되지않는 수열의 마지막 인덱스 즉
    하나씩만 존재하는 숫자의 갯수를 알 수 있습니다.

 */

public class boj2331_Permutation2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int P = Integer.parseInt(input[1]);

        list.add(A);
        int prev = A;
        int ret = 0;
        while (true){
            String tmp = String.valueOf(prev);
            int len = tmp.length();
            int n=0;
            for (int i = 0; i < len; i++) {
                n+= Math.pow((double)tmp.charAt(i)-'0', P);
            }
            if(!list.contains(n)) {list.add(n);}
            else { ret = list.indexOf(n); break; }
            prev=n;
        }
        System.out.println(ret);
    }
}
