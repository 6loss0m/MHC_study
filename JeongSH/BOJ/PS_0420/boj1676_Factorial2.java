package BOJ.PS_0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    N! 까지의 5의 갯수를 세어주면 됩니다.
    왜냐하면, 2x5를 할때마다 10이 되어 뒤에 0이 하나씩 늘어납니다.
    주의할 점은 5의 제곱수들은 5의 갯수가 하나씩 더 추가되야하기 때문에
    반복문을 통해 N이 5보다 작아질때까지 순회하며 5의 갯수를 세어야합니다.
    ex) 25
    5의 배수 : 5, 10, 15, 20, 25 -> 5개
    하지만 25는 5가 두개이므로 -> 6개가 답입니다.

 */

public class boj1676_Factorial2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ret = 0;
        while (N>=5){
            N/=5;
            ret+=N;
        }
        System.out.println(ret);
    }
}
