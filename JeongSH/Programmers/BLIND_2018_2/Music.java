package BLIND_2018_2;

import java.util.PriorityQueue;
/*
    구현문제입니다.
    musicinfos time 을 분 단위로 고친 뒤, time 만큼 악보를 반복시켜 늘려줍니다.

    늘린 악보중에 m 문자열이 존재하면
    조건에 맞춰서 반환합니다.

 */

public class Music {
    static class Info implements Comparable<Info>{
        int n;
        String title;
        int time;

        public Info(int n, String title, int time) {
            this.n = n;
            this.title = title;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            if(this.time==o.time){ return this.n-o.n; }
            return o.time - this.time;
        }
    }

    public static void main(String[] args) {
        String m="CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

        m = replace(m);
        int time;
        String title;

        PriorityQueue<Info> q = new PriorityQueue<>();

        for(int i=0;i<musicinfos.length;i++){
            String[] split = musicinfos[i].split(",");

            String[] timeSplit = split[0].split(":");
            int start = Integer.parseInt(timeSplit[0]);
            start = start*60 + Integer.parseInt(timeSplit[1]);

            timeSplit = split[1].split(":");
            int end = Integer.parseInt(timeSplit[0]);
            end = end*60 + Integer.parseInt(timeSplit[1]);

            time = end - start;
            title=split[2];

            String pattern = "";
            String music = replace(split[3]);
            int len = music.length();
            for(int j=0;j<time;j++){
                pattern += music.charAt(j%len);
            }

            if(pattern.contains(m)){
                q.add(new Info(i,title,time));
            }
        }
        if(q.isEmpty()){
            System.out.println("(None)");
            return;
        }
        System.out.println(q.poll().title);
    }

    static String replace(String s){
        s= s.replace("C#","H");
        s= s.replace("D#","I");
        s= s.replace("F#","J");
        s= s.replace("G#","K");
        s= s.replace("A#","L");
        return s;
    }
}
