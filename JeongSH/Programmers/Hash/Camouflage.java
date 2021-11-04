import java.util.HashMap;
// 경우의 수 문제로 풀어본 방식.
// 각 종류별옷의 가지수에 +1(안입는경우)를 더하여 모두 곱하고 아무것도 안입는 경우가 있으므로 -1을 해주면 됩니다.
public class Camouflage {
    public static void main(String args[]){
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer=1;
        HashMap<String,Integer> hashMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            if(hashMap.containsKey(clothes[i][1])) {hashMap.put(clothes[i][1],hashMap.get(clothes[i][1]+1));}
            else {hashMap.put(clothes[i][1],1);}
        }
        for(String k : hashMap.keySet()){
            answer=(hashMap.get(k)+1)*answer;
        }
        answer=answer-1;
    }
}