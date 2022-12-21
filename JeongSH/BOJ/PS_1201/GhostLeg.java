package BOJ.PS_1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
    아이디어
    사다리타기를 계속 해보니 가로줄 하나는 인접한 두 수만 바꾼다는것을 알게되었습니다.
    결국 인접한 두 수를 swap 하여 오름차순으로 정렬하는것으로 문제를 바꾸어 볼 수 있습니다.
    인접한 두 수를 비교하여 자리를 바꿔 정렬하는것을 보자
    버블소트가 떠올라 버블 소트로 swap 을 할때마다 cnt++ 해주어 문제를 풀었습니다.

    문제가 버블소트라는 걸 파악하는게 문제의 중요한 부분이라고 생각합니다.

 */

public class GhostLeg {
    static int[] arr= new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T;t++){
            int N = Integer.parseInt(br.readLine());
            Arrays.fill(arr,0);
            String[] input = br.readLine().split(" ");
            for(int i=0;i<N;i++){ arr[i]=Integer.parseInt(input[i]); }

            int cnt=0;

            for(int i=0;i<N-1;i++){
                for(int j=1;j<N-i;j++){
                    if(arr[j-1]>arr[j]){ swap(j-1,j); cnt++; }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static void swap(int idx1 , int idx2){
        int a = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = a;
    }

}
