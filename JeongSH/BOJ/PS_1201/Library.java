package BOJ.PS_1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    접근방법
    어느지점을 선택해서 올리건 가장 큰 수는 맨위로 올릴 필요가없습니다.
    가장 큰 수를 기준해서 위로 탐색했을 때, 1씩 감소하는 숫자는 따로 정렬할 필요가 없습니다.
    ex) 5 3 2 6 1 7 -> 5,6,7 은 정렬할 필요가 없습니다.
    즉 가장 큰 수를 기준으로 위로 탐색하며 가장 긴 감소 수열을 전체 크기에서 빼주면됩니다.

    구현은 쉽지만 아이디어 접근까지 올래걸리는 문제같습니다.
    질문하기글을 참고하였습니다..

 */

public class Library {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int maxIdx = -1;
        int maxNum = -1;
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(br.readLine());
            if(maxNum < arr[i]){ maxNum=arr[i]; maxIdx=i; }
        }
        int cnt = 1;
        for(int i=maxIdx; i>=1; i--){
            if(maxNum-1 == arr[i-1]){ maxNum = arr[i-1]; cnt++; }
        }
        System.out.println(N-cnt);
    }
}
