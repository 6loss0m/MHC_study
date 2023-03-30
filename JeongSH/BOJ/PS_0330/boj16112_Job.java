package BOJ.PS_0330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *  아이디어
 *  1. N,K 값의 최대값이 10^5 이므로, O(NK) 를 하면 시간초과가 납니다.
 *  2. a(i) 값은 10^8 이르모 long 타입으로 계산을 해야합니다.
 *  3. 계산의 편의를 위하여 오름차순 정렬을 해줍니다.
 *
 *  계산식
 *  sum(arr)*k -{ sum(a(0)) + sum(a(0~1)) + sum(a(0~2))… sum(a(0~k)) }
 *
 */
public class boj16112_Job {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);
        long total = 0;

        inputs = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
            total += arr[i];
        }
        Arrays.sort(arr);

        total *= K;
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
            total -= sum;
        }
        System.out.println(total);
    }
}
