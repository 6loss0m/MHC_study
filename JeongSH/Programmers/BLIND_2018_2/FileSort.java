package BLIND_2018_2;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
    구현문제
    정렬을 합쉬다..


 */

public class FileSort {
    static int count = 0;
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        PriorityQueue<File> q = new PriorityQueue<>();
        for(String f : files){ q.add(new File(f)); }

        String[] ret = new String[q.size()];
        for(int i=0;i<ret.length ;i++){ ret[i]=q.poll().name; }

        System.out.println(Arrays.toString(ret));

    }
    static class File implements Comparable<File>{
        String name;
        String head;
        int num;
        int idx;

        public File(String name) {
            this.name = name;
            int i;
            for(i=0; i<name.length();i++){
                if('0'<=name.charAt(i)&&name.charAt(i)<='9') break;
            }
            head = name.substring(0,i).toLowerCase();
            int start = i;
            for(; i<start+5; i++){
                if(i==name.length()){break;}
                if('0'<=name.charAt(i)&&name.charAt(i)<='9') continue;
                break;
            }
            num = Integer.parseInt(name.substring(start,i));
            idx=count++;
        }

        @Override
        public int compareTo(File o) {
            if(this.head.equals(o.head)){
                if(this.num == o.num){ return this.idx-o.idx;}
                return this.num-o.num;
            }
            return this.head.compareTo(o.head);
        }
    }
}
