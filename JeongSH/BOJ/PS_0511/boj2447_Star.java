package BOJ.PS_0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    중앙의 빈곳을 식으로 세워보면
    (i/3)%3 == 1 && (j/3)%3 == 1 인 경우 빈칸을 출력하면 됩니다.

    재귀의 포인트.
    첫 27은 가운데 27 칸을 비우고 그 주위를
    9칸을 비운 사각형이 둘러싸고있습니다.
    그리고, 1칸을 비운 사각형이 둘러싸고있습니다.

    즉 처음
    i,j에 별을 찍을지 판단해야합니다.
    판단을 하기위해 판의 전체 크기인 N을 보고
    가장 바깥쪽이 어떤 패턴으로 둘러싸고있는지를 보고
    별을 찍을지 판단합니다.

 */

public class boj2447_Star {
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            for(int j=0;j<N; j++){
                star(i,j,N);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void star(int i, int j, int cur){
        if((i/cur)%3==1 && (j/cur)%3==1){ sb.append(" "); }     // 위 점화식으로 빈칸을 구할 수 있습니다.
        else if(cur/3==0){ sb.append("*"); }                    // 재귀의 가장 깊은곳으로 들어가면, 즉 가장 바깥쪽!
        else {star(i,j,cur/3);}                             // 판의 크기와 그 판을 둘러싸고있는 판을 알기위해
    }
}
