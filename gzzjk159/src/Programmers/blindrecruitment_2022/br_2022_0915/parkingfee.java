package Programmers.blindrecruitment_2022.br_2022_0915;

import java.util.*;

public class parkingfee {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        int basic_time = fees[0];
        int basic_fee = fees[1];
        int minute = fees[2];
        int minute_per_fee = fees[3];

        ArrayList<String> keys = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String record : records) {
            String[] input = record.split(" ");
            String[] time = input[0].split(":");
            int time_num = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String car_number = input[1];
            String status = input[2];
            if (map.containsKey(car_number)) {
                if (Objects.equals(status, "IN")) {
                    map.put(car_number, map.get(car_number)-time_num);
                } else if(Objects.equals(status, "OUT")){
                    map.put(car_number, map.get(car_number)+time_num);
                }
            } else {
                map.put(car_number, -time_num);
                keys.add(car_number);
            }
        }

        keys.sort(String::compareTo);

        for (String k : keys) {
            if (map.get(k)<=0) {
                map.put(k, map.get(k)+((23*60)+59));
            }
            if (map.get(k)<=basic_time) {
                map.put(k, basic_fee);
            } else if (map.get(k)>basic_time) {
                map.put(k, basic_fee + gauss(basic_time, map.get(k), minute) * minute_per_fee);
            }
        }

        answer = new int[keys.size()];
        int i = 0;
        for (String k : keys) {
            answer[i] = map.get(k);
            i++;
        }
        return answer;
    }

    static int gauss(int basic_time, int time, int per_minute){
        double temp;
        temp = Math.ceil( ((double)(time-basic_time) / (double)per_minute) );
        return (int)temp;
    }

    public static void main(String[] args) {
        int[] fees1 = new int[]{180, 5000, 10, 600};
        String[] records1 = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] fees2 = new int[]{120, 0, 60, 591};
        String[] records2 = new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        int[] fees3 = new int[]{1, 461, 1, 10};
        String[] records3 = new String[]{"00:00 1234 IN"};

        parkingfee pf = new parkingfee();

        System.out.println(Arrays.toString(pf.solution(fees1, records1)));
        System.out.println(Arrays.toString(pf.solution(fees2, records2)));
        System.out.println(Arrays.toString(pf.solution(fees3, records3)));
    }
}
