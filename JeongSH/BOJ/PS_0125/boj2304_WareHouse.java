package BOJ.PS_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    아이디어
    가장 높은 기둥을 가운데로 생각하면
    왼쪽은 왼쪽에서 가운데로 갈수록 높아져야하고,
    오른쪽은 오른쪽에서 가운데로 갈수록 높아집니다.

    1. 왼쪽부터 maxH 까지 계산합니다.
    2. 오른쪽부터 maxH 까지 계산합니다.
    3. maxH 가 여러개 일수도 있으므로, 왼쪽 max 오른쪽 max 위치를 구하여 넓이를 계산합니다.
    ex)
            []    []
          [][][][][][]
        [][][][][][][][]

 */

public class boj2304_WareHouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];   // [][0]: 위치 / [][1]:높이

        int maxH = 0;

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            info[i][0]=Integer.parseInt(split[0]);  // 위치
            info[i][1]=Integer.parseInt(split[1]);  // 높이
            maxH = Math.max(maxH,info[i][1]);
        }

        Arrays.sort(info, (o1, o2) -> o1[0]-o2[0]);

        int preL=info[0][0];
        int preH=info[0][1];

        int leftMaxPoint = 0;
        int total = 0;
        for(int i=1;i<N;i++){
            int L = info[i][0];
            int H = info[i][1];
            total = total + preH*(L-preL);
            preL = L;
            if(H>preH){ preH=H; }
            if(preH == maxH){ leftMaxPoint = L; break; }
        }

        preL=info[N-1][0];
        preH=info[N-1][1];

        int rightMaxPoint = N-1;
        for(int i=N-2; i>=0; i--){
            int L = info[i][0];
            int H = info[i][1];
            total = total + preH*(preL-L);
            preL = L;
            if(H>preH){ preH=H;}
            if(preH == maxH){ rightMaxPoint=L; break;}
        }

        System.out.println(total+((rightMaxPoint-leftMaxPoint+1)*maxH));
    }
}
