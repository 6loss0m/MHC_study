package BOJ.PS_0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*

    주어진 숫자중 평균 값에 가장 근접한 값을 각각 계산하는식으로 풀어보았지만 풀지 못하고
    검색을 통해
    해당 문제가 중앙값을 찾으라는 문제라는것을 알게되었습니다.

    정렬을 통해 중앙값을 구하였습니다.

 */

public class boj2548_RepresentativeValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[20000];
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for(int i=0;i<N;i++){ arr[i] = Integer.parseInt(input[i]); }

        Arrays.sort(arr,0,N);
        System.out.println(Arrays.toString(arr));
        if(N%2==0){ System.out.println(arr[(N/2)-1]); return;}
        System.out.println(arr[N/2]);

    }
}
