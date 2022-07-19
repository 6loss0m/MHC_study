package SummerWinter_2018_2;

/*
    아이디어
    1. 선행스킬을 보고 선행스킬부터 0,1,2,3... 숫자를 부여합니다.
        skill  : C=0 , B=1, D=2
        skill_tree : {"1A02E", "01A2F", "AE01", "12A" }
    2. 정규식을 이용하여 모든 "문자" 를 제거합니다.
        skill_tree : {"102", "012", "01", "12", "2"}
    3. 각각의 문자열을보고 i번째 문자열에 i가 있는지 확인합니다.
        "102":x / "012":o / "01":o / "12":x / "2":x
        조건을 충족하는 문자열은 [1],[2] 총 2개입니다.

    예외부분 처리
    위의 전처리 과정을 거치면 "" 빈 문자열이 생길수있습니다.
    선행스킬이 하나도 포함되지않더라도 스킬을 배울수 있으므로 count 를 늘려줍니다.
 */

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        for (int i=0; i< skill_trees.length; i++) {
            for (int j = 0; j < skill.length(); j++) {  // 선행스킬 순서데로 0~ n 까지 부여
                skill_trees[i] = skill_trees[i].replace(skill.charAt(j)+"", j+"");
            }
            skill_trees[i]=skill_trees[i].replaceAll("[A-Z]","");   // 모든 대문자 제거
        }

        int cnt=0;
        for(int i=0; i< skill_trees.length; i++){
            if(skill_trees[i].equals("")){ cnt+=1; continue;}   // 선행스킬이 하나도 포함되지않아도 가능하기때문
            boolean isValid = true;
            for(int j=0; j<skill_trees[i].length(); j++){
                if(skill_trees[i].charAt(j)-'0'!=j){ isValid=false; break; }
            }
            if(isValid==true){ cnt+=1; }
        }
        System.out.println(cnt);
    }
}
