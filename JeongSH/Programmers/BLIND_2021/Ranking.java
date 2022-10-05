package BLIND_2021;
/*
    1. 아이디어
    HashMap<String, PriorityQueue<Integer>> map
    info 를 보고 모든 조합( '-' 넣은)을 미리 구한 뒤, 이것을 key 값으로 사용
    value 에는 우선순위 큐를 넣어 키값에 해당하는 모든점수를 넣어줍니다.
    큐에서 쿼리의 점수 이상일때까지 pop 하고, 점수 이상일때의 사이즈를 result 에 넣습니다.

    2. 아이디어
    첫번째의 접근법으로 문제를 풀면 동일한 쿼리가 들어올 시 우선순위 큐에 원래 들어가있어야 할 값들이
    이미 pop 되어 문제가 생길수 있었습니다.
    그래서 정렬을 한뒤 반복문을 돌렸으나 시간초과가 생김.

    3. 마지막을 구할때, 0번부터 탐색하는것이 아닌
    이분탐색을 통해 구하게되면 O(N) -> O(logN) 시간복잡도가 대폭 감소하게됩니다.

 */

import java.util.*;

public class Ranking {
    static String[] infoArr;
    static String[] tmpArr;
    static HashMap<String, ArrayList<Integer>> map;

    public static void main(String[] args) {
        String[] info={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        map = new HashMap<>();
        for(String in : info){
            tmpArr = new String[4];
            infoArr = in.split(" ");
            setComb(0,Integer.parseInt(infoArr[4]));
        }
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }

        int[] ret = new int[query.length];
        for(int i=0;i<query.length;i++){
            String in = query[i];
            String[] split = in.replace(" and "," ").split(" ");
            String key = split[0]+split[1]+split[2]+split[3];

            if(!map.containsKey(key)){ ret[i]=0; continue; }

            ArrayList<Integer> list = map.get(key);
            int cut = Integer.parseInt(split[4]);
            ret[i]=list.size()-binarySearch(list,cut);
        }
        System.out.println(Arrays.toString(ret));

    }
    static int binarySearch(ArrayList<Integer> list, int cut){      // cut 을 넘지않는 최대값
        int left = 0;
        int right = list.size()-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(list.get(mid)<cut){ left=mid+1; }
            else{ right= mid-1; }
        }
        return left;
    }

    static void setComb(int depth,int score){   // 조합
        if(depth == 4){
            String str = String.join("",tmpArr);
            if(!map.containsKey(str)){ map.put(str,new ArrayList<>());}
            map.get(str).add(score);
            return;
        }
        else{
            tmpArr[depth]=infoArr[depth];
            setComb(depth+1,score);
            tmpArr[depth]="-";
            setComb(depth+1,score);
        }
    }
}
