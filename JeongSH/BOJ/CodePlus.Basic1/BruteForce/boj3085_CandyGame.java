/**
 *  대략적 시간복잡도를 계산하여 풀이 방법을 정했습니다.
 *
 *  완전탐색으로 풀이한다고 생각한다면
 *  입력으로 주어지는 1<=n<=50 이기 때문에.
 *  모든 배열의 사탕을 위와 오른쪽으로 바꿨을 경우.
 *  연산 횟수는 (50x50) 입니다.
 *
 *  그리고 위의 경우에서 각각의 사탕의 최대 길이를 구하면
 *  최악의 경우 50x50 입니다.
 *
 *  대략적으로 2n^2 x n^2 연산을 합니다.
 *  == 2n^4
 *
 *  n= 약 2^6 == 64 이므로
 *  2n^5 = 2(2^6)^4  = 2(2^24) = 2(2^10)^2 x 2^4 = 2(1024)^2 x 16 은 약 2x10^6 x 16  이므로
 *  대략 10^7 정도의 연산을 합니다.
 *
 *  1초에 대략 10^9 의 연산이 가능하므로. 완전탐색을 사용하더라도 시간초과가 안날 것입니다.
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3085_CandyGame {
    static int n;
    static int max=Integer.MIN_VALUE;
    public static void main(String args[])throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][n];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<n; j++){
                arr[i][j]=tmp[j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                if (j+1<n && isTrance(arr[i][j],arr[i][j+1])){
                    String tmp = arr[i][j];
                    arr[i][j]=arr[i][j+1];
                    arr[i][j+1]=tmp;
                    max= Math.max(maxLength(arr),max);
                    arr[i][j+1]=arr[i][j];
                    arr[i][j]=tmp;
                }
                if(i+1<n && isTrance(arr[i][j],arr[i+1][j])){
                    String tmp = arr[i][j];
                    arr[i][j]=arr[i+1][j];
                    arr[i+1][j]=tmp;
                    max=Math.max(maxLength(arr),max);
                    arr[i+1][j]=arr[i][j];
                    arr[i][j]=tmp;

                }
            }
        }
        System.out.println(max);
    }
    static boolean isTrance(String a, String b){
        if(a.equals(b)){return false;}
        return true;
    }
    static int maxLength(String[][] arr){
        int maxL = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int l = 1;
                int jTmp = j;
                while(jTmp+1 < n && arr[i][jTmp].equals(arr[i][++jTmp])){ l++; }
                maxL = Math.max(l,maxL);
                l=1;
                int iTmp = i;
                while(iTmp+1 < n && arr[iTmp][j].equals(arr[++iTmp][j])){ l++; }
                maxL = Math.max(l,maxL);
            }
        }
        return maxL;
    }
}
