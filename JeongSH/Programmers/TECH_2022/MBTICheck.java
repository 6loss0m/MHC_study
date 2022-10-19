package TECH_2022;

import java.util.HashMap;
/*
    해시맵을 사용하여
    Hashmap<keyword,score> mbti 를 만들어 사용하였습니다.
    keyword 는 모든 유형을 가지고있고, score 는 keyword 의 점수가 저장됩니다.

    점수를 계산하는 방법은
    (choices[i]-4) 를 한 뒤, 음수면 전자의 유형에 절대값을
                            양수면 후자의 유형에 절대값을 더해줍니다.

    출력은 각 유형별로 점수를 비교하여 출력합니다.

 */

public class MBTICheck{
    public static void main(String[] args) {
        String[] survey={"TR", "RT", "TR"};
        int[] choices={7, 1, 3};

        MBTI mbti = new MBTI();
        for(int i=0;i<survey.length; i++){
            String query = survey[i];
            int score = choices[i];
            mbti.setMbti(query,score);
        }
        System.out.println(mbti.getMbti());

    }
    static class MBTI{
        HashMap<Character,Integer> mbti;

        public MBTI() { mbti = new HashMap<>(); }

        void setMbti(String query, int score){
            char first = query.charAt(0);
            char second = query.charAt(1);
            score -= 4;
            if (score<0) { mbti.put(first,mbti.getOrDefault(first,0)+(score*-1)); }
            else if(score>0) { mbti.put(second,mbti.getOrDefault(second,0)+score); }
        }

        String getMbti(){
            String ret = "";

            int r = mbti.getOrDefault('R',0);
            int t = mbti.getOrDefault('T',0);
            if(r<t){ ret+= "T"; }
            else { ret+="R"; }

            int c = mbti.getOrDefault('C',0);
            int f = mbti.getOrDefault('F',0);
            if(c<f){ ret+= "F"; }
            else { ret+="C"; }

            int j = mbti.getOrDefault('J',0);
            int m = mbti.getOrDefault('M',0);
            if(j<m){ ret+= "M"; }
            else { ret+="J"; }

            int a = mbti.getOrDefault('A',0);
            int n = mbti.getOrDefault('N',0);
            if(a<n){ ret+= "N"; }
            else { ret+="A"; }

            return ret;
        }
    }
}
