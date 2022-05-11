package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    삼분탐색
    삼분탐색은 그래프가 아래로 볼록한 경우,최소값을
             그래프가 위로 볼록한 경우, 최대값을 구할때
    사용할 수 있습니다.
    그래프를 끝과 끝 기준으로 삼등분을 하여 p,q 를 정하고
    f(p), f(q) 의 두 값을 비교하여 구간을 줄여 나갑니다.
    https://m.blog.naver.com/PostView.nhn?blogId=kks227&logNo=221432986308&proxyReferer=https:%2F%2Fwww.google.com%2F
    (참고)

    시간을 0부터 100으로 보았을 때,
    시간에 따른 민호,강호의 좌표를 구하는 함수를 만들어
    p,q 시간일 떄 서로의 거리가 최대가 될때까지 삼분탐색을 돌립니다.

 */

public class boj11662_Minho {
    static int[] m = new int[4]; //ax,ay,bx,by
    static int[] k = new int[4]; //cx,cy,dx,dy

    static double[] mp = new double[2]; //xy
    static double[] mq = new double[2]; //xy
    static double[] kp = new double[2];
    static double[] kq = new double[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        for(int i=0;i<4;i++){m[i]=Integer.parseInt(input[i]);}
        for(int i=0;i<4;i++){k[i]=Integer.parseInt(input[i+4]);}

        double lo = 0;      // 시간 0
        double hi = 100;    // 도착시간을 100으로 봤을 때,
        double p,q;
        double ret=Double.MAX_VALUE;
        while (hi-lo>= 1e-6){
            p= (2*lo+hi)/3; // 1/3 지점 시간
            q= (lo+2*hi)/3; // 2/3 지점 시간

            mp=getM(p);
            mq=getM(q);
            kp=getK(p);
            kq=getK(q);

            double pDist = Math.sqrt( Math.pow(mp[0]-kp[0],2)+Math.pow(mp[1]-kp[1],2) ); // 시간이 p 일 때, 민수와 강호의 거리
            double qDist = Math.sqrt( Math.pow(mq[0]-kq[0],2)+Math.pow(mq[1]-kq[1],2) ); // 시간이 q 일 때, 민수와 강호의 거리

            ret = Math.min(ret,Math.min(pDist,qDist));
            if(pDist>=qDist){lo=p;}
            else{ hi = q; }
        }
        System.out.printf("%.10f",ret);

    }
    static double[] getM(double pq){
        return new double[] {m[0]+(m[2]-m[0])*(pq/100), m[1]+(m[3]-m[1])*(pq/100)}; // pq 시간일때 민호의 현재 좌표
    }
    static double[] getK(double pq){
        return new double[] {k[0]+(k[2]-k[0])*(pq/100), k[1]+(k[3]-k[1])*(pq/100)}; // pq 시간일때 강호의 현재 좌표
    }
}
