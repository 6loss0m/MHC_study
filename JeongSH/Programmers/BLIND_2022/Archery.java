package BLIND_2022;

import java.util.Arrays;
/*
    활을 쏘는 효율로 접근했지만, 점수를 뺏을 수 있다는 점에서 계산이 어려워
    완전탐색을 사용하여 풀이하였습니다.
    선택지는 해당 점수를
    0발 ,  어피치+1발  이 두가지 경우만 존재합니다.
    dfs, 백트래킹을 사용하여 각각의 점수를 0 or 어피치+1 발을 맞춘것을 기준으로 순회를 하였습니다. 

 */

public class Archery {
    static int[] scores;
    static int[] infos;
    static int[] ret;
    static int maxScore=0;

    public static void main(String[] args) {
        int n=5;
        int[] info={2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        infos = info;
        scores = new int[11];
        ret = new int[11];

        int score = 0;
        for(int i=0;i<info.length;i++){ score+= info[i]>0 ? (10-i):0; } // 점수의 '차이' 를 계산하기 위해 어피치의 점수를 미리 계산
        dfs(0,n,-score);    // 어치피의 점수는 - 로 들어가야 합니다.
        if(maxScore==0){
            return;
        }
        System.out.println(Arrays.toString(ret));
    }
    static void dfs(int now,int arrow, int score){
        if(arrow<=0 || now>=10){
            if(arrow>0){ scores[10]=arrow; }    // 화살이 남았을경우 0점에 전부 쏘기
            if(score>maxScore){ maxScore = score; ret = scores.clone(); return;}    // 기존 점수보다 크면 무조건 해당 값이 답이됩니다.
            else if(score == maxScore) { ret = getRowScoreMore().clone(); }         // 기존 점수와 같을 경우에는 낮은점수를 많이 맞춰야 합니다.
            scores[10]=0;       // 하나의 결과가 끝났으므로 남은화살 0에 쏜거 회수
            return;
        }

        dfs(now+1, arrow, score);   // 쏘지않을 경우

        if(arrow-infos[now]-1 >= 0){    // 화살이 남아 어피치보다 1발 더 쏠수 있는 경우
            int tmp = 10-now;
            if(infos[now]>0){ tmp+=tmp; }   // 어피치가 이미 한발이상을 쐈을경우 어피치 점수를 뺏을 수 있으므로 점수의 차이가 2배로 오름
            scores[now]=infos[now]+1;
            dfs(now+1,arrow-infos[now]-1, score+tmp);
            scores[now]=0;                  // 해당 순회가 끝났으므로 다시 회수 백트래킹
        }
    }
    static int[] getRowScoreMore(){     // 낮은 점수를 많이 맞춘 배열을 반환
        for(int i=10; i>=0 ;i--){
            if(ret[i]==scores[i]){continue; }
            if(ret[i]>scores[i]){ return ret;}
            else{ return scores; }
        }
        return null;
    }
}
