package CodeChallenge;
/*
    구현
 */
public class DotProduct {
    public static void main(String[] args){
        int[] a= {1,2,3,4};
        int[] b= {-3,-1,0,2}; // return 3
        int len = a.length;
        int ret = 0;
        for(int i=0;i<len; i++){ ret+=a[i]*b[i]; }
        System.out.println(ret);
    }
}
