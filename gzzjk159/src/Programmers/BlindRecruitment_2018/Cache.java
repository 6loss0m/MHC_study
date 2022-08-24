package Programmers.BlindRecruitment_2018;

import java.util.LinkedList;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return 5*cities.length;
        }

        LinkedList<String> cache = new LinkedList<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            if(cache.remove(city)){
                cache.addFirst(city);
                answer += 1;
            }
            else{
                int currentsize = cache.size();
                if(currentsize >= cacheSize){
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
    }
}
