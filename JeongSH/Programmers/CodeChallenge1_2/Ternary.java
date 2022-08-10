package CodeChallenge1_2;
/*
    구현문제
 */
public class Ternary {
    public static void main(String[] args) {
        int n = 45; // result : 7
//        int n = 125; // result : 229
        System.out.println(Integer.parseInt(toReverseTernary(n),3));
    }
    static String toReverseTernary(int n){
        StringBuffer sb= new StringBuffer();
        while (n>=3){
            sb.append(n%3);
            n=n/3;
        }
        sb.append(n);
        return sb.toString();
    }
}
