package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
    HashMap 을 사용하여 문제를 풀었습니다.
    주어진 카드를 맵에 넣고 상근이가 카드를 가지고있으면 1 을 없으면 0을 반환합니다.

    이분탐색으로 풀이해보면,
    상근이의 카드와 주어진카드를 전부 정렬한 뒤,
    주어진카드[n]를 보고 상근이의 카드를 이분탐색하여 돌립니다. (탐색을 할때, 마지막으로 탐색한 인덱스 m)
    주어진카드[n+1]을 보고 아까 마지막으로 탐색한 인덱스 m+1 부터 탐색을 시작합니다. (오름차순으로 정렬했기때문에 )
    시간복잡도 :
    정렬 : nlogn
    이분탐색 : logn

    만약 카드가 이미 정렬되어있다면 Map(딕셔너리) 을 사용하는것보다 이분탐색을 사용하는 것이 더 빠릅니다.

 */

public class boj10815_Card {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int[] sang = new int[500000];
        int[] result = new int[500000];

        HashMap<Integer,Integer> map = new HashMap<>();
        String[] input;
        int N = Integer.parseInt(br.readLine());
        input=br.readLine().split(" ");
        for(int i=0;i<N;i++){ sang[i]=Integer.parseInt(input[i]); }
        int M = Integer.parseInt(br.readLine());
        input=br.readLine().split(" ");
        for(int i=0;i<M;i++){ map.put(Integer.parseInt(input[i]),i);}

        for(int i=0;i<N;i++){
            if(map.get(sang[i])!=null){ result[map.get(sang[i])]=1;  }
        }
        for(int i=0;i<M;i++){ sb.append(result[i]).append(" "); }
        System.out.println(sb);
    }
}
