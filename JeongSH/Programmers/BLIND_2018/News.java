package BLIND_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
/*
    1. 문자열을 조건에 맞춰 2개씩 잘라 배열을 만들어 줍니다.
    2. 두 배열의 교집합을 찾기위해 배열을 정렬해줍니다.
    3. 두 배열에서 교집합의 수를 찾아줍니다.

    유사도 = n(A ∪ B)/n(A ∩ B)
    n(A ∪ B) = n(A)+n(B)-n(A ∩ B)

    결과값에 65536 를 곱한 값을 반환합니다.
    하지만, 합집합 즉 분모가 0이되면 계산할 수 없으므로 65536 를 반환합니다.

 */

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
