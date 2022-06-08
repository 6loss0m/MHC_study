package BOJ.PS_0608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

    사각형끼리 겹치는 부분이 있다면 펜을 떼지않고 한 번에 그릴 수 있습니다.

    접근법1
        2차원 배열에 모든 직사각형을 표시 한 뒤, dfs 로 직사각형끼리 겹치는(이동할 수 있는)지 확인하는 방법.

        문제점
        배열과 좌표상의 점은 다름. A(1,1)(5,5) / B(2,2)(4,4)
        A 직사각형과 B 직사각형은 서로 겹치지않지만, 2차원 배열상에서 dfs 탐색을 하면 두 직사각형은 이어져있다고 판단함.

    접근법2
        직사각형끼리 교차하는지 전부 확인하여 그 정보를 토대로 dfs 탐색.

        두 직사각형이 교차하지 "않는" 조건.(두 직사각형이 교차하는 조건은 상대적으로 많기때문에 not 을 붙여서 반대조건을 구함.)
        직사각형 A,B
        조건1. A 보다 B 가 오른쪽,왼쪽,위,아래 방향으로 떨어져있는 경우.
        조건2. A 안에 B 가 있는 경우.(겹치지 않고)
        조건3. B 안에 A 가 있는 경우.(겹치지 않고)

 */

public class boj3108_Logo {
    static Rectangle[] rectangles = new Rectangle[1000];    // 직사각형들
    static boolean[][] isCross = new boolean[1000][1000];   // 직사각형들 끼리의 교차정보를 저장
    static boolean[] visit = new boolean[1000];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int count=0;
        Rectangle zeroR = new Rectangle(0,0,0,0);   // 첫 시작이 0,0 이므로

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            rectangles[i]=new Rectangle(Integer.parseInt(input[0]),Integer.parseInt(input[1]),Integer.parseInt(input[2]),Integer.parseInt(input[3]));
            if(zeroR.isCross(rectangles[i])){ count = -1; }     // 첫 시작이 (0,0) 이므로 여기를 교차하면 숫자는 -1부터 세야 함.
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(rectangles[i].isCross(rectangles[j])){ isCross[i][j]=true; } // 직사각형끼리의 교차정보
            }
        }
        for (int i = 0; i < N; i++) {
            if(!visit[i]){ dfs(i); count+=1; }
        }
        System.out.println(count);

    }
    static void dfs(int r){
        visit[r]=true;
        for (int i = 0; i < N; i++) {
            if(!visit[i] && isCross[r][i]) { dfs(i); }
        }
    }

    static class Rectangle {
        int x1,y1;
        int x2,y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        public boolean isCross(Rectangle r){    // this=A   r=B
            return !(x1>r.x2||x2<r.x1||y1>r.y2||y2<r.y1 // 조건 1
                    || (x1<r.x1 && x2>r.x2 && y1<r.y1 && y2>r.y2)   // 조건2
                    || (r.x1<x1 && r.x2>x2 && r.y1<y1 && r.y2>y2)); // 조건3
        }
    }
}
