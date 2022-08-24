package CodeChallenge3;

public class Sum {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        boolean[] num = new boolean[10];
        for(int n : numbers){num[n]=true;}
        int ret = 0;
        for(int i=1;i<10;i++){if(!num[i]){ret+=i;}}
        System.out.println(ret);
    }
}
