package BOJ.PS_1123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
    결국 순열을 만드는 문제로 set 을 사용하여 중복된 결과값을 없애면 된다고 생각합니다.

    아이디어
    조합을 만드며 K 개의 카드를 선택했다면 set 에 추가하여 중복을 없앱니다.
    결국 set 크기가 답이됩니다.

 */

public class Card {
    static int N;
    static int K;
    static int[] cards;
    static boolean[] isUse;
    static HashSet<String> set=new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        cards = new int[N];
        isUse = new boolean[N];

        for(int i=0;i<N;i++){ cards[i]=Integer.parseInt(br.readLine());}

        setPerm(0,"");
        System.out.println(set.size());

    }
    static void setPerm(int depth, String strNum){  // 백트래킹으로 구현한 순열
        if(depth == K){
            set.add(strNum);
            return;
        }
        for(int i=0;i<N; i++){
            if(isUse[i]){continue;}
            isUse[i]=true;
            setPerm(depth+1,strNum+cards[i]);
            isUse[i]=false;
        }
    }

}
