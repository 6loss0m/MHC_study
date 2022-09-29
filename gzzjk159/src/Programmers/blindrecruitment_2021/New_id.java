package Programmers.blindrecruitment_2021;

public class New_id {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]","");
        new_id = new_id.replaceAll("\\.{2,}", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        if (new_id.length()==0){
            new_id = "a";
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        new_id = new_id.replaceAll("[.]$", "");
        if (new_id.length()<=2) {
            char c = new_id.charAt(new_id.length()-1);
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while(new_idBuilder.length()<3) {
                new_idBuilder.append(c);
            }
            new_id = new_idBuilder.toString();
        }
        return new_id;
    }
    public static void main(String[] args) {
        New_id ni = new New_id();
//        System.out.println(ni.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(ni.solution("z-+.^."));
        System.out.println(ni.solution("=.="));
        System.out.println(ni.solution("123_.def"));
        System.out.println(ni.solution("abcdefghijklmn.p"));
    }
}
