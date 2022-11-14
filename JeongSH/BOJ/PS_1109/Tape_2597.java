package BOJ.PS_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문제 접근
    문제의 제한조건이 문제 풀이의 큰 영향을 끼치지않고,
    최대 세번만 접으면 되기때문에 O(N) 의 시간복잡도를 갖고있어 단순구현이라고 판단.

    풀이
    1. 항상 왼쪽에서 오른쪽으로 접을 시 접은 지점이 시작지점이 된다.
        1-1. 접고난 뒤 모든 점의 위치
            접고난뒤 = |접은지점-현재위치|
    2. 접고난 줄자의 길이는
        len = max(접은지점,len-접은지점)

    테스트 케이스
    10     접히는 부분이 오른쪽끝 혹은 왼쪽 끝이어도 문제가 없는지 파악하기위해
    1 3
    2 5
    8 9

 */
public class Tape_2597 {
    static double[][] point = new double[3][2]; // [색][0:start, 1:end]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N  = Integer.parseInt(br.readLine());

        for(int i=0;i<3;i++){
            String[] in = br.readLine().split(" ");
            point[i][0]=Integer.parseInt(in[0]);
            point[i][1]=Integer.parseInt(in[1]);
        }

        for(int i=0;i<3;i++){
            if(point[i][0]==point[i][1]){ continue; }   // 이미 두 좌표가 같다면 접지 않는다.
            double half = getHalf(point[i][0],point[i][1]);
            N = Math.max(half,N-half);
            update(half);
        }
        System.out.println(String.format("%.1f",N));
    }
    static double getHalf(double start, double end){ return (start + end)/2; }

    // 접은곳과 각각의 점위치는 절대값의 차이만큼으로 최신화됨.
    static void update(double half){
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                point[i][j] = Math.abs(half-point[i][j]);
            }
        }
    }
}
