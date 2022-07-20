package SummerWinter_2018_2;
/*

    처음엔 어렵게 생각했는데,
    기준 점을 정하고 기준점으로부터(i)
    형은 i-- , 동생은 i++ 하면서 서로의 합이 같아지는지 확인하면 됩니다.
      <- i ->
    1  1  2  3

 */

public class Cookie {
    public static void main(String[] args) {
        int[] cookie = {1,1,2,3};
        int len = cookie.length;
        int max =0;
        for(int i=1;i<len; i++){
            int o=cookie[i-1];  // i를 기준으로 형은 i-1 부터
            int oIdx=i-1;
            int y=cookie[i];    // i를 기준으로 동생은 i 부터
            int yIdx=i;
            while (true){
                if(o==y){
                    max=Math.max(o,max);
                    if(yIdx+1==len && oIdx==0 ){ break; }
                    if((yIdx+1)!=len){ y+=cookie[++yIdx]; continue;}
                    o+=cookie[--oIdx];
                }
                else if(o>y){
                    if(yIdx+1==len){ break; }
                    y+=cookie[++yIdx];
                }
                else {
                    if(oIdx==0){ break; }
                    o+=cookie[--oIdx];
                }
            }
        }
        System.out.println(max);
    }
}
