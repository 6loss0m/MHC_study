package KaKaoWinterIntern;
/*
    아이디어는 Union-find 라고 파악했지만 구현을 못해서 참고하였습니다.

 */
import java.util.Arrays;
import java.util.HashMap;

public class Hotel {
    static HashMap<Long, Long> map ;            // <배정한방,다음방>   베정한방으로 요청이 들어오면 다음방에 배정.
    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(new long[]{1,3,4,1,3,1}, 10)));
    }
    public static long[] solution (long[] room_number, int k ){
        long[] result = new long[room_number.length];
        map = new HashMap<>();
        for(int i=0; i<room_number.length; i++){
            result[i]=findRoom(room_number[i]);
        }
        System.out.println(map.toString());
        return result;
    }
    public static long findRoom(long room){
        System.out.println("room:"+ room);
        if(!map.containsKey(room)){
            System.out.println("put("+room+", "+(room+1)+")");
            map.put(room,room+1);               // union-find 의 기본은 자신은 자신+1을 바라보게 초기화를 합니다.
            return room;                        // 결국 배열에 어떤방을 배정했는지를 알기위한것이기 때문에 room 리턴합니다.
        }
        long next = map.get(room);              // 이미 원하는 방이 배정된 상태라면 그 방이 가리키고있는 다음방을 탐색해야합니다.
        long empty = findRoom(next);            // 재귀식으로 돌기때문에 현재 빈방은 이전 재귀에서 put(n,n+1) 을 배정한 상태입니다.
        System.out.println("put("+room+", "+(empty)+")");
        map.put(room,empty);                    // 재귀식으로 들어왔던 모든방은 비어있었던 방으로 전부 최신화 해줘야합니다.
        return empty;
    }
}
