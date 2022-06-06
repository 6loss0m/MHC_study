package BOJ.PS_0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    문제 이름이 버블소트지만 버블소트로 풀면 시간초과가 납니다.

    버블소트의 swap 특징은 기준 원소뒤에 기준 원소보다 작은 수가 있다면 swap 이 발생합니다.
    이는 머지소트의 병합과정에서 분할된 배열의 오른쪽 원소가 왼쪽으로 합병될 때와 같다고 합니다.

    1 5 / 2 3  으로 분할 된 배열이 정렬될 때
    왼쪽 배열의 l 인덱스와
    오른쪽 배열릐 r 인덱스를 봤을때

    1. l 인덱스에서 1을 가져와서 정렬. [1]
    2. r 인덱스에서 2를 가져와서 정렬. [1,2]
        이 때 2의 병합과정에서 2의 인덱스는 원소5 인덱스보다 뒤에 있므로,
        왼쪽 배열의 남은크기 만큼의 스왑이 발생합니다. 총 1회
    3. r 인덱스에서 3을 가져와서 정렬. [1,2,3]
        2의 과정과 마찬가지로 왼쪽 배열의 남은 크기만큼의 스왑이 발생한다고 볼 수 있습니다. 총 2회
    4. l 나머지 5를 가져와서 정렬. [1,2,3,5]

 */

public class boj1517_BubbleSort {
    static int[] arr = new int[500001];
    static int[] tmp = new int[500001];
    static long ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input =br.readLine().split(" ");
        for(int i=0;i<N;i++){ arr[i]=Integer.parseInt(input[i]); }

        mergesort(0,N-1);
        System.out.println(ret);
    }

    static void merge(int start, int end){
        int mid = (start+end)/2;
        int i = start;
        int j = mid+1;
        int k=0;

        while (i<=mid && j<=end){
            if(arr[i]<=arr[j]){ tmp[k++]= arr[i++]; }
            else{
                tmp[k++] = arr[j++];
                ret += (long) (mid-i+1);    // 왼쪽 원소의 개수
            }
        }

        while (i<=mid) tmp[k++] = arr[i++];
        while (j<=end) tmp[k++] = arr[j++];

        for(int l=start; l<=end; l++){
            arr[l]=tmp[l-start];
        }
    }

    static void mergesort(int start, int end){
        if(start>=end) return;
        int mid = (start+end)/2;
        mergesort(start,mid);
        mergesort(mid+1, end);
        merge(start,end);
    }
}
