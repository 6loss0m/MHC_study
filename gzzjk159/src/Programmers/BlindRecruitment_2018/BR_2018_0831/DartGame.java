package Programmers.BlindRecruitment_2018.BR_2018_0831;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[3];
        StringBuilder sb= new StringBuilder();
        int scidx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if(c>='0'&&c<='9'){
                sb.append(c);
            }
            else{
                if(c=='S'||c=='D'||c=='T'){
                    int num = Integer.parseInt(String.valueOf(sb));
                    if(c=='S'){
                        scores[scidx] = num;
                    }
                    else if(c=='D'){
                        scores[scidx] = (int) Math.pow(num,2);
                    }
                    else{   //T일때
                        scores[scidx] = (int) Math.pow(num,3);
                    }
                    sb = new StringBuilder();
                    scidx++;
                }
                if(c=='*'){
                    scores[scidx-1] *=2;
                    if(scidx>1){
                        scores[scidx-2] *= 2;
                    }
                }
                else if(c=='#'){   //#일때
                    scores[scidx-1] *= -1;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            answer += scores[i];
            System.out.print(scores[i]+" ");
        }
        return answer;
    }
    public static void main(String[] args) {
        DartGame dg = new DartGame();
        System.out.println(dg.solution("1S2D*3T"));
        System.out.println(dg.solution("1D2S#10S"));
        System.out.println(dg.solution("1D2S0T"));
        System.out.println(dg.solution("1S*2T*3S"));
        System.out.println(dg.solution("1D#2S*3S"));

    }
}
