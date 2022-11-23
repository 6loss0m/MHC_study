package BOJ.PS_1123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/*
    조합 문제라고 생각합니다.
    입력값의 제한이적어 모든 조합을 만들어가면서 맛없는 조합이 포함된다면 추가하지않습니다.
    O(n^3) 이며 contain 은 O(1) 의 시간복잡도를 가집니다.

    아이디어
    3개의 조합으로 고정이기때문에 간단하게 3중 for 문을 돌리면서 i,j / j,k / i,k 를 조합했을때
    맛없는 조합이 포함된다면 추가하지않습니다.

 */

public class IceCream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for (int i = 0; i < M; i++) {
            String[] in = br.readLine().split(" ");
            set.add(Integer.parseInt(in[0]) < Integer.parseInt(in[1]) ?
                    in[0] + " " + in[1] : in[1] + " " + in[0]);
        }

        for(int i=1;i<=N;i++){          // 3중 for 문으로 구현한 조합
            for(int j=i+1; j<=N; j++){
                if(set.contains(i+" "+j)){continue;}
                for(int k=j+1; k<=N; k++){
                    if(set.contains(i+" "+k)){continue;}
                    if(set.contains(j+" "+k)){continue;}
                    list.add(i+"/"+j+"/"+k);
                }
            }
        }
        System.out.println(list.size());
    }

}
