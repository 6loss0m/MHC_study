package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

    참고 : https://www.slideshare.net/Baekjoon/baekjoon-online-judge-2873
    그리디 문제입니다.
    조건은 크게 세가지로 볼 수 있습니다.
    1. R가 홀수일 경우 : 모든 칸을 방문할 수 있음. (RRR...DLLL...DRRR)
    2. C가 홀수일 경우 : 모든 칸을 방문할 수 있음. (DDD...RUUU...RDDD)
    3. R,C 모두 짝수일 경우 : 체스판을 예시로 들면 흰칸에서 출발하여 흰칸으로 도착하는 것과 같음.
        검은 칸 한칸을 제외하고는 모든 칸을 갈 수 있음.
        (출발)흰->검->흰(도착) 크기 (2x2) / 방문 칸 흰>검
        (출발)흰->검->흰->검->흰->검->흰(도착) (2x4)/ 방문 칸 흰>검
        (출발)흰->검->흰->검->......흰->검->흰(도착) 방문 칸 흰>검
        즉 검은 칸 한간을 제외하면 모든칸을 방문 할 수 있습니다.

    나머지는 그림을 보며..


 */

public class boj2873_RollerCoaster {
    static int[][] map = new int[1000][1000];
    static int R;
    static int C;
    static StringBuffer sb= new StringBuffer();
    static StringBuffer endSb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        for(int r=0;r<R; r++){
            input = br.readLine().split(" ");
            for(int c=0;c<C; c++){
                map[r][c]=Integer.parseInt(input[c]);
            }
        }

        if(R%2==1){         // 가로줄이 홀수인 경우
            for(int r=0; r<R; r++){
                if(r%2==0){ sb.append("R".repeat(C-1));}
                else {sb.append("L".repeat(C-1));}
                if(r!=R-1){sb.append("D");}
            }
        }

        else if(C%2==1){    // 세로줄이 홀수인 경우
            for(int c=0; c<C; c++){
                if(c%2==0){ sb.append("D".repeat(R-1));}
                else {sb.append("U".repeat(R-1));}
                if(c!=C-1){sb.append("R");}
            }
        }

        else{       // 둘 다 짝수인 경우
            int [] minRC = {0,0};   // r,c
            int minV = 1000;
            for(int r=0; r<R; r++){                     // 최소값 칸 찾기.
                for(int c=0; c<C; c++){
                    if((r+c)%2==0){continue;}
                    if(map[r][c]<minV){ minRC = new int[] {r,c}; minV = map[r][c];}
                }
            }
            int startR=0, startC=0;
            int endR=R-1, endC=C-1;
            while(startR+1 < minRC[0]){
                sb.append("R".repeat(C-1)).append("D").append("L".repeat(C-1)).append("D");
                startR+=2;
            }
            while(endR-1 > minRC[0]){
                endSb.append("R".repeat(C-1)).append("D").append("L".repeat(C-1)).append("D");
                endR-=2;
            }

            while (startC+1 < minRC[1]){
                sb.append("D").append("R").append("U").append("R");
                startC+=2;
            }
            while (endC-1 > minRC[1]){
                endSb.append("D").append("R").append("U").append("R");
                endC-=2;
            }

            if(startR==minRC[0]){ sb.append("D").append("R"); }
            else { sb.append("R").append("D");}

            sb.append(endSb.reverse());
        }
        System.out.println(sb);
    }
}
