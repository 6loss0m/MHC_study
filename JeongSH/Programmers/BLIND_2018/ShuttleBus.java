package BLIND_2018;

import java.util.ArrayList;
import java.util.Collections;
/*
    중요한 조건이 하나 있습니다.
    1. 마지막 버스에 탑승한 사람이 m 보다 작을경우
    2. 마지막 버스에 탑승한 사람이 m 일 경우

    1번 조건일 경우에는 마지막 버스 탑승 시간이 답이됩니다.
    2번 조건일 경우에는 마지막 버스에 탑승한 사람의 시간-1 입니다.(가장 마지막에 탑승한 사람보다 1분 일찍오면 되므로)

    시간 비교를 쉽게하기위해 모든 크루 시간을 분으로 바꾸고 int 형식으로 저장한 뒤, 오름차순으로 정렬합니다.
    버스시간표도 분으로 바꾼 뒤 순서데로 리스트를 만든뒤 비교합니다.

    1. 버스시간에 탈수있는 크루들은 최대 m 까지 탑승 시킵니다.
    2. 이를 반복한 뒤, 마지막 버스에 탑승하는 크루의 숫자를보고 조건에따라 답을 반환합니다.

 */

public class ShuttleBus {
    public static void main(String[] args) {
        int n=10;
        int t=60;
        int m=45;
        String[] timetable = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        ArrayList<Integer> timeList = new ArrayList<>();
        for(String str : timetable){
            String[] timeSplit = str.split(":");
            int time = Integer.parseInt(timeSplit[0]);
            time = time*60 + Integer.parseInt(timeSplit[1]);
            timeList.add(time);
        }
        Collections.sort(timeList);

        ArrayList<Integer> busList = new ArrayList<>();
        busList.add(540);
        for(int i=1;i<n;i++){ busList.add(540+(t*i)); }

        int manIdx = 0;
        int ret = 0;
        for(int i=0;i<n; i++){
            int cnt = 0;
            for(int j=manIdx;j<timeList.size();j++){
                if(timeList.get(j)<= busList.get(i)){   // 크루가 현재 버스에 탑승할 수 있다면
                    manIdx++;                           // 탑승한 다음 크루부터 시작해야하므로
                    cnt++;                              // 이 버스에 탑승한 사람의 수
                    if(cnt==m){ break; }                // 버스가 꽉차면
                }
            }
            if(i==n-1){                                 // 마지막 버스
                if(cnt==m){ ret = timeList.get(manIdx-1)-1; }   // 마지막 버스가 꽉찼다면, 마지막 탑승 크루시간-1
                else { ret = busList.get(i); }                  // 마지막 버스에 자리가 있다면
            }
        }
        String hour = String.valueOf(ret/60);
        String minute = String.valueOf(ret%60);
        if(hour.length()==1){hour="0"+hour;}
        if(minute.length()==1){minute="0"+minute;}

        System.out.println(hour+":"+minute);

    }
}
