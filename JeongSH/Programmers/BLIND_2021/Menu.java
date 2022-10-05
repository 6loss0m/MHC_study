package BLIND_2021;

import java.util.*;

/*
    여러 방법을 생각해봤지만 결국 조합을 구해서 갯수를 세야하기때문에
    완전탐색을 해야되는 문제라고 생각합니다.

    maxCnt[] : course 별 로 가장많이나온 조합의 최대갯수를 저장할 배열
    hashmap[] : course 별 로 조합을 저장할 map


    문제 아이디어
    0. course 별로 HashMap[] 배열을 만들어 줍니다.     // course 별로 가장 많이 나온 조합을 찾아야하기 떄문에

    1. 메뉴랑 course 를 보고 만들 수 있는 조합을 만듭니다.
        각각의 조합은 hashmap[course].put() 합니다.

    1-1. 조합을 만들면서 기존에 이미 만들어진 조합이라면 갯수를 늘려주고, 최대갯수를 저장합니다.
        최대갯수는 maxCnt[course] 로 저장해두면
        course 별로 가장 많이 나온 조합의 최대 갯수를 알 수 있습니다.

    2. hashmap 을 순회하며, 가장많이 나온 조합의 갯수가 2개 이상일때 만을 담은 리스트를 만들어 반환합니다.

 */

public class Menu {
    static HashMap<String,Integer>[] cb;
    static boolean[] visit;
    static int[] maxCnt;

    public static void main(String[] args) {
        String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course={2,3,4};

        cb = new HashMap[course.length];        // 조합을 저장할 map
        maxCnt = new int[course.length];        // course 마다 가장 많이나온 조합의 갯수를 저장하기위해

        for(int i=0;i<orders.length;i++){
            visit = new boolean[orders[i].length()];
            for(int j=0;j<course.length;j++){
                if(cb[j]==null){ cb[j]=new HashMap<>(); }
                if(course[j]>orders[i].length()){ continue; }   // 조합을 만들수 없을때는 무시
                char[] arr = orders[i].toCharArray();           // 미리 정렬
                Arrays.sort(arr);
                setComb(course[j],0,"",arr,j);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            Iterator<String> it = cb[i].keySet().iterator();
            if(maxCnt[i]<2) {continue;}
            while (it.hasNext()){
                String key = it.next();
                int value = cb[i].get(key);
                if(maxCnt[i]!= value) {continue;}
                list.add(key);
            }
        }
        Collections.sort(list);
        String[] ret = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(ret));

    }

    // n : 조합의 문자열 길이
    // char[] arr : 조합에 사용할 문자열
    // course : course 별로 저장하기위해
    static void setComb(int n,int idx, String s, char[] arr, int course){

        if(s.length()>=n) {
            int now = cb[course].getOrDefault(s,0);
            cb[course].put(s,now + 1);
            maxCnt[course] = Math.max(now+1,maxCnt[course]);
            return;
        }

        for(int i=idx;i<arr.length; i++){
            if(!visit[i]){
                visit[i]=true;
                setComb(n,i,s+arr[i],arr,course);
                visit[i] = false;
            }
        }
    }
}
