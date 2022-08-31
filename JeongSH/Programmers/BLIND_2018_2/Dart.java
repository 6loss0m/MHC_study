package BLIND_2018_2;

import java.util.ArrayList;
import java.util.Stack;

public class Dart {
    public static void main(String[] args) {
        String dartResult="1D2S0T";
        ArrayList<Play> plays = new ArrayList<>();

        for(int i=0;i<dartResult.length();i+=3){
            int score = dartResult.charAt(i)-'0';
            char squared = dartResult.charAt(i+1);
            if(squared=='0'){ score=10; squared= dartResult.charAt(i+2); i++; }
            if(i+2==dartResult.length()){ plays.add(new Play(score,squared)); break;}
            char option = dartResult.charAt(i+2);

            if('0'<= option && option<='9'){ plays.add(new Play(score,squared));i--; }
            else{ plays.add(new Play(score,squared,option)); }
        }

        Stack<Integer> stack = new Stack<>();
        for(Play p: plays){
            int score = p.score;
            int squared = p.squared;
            char option = p.option;
            if(squared=='D'){ score = score * score; }
            if(squared=='T'){ score = score * score * score; }

            if(option=='*'){
                if(!stack.isEmpty()){ stack.add(stack.pop()*2); score*=2; }
                else{ score*=2; }
            }
            else if(option=='#'){ score*=-1; }
            stack.add(score);
        }
        int ret = 0;
        while (!stack.isEmpty()){ ret+=stack.pop(); }
        System.out.println(ret);
    }
    static class Play{
        int score;
        char squared;
        char option;

        public Play(int score, char squared) {
            this.score = score;
            this.squared = squared;
            option ='x';
        }

        public Play(int score, char squared, char option) {
            this.score = score;
            this.squared = squared;
            this.option = option;
        }
    }
}
