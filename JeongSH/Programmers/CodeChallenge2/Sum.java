package CodeChallenge2;
/*
    부호를 보고 *1 를 할지, *-1 를 할지 정합니다.
 */

public class Sum {
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        int ret = 0;
        for(int i=0;i<absolutes.length;i++){ ret = ret + (signs[i]==true ? absolutes[i]*1 : absolutes[i]*-1); }
        System.out.println(ret);
    }
}
