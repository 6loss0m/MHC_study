package Programmers.SWCoding2018.SWC2022_07_20;

import java.util.HashSet;

public class Endtalk {
    static HashSet<String> one = new HashSet<>();
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int idx = 0;
        while(idx < words.length){
            if(idx==0){
                Overlap(idx,words);
                idx++;
            }
            else{
                if(Overlap(idx,words)){
                    if(Correctcheck(idx,words)){
                        idx++;
                    }
                    else{
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
        if (idx != words.length) {
            answer[0] = idx % n + 1;
            answer[1] = idx / n + 1;
        }
        return answer;
    }
    public boolean Correctcheck(int idx, String[] words){
        int len = words[idx-1].length();
        char frontLast = words[idx-1].charAt(len-1);
        char nextFirst = words[idx].charAt(0);
        return frontLast == nextFirst;
    }

    public boolean Overlap(int idx, String[] words){
        if(!one.contains(words[idx])){
            one.add(words[idx]);
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Endtalk ed = new Endtalk();
        int[] arr;
        arr = ed.solution(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        int[] arr2;
        arr2 = ed.solution(5,new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
        int[] arr3;
        arr3 = ed.solution(2,new String[]{"hello", "one", "even", "never", "now", "world", "draw"});

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr3[0]);
        System.out.println(arr3[1]);
    }
}