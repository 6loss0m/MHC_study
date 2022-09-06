package Programmers.BlindRecruitment_2018;

import java.util.ArrayList;
import java.util.Collections;

public class NewsClustering {
    static ArrayList<String> union = new ArrayList<>();
    static ArrayList<String> intersection = new ArrayList<>();
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        ArrayList list1 = set(str1);
        ArrayList list2 = set(str2);
        Collections.sort(list1);
        Collections.sort(list2);
        for(Object s: list1){
            if(list2.remove(s)){
                intersection.add((String) s);
            }
            union.add((String) s);
        }
        for(Object s: list2){
            union.add((String) s);
        }
        double jakard;
        if(union.size()==0){
            jakard = 1;
        }
        else{
            jakard = (double)intersection.size()/(double) union.size();
        }
        return (int)(jakard*65536);
    }
    public static ArrayList set(String str){
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i)<'a'||str.charAt(i)>'z'||str.charAt(i+1)<'a'||str.charAt(i+1)>'z'){
                continue;
            }
            String sb = String.valueOf(str.charAt(i)) + str.charAt(i + 1);
            list.add(sb);
        }
        return list;
    }
    public static void main(String[] args) {
        NewsClustering nc = new NewsClustering();
        System.out.println(nc.solution("aa1+aa2","AAAA12"));
    }
}
