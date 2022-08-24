package CodeChallenge3;

public class Remainder {
    public static void main(String[] args) {
        int n = 10;
        for(int i=2;i<n;i++){
            if(n%i==1){System.out.println(i); return;}
        }
    }
}
