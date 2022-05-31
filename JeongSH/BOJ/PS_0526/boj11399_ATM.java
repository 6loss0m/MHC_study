package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    오름차순으로 정렬했을 때, 각각의 사람이 대기하는 시간이 가장 적습니다.
    오름차순으로 정렬한 뒤, 각각 의 대기시간을 더해서 계산합니다.

 */

public class boj11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1000];

        int N = Integer.parseInt(br.readLine());
        String[] input= br.readLine().split(" ");
        for(int i=0;i<N; i++){ arr[i]=Integer.parseInt(input[i]); }

        Arrays.sort(arr,0,N);

        int sum = arr[0];
        for(int i=1;i<N;i++){
            arr[i] = arr[i-1] + arr[i];
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
