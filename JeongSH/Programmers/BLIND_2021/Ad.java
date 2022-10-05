package BLIND_2021;
/*
    아이디어

    모든 시간을 초 단위로 바꾸고

    1. log 를 순회하며 시작 시간, 끝 시간을 +1 , -1 로 체크합니다.
        - 이유는 누적합을 계산하기 위해
        - 누적합 x 라면 logs 의 최대값 300000, 이므로
         (logs 시작시간 ~ logs 끝시간) * 300000 시간복잡도
        - 누적합을 사용하면 O(N) 으로 구할 수 있습니다.

    2. 누적합을 계산하여 각각 시간에 몇몇의 시청자가 있는지 구합니다.

    3. 0 초 부터 광고시간의 총 길이까지의 시청자를 먼저 구합니다.

    4. 슬라이딩 윈도우 알고리즘을 이용하여
    광고 시작시간을 0초부터 1초단위로 움직이며 배치했을때의 누적합을 구하며 최대값을 구합니다.

 */

public class Ad {
    static long[] starts;
    static long[] ends;
    static long[] viewSum;

    public static void main(String[] args) {
        String play_time="02:03:55";
        String adv_time="00:14:15";
        String[] logs={"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        long totalPlayTime = strToTime(play_time);
        long totalAdTime = strToTime(adv_time);
        starts = new long[logs.length];
        ends = new long[logs.length];

        for(int i=0;i<logs.length;i++){
            String[] split = logs[i].split("-");
            starts[i] = strToTime(split[0]);
            ends[i] = strToTime(split[1]);
        }

        viewSum = new long[360000];
        for(int i=0;i<logs.length;i++){ // 누적합
            viewSum[(int) starts[i]]+=1;
            viewSum[(int) ends[i]]-=1;
        }

        for(int i=1;i<totalPlayTime; i++){  // 누적합
            viewSum[i]+=viewSum[i-1];
        }

        long sum = 0;
        for(long s: viewSum){ sum+= s; }
        long maxSum = sum;

        long maxIdx=0;
        for(long i=totalAdTime; i<totalPlayTime; i++){
            sum += viewSum[(int)i]-viewSum[(int)(i - totalAdTime)]; // 누적합 = 누적합 + 시청자[i] - 시청자[i-광고시간]
            if(sum>maxSum){
                maxSum = sum;
                maxIdx = i - totalAdTime + 1;
            }
        }
        System.out.println(timeToString(maxIdx));
    }
    static long strToTime(String s){
        String[] split = s.split(":");
        long time = Long.parseLong(split[0])*60;
        time= (time + Long.parseLong(split[1]))*60;
        time+= Long.parseLong(split[2]);
        return time;
    }
    static String timeToString(long t){
        String s = "";
        long h = t/3600;
        t %= 3600;
        if(h<10) {s+="0"+h+":";}
        else { s+=h+":";}

        long m = t/60;
        t %=60;
        if(m<10) {s+="0"+m+":";}
        else {s+=m+":"; }

        long sec = t;
        if(sec<10){ s+="0"+sec; }
        else{ s+=sec; }

        return s;
    }
}
