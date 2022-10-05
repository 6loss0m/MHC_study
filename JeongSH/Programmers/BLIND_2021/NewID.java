package BLIND_2021;

import java.util.Locale;

public class NewID {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        new_id = new_id.toLowerCase();  // 1단계
        new_id = new_id.replaceAll("[^\\w\\-_.]","");   //2단계
        new_id =new_id.replaceAll("\\.{2,}",".");   // 3단계
        new_id =new_id.replaceAll("^[.]|[.]$",""); // 4단계
        if(new_id.length()==0){ new_id="a"; }
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
            new_id =new_id.replaceAll("[.]$",""); // 문자열 마지막에 . 있으면 삭제
        }
        if(new_id.length()<=2){
            String add = ""+new_id.charAt(new_id.length()-1);
            new_id+=add.repeat(3-new_id.length());
        }
        System.out.println(new_id);

    }
}
