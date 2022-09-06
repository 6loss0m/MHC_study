package BLIND_2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
    조합을 통해 모든 후보키 후보를 구합니다.
    후보키의 후보로 set 에 넣어 중복이있다면 유일성을 만족하지않습니다.

    유일성을 만족하는지 확인하는 조건은 간단하지만
    최소성을 만족하는 조건을 짜기가 어려운 문제였습니다.
    하지만, 비트마스크를 사용하여 집합의 포함관계를 파악한다면
    최소성을 만족하는 조건도 간단히 짤 수 있습니다.

    저는 비트연산을 통해
    이전의 후보키를 집합의 포함관계로 최소성을 성립하는지 확인하였습니다.

                                    * 비트로 집합을 표현하는 방법
                                    {0} 을 2진수로 표현
                                    = 1
                                    {0,2,3} 을 2진수로 표현
                                    = 1101
                                    {0,2,5} 을  2진수로 표현
                                    = 100101


    ex) {0,2} 이 이미 후보키일 경우.(a)
    : 101

    다음에 들어온 후보키가 최소성을 만족하는지 알아보기.(b)
    {0,1,2}
    : 111

    101 & 111 = 101 (교집합)
    즉,
    a & b = a 를 만족하면
    b 의 후보키에 이미 a의 후보키가 들어가있는것이므로 최소성을 만족할 수 없습니다.

 */

public class CandidateKey {
    static ArrayList<String> cb=new ArrayList<>();          // 모든 조합
    static String[][] relations;
    static ArrayList<Integer> candidate = new ArrayList<>();      // 유일성,최소성을 만족하는 후보키

    public static void main(String[] args) {
        String[][] relation={ {"a","1","aaa","c","ng"},
                {"a","1","bbb","e","g"},
                {"c","1","aaa","d","ng"},
                {"d","2","bbb","d","ng"}};

        relations=relation;
        for(int i=1;i<=relation[0].length;i++){
            comb("",new boolean[relation[0].length],0,relation[0].length,i);
        }

        int ret =0;
        for(int i=0;i<cb.size();i++){
            String candi = cb.get(i);
            if(isUnique(candi)){
                int bit=0;
                for(int j=0;j<candi.length();j++){
                    bit|=(1<<(candi.charAt(j)-'0'));    // 현재 후보키를 집합을 나타내는 비트로 바꾸기.
                }

                boolean isMini = true;
                for(int j=0;j<candidate.size();j++){
                    int b = candidate.get(j);
                    if( (b&bit)==b ){ isMini = false; }     // 기존의 후보키가 현재 후보키에 포함된다면 최소성 만족 x
                }
                if(isMini){
                    System.out.println(cb.get(i)+" is unique");
                    candidate.add(bit);               // 유일성,최소성이 모두 만족된 후보키.
               }

            }
        }
        System.out.println(candidate.size());
    }

    static void comb(String str, boolean[] visited, int start, int n,int r){    // 모든 후보키 조합을 만들기 위해서
        if(r==0){ cb.add(str); }
        for(int i=start; i<n; i++){
            visited[i]=true;
            comb(str+i,visited,i+1,n,r-1);
            visited[i]=false;
        }
    }

    static boolean isUnique(String attribute){  // set 에 넣으며 중복이있는지 확인합니다.
        Set<String> set = new HashSet<>();

        for(int i=0;i<relations.length;i++){
            String col ="";
            for(int j=0;j<attribute.length();j++){
                 col += relations[i][attribute.charAt(j)-'0'];
            }
            if(set.contains(col)){  return false; }
            set.add(col);
        }
        return true;
    }

}
