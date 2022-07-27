package CodeChallenge;
/*
    i 인덱스를 기준으로
    왼쪽 구간, 오른쪽 구간으로 나누어서 생각합니다.
    왼,오른쪽 구간의 최소값이 a[i] 보다 작다면, a[i]는 남길 수 없는 풍선입니다.
    [-16,27,65,-2,58,-92,-71,-68,-61,-33]
    ex) i = 3 , a[i]=-2
    1. 왼쪽구간 : -16 덕분에 -2 전까지의 풍선은 모두 없앨 수 있습니다. -2의 왼쪽구간 최소값:-16
    [-16,-2, ....]
    2. 오른쪽구간 : -92 덕분에 -2 전까지의 풍선은 모두 없앨 수 있습니다. -2의 오른쪽구간 최소값:-92
    [-16,-2,-92]
    양 옆에 -2 보다 작은 두 풍선이 있으므로 남길 수 없습니다.

    시행착오
    i 를 기준으로 왼,오른쪽구간의 최소값을 매번 구해주면 시간초과가 납니다.
    테케 5번부터

    해결방법
    연산을 줄이기 위해 lMin[], rMin[] 배열을 미리 만들어줍니다.
    1. lMin[] 은 0 ~ i 까지의 최소값을 넣어줍니다.
    [-16, -16, -16, -16, -16, -92, -92, -92, -92, -92]

    2. rMin[] 은 i ~ (len-1) 까지의 최소값을 넣어줍니다.
    [-92, -92, -92, -92, -92, -92, -71, -68, -61, -33]

    3.  i 를 돌며 a[i] 가 rMin[i],rMin[i] 둘 다 보다 크다면 남길수 없는 풍선입니다.


 */

public class Balloon {
    public static void main(String[] args) {
        int[] a= {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        int len = a.length;
        int[] lMin = new int[len];
        lMin[0]=a[0];
        int[] rMin = new int[len];
        rMin[len-1]=a[len-1];

        for(int i=1;i<len;i++){
            if(lMin[i-1]>a[i]){ lMin[i]=a[i]; }
            else{ lMin[i]=lMin[i-1]; }
        }
        for(int i=len-2; i>=0; i--){
            if(rMin[i+1]>a[i]){ rMin[i]=a[i]; }
            else{ rMin[i]=rMin[i+1]; }
        }
        int ret=len;
        for(int i=0;i<len; i++){
            if(a[i]>lMin[i] && a[i]>rMin[i]){ ret-=1; }
        }
        System.out.println(ret);
    }
}
