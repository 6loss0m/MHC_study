package BOJ.PS_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
    N 이 100 밖에 되지않으므로
    자신의 차례때마다 모든 카드를 보더라도
    100 * 100 * 2
    약 2만정도만 확인하기때문에 모든 카드를 탐색하게 구현하였습니다.

    상근이와 근상이 둘 중 하나라도 먼저 카드가 0이되면
    다음 사람은 진행하지않고 게임이 끝난다가는 것만 생각해서
    구현하였습니다

 */

public class boj5587_Card {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] card = new int[201];
        int N = Integer.parseInt(br.readLine());
        int maxCard = N * 2;

        for (int i = 1; i <= N; i++) {
            int in = Integer.parseInt(br.readLine());
            card[in] = 1;
        }

        ArrayList<Integer> sang = new ArrayList<>();
        ArrayList<Integer> geun = new ArrayList<>();
        for (int i = 1; i <= maxCard; i++) {
            if(card[i]==1){ sang.add(i); }
            else{ geun.add(i); }
        }

        int now = 0;
        while (!sang.isEmpty() && !geun.isEmpty()){
            boolean notCard = true;
            for (int i = 0; i < sang.size(); i++) {
                if(now<sang.get(i)){ now = sang.get(i); sang.remove(i); notCard= false; break; }
            }
            if(notCard){ now = 0;}
            if(sang.isEmpty()){break;}

            notCard = true;
            for (int i = 0; i < geun.size(); i++) {
                if(now<geun.get(i)){ now = geun.get(i); geun.remove(i); notCard= false; break; }
            }
            if(notCard){ now = 0; }
            if(geun.isEmpty()){break;}
        }
        System.out.println(geun.size());
        System.out.println(sang.size());

    }
}