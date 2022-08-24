package BLIND_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class News {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        Pattern pattern = Pattern.compile("^[a-zA-Z]*$");

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++){
            String sub = str1.substring(i,i+2).toLowerCase();
            if(pattern.matcher(sub).find()){ list1.add(sub); }
        }
        for(int i=0;i<str2.length()-1;i++) {
            String sub = str2.substring(i,i+2).toLowerCase();
            if(pattern.matcher(sub).find()){ list2.add(sub); }
        }
        ArrayList<String> tmp;
        if(list1.size()<list2.size()){ tmp=list1; list1=list2; list2=tmp; }

        boolean[] equal = new boolean[Math.min(list1.size(),list2.size())];
        int intersection = 0;
        Collections.sort(list1);
        Collections.sort(list2);
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size(); j++){
                if(equal[j]){ continue; }
                if(list1.get(i).equals(list2.get(j))){
                    equal[j]=true;
                    intersection++;
                    break;
                }
            }
        }
        double sumSet = list1.size()+list2.size()-intersection;
        if(sumSet==0){ System.out.println(65536);return; }
        double ret = (intersection/sumSet)*65536;

        System.out.println((int)Math.floor(ret));
    }
}
