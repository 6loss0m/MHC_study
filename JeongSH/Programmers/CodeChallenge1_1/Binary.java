package CodeChallenge;
/*
    구현.
 */

public class Binary {
    public static void main(String[] args) {
        String s = "01110";
        int[] ret = new int[2];

        while (!s.equals("1")){
            int count_1 = get1Count(s);
            int count_0 = s.length()-count_1;
            ret[1]+=count_0;
            s= Integer.toBinaryString(count_1);
            ret[0]+=1;
        }
        System.out.println(ret[0]+", "+ret[1]);
    }
    static int get1Count(String s){
        int len = s.length();
        int ret = 0;
        for(int i=0;i<len;i++){ ret+=s.charAt(i)-'0'; }
        return ret;
    }
}
