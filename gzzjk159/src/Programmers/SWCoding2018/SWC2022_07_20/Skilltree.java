package Programmers.SWCoding2018.SWC2022_07_20;


public class Skilltree {

    public int solution(String skill, String[] skill_trees) {
        int answer=0;
        int skillidx;
        boolean flag;
        for (String str : skill_trees) {
            flag = true;
            skillidx = 0;
            for (int j = 0; j < str.length(); j++) {
                if (skill.contains(String.valueOf(str.charAt(j)))) {
                    if (skill.charAt(skillidx) == str.charAt(j)) {
                        skillidx++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Skilltree st = new Skilltree();
        System.out.println(st.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}