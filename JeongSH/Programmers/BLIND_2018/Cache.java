package BLIND_2018;

import java.util.ArrayList;
/*
    LRU 구현 문제입니다.
    LRU 는 가장 오랫동안 참조되지 않은 페이지를 교체하는 방식입니다.

    LRU 를 구현하기 위해서는
    캐시가 가득 찼을 때, 가장 오랫동안 참조되지 않은 페이지를 찾아서 없애는 과정이 필요합니다.

 */

public class Cache {
    static final int HIT = 1;
    static final int MISS = 5;

    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        if(cacheSize==0){ System.out.println(cities.length*MISS); return;}  // 캐시 사이즈가 0 이면 모든 페이지가 MISS 이므로

        ArrayList<String> cache = new ArrayList<>();

        int time = 0;
        for(int i=0;i<cities.length;i++){
            String now = cities[i].toLowerCase();
            if(cache.size()==0){ time+= MISS; cache.add(now); continue; }
            if(cache.contains(now)){        // 캐시에 현재 값이 존재한다면
                time+=HIT;
                cache.remove(now);
                cache.add(0,now);   // 가장 앞 페이지로 바꿔줍니다.
            }
            else{                           // 캐시에 존재하지않는다면
                time+=MISS;
                if(cache.size()==cacheSize){    // 캐시가 꽉 찼다면 가장 마지막 페이지를 삭제하고, 현재 값을 가장 앞 페이지로 합니다.
                    cache.add(0,now);
                    cache.remove(cacheSize);
                }
                else{                           // 캐시가 꽉 차지않았다면 현재 값을 가장 앞 페이지로 합니다.
                    cache.add(0,now);
                }
            }
            System.out.println(cache);
        }
        System.out.println(time);
    }
}
