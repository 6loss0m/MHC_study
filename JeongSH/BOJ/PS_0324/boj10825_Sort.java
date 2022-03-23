package BOJ.PS_0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
    sort....

 */
public class boj10825_Sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){
                if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])){
                    if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])){
                        return o1[0].compareTo(o2[0]); // 증가
                    }
                    return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);   // 감소
                }
                return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]); // 증가
            }
         return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);    //감소
        });

        String[] input;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            pq.add(new String[]{input[0],input[1],input[2],input[3]});
        }
        for(int i=0; i<N; i++){ sb.append(pq.poll()[0]).append("\n"); }
        System.out.println(sb);
    }
}
