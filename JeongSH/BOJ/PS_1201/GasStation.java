package BOJ.PS_1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    아이디어
    지금까지 들른 주유소 중에 가장 낮은 가격의 주유소를 이용하게합니다.
    주유소에서 기름을 채우는 조건을 생각해보면

    1. 지금까지 들른 주유소보다 다음 주유소가 쌀경우.
        a. 현재까지 들른 주유소 중에 가장 싼곳에서 기름을 채웁니다.
        b. 가장 싼 주유소를 최신화 합니다.

    2. 지금까지 들른 주유소보다 다음 주유소가 비쌀경우.
        a. 현재까지 들른 주유소 중에 가장 싼곳에서 기름을 채웁니다.

    입력제한이 int 값을 넘으므로 long 으로 계산합니다.

    테스트케이스
    5
    4 4 3 1
    5 4 3 2 1
    : 각 주유소마다 주유하는 케이스

    테스트케이스
    5
    4 4 3 1
    1 2 3 4 5
    : 첫 주유소에서 다 채우기
 */

public class GasStation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dist=new long[N];
        long[] cost=new long[N];

        String[] in = br.readLine().split(" ");
        for(int i=1;i<N;i++){ dist[i]=Long.parseLong(in[i-1]); }
        in = br.readLine().split(" ");
        for(int i=0;i<N;i++){ cost[i]=Long.parseLong(in[i]); }

        long smallest=cost[0];  // 첫 주유소에서는 무조건 채워야 합니다.
        long total = 0;
        for(int i=1;i<N;i++){
            if(smallest > cost[i-1]) {smallest = cost[i-1];}    // 더 싼 주유소가 있다면 최신화
            total = total + smallest*dist[i];
        }
        System.out.println(total);
    }
}
