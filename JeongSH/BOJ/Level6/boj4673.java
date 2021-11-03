import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class boj4673 {
    /*

    풀이요령:
    boolean 배열 생성 후
    1~10000까지의 한 사이클 셀프넘버를 돌리고
    1개라도 만들어진 숫자는 셀프넘버의 조건을 충족하지않으므로 해당 숫자를 체크한다.

     */
    public static void main(String args[])throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target=10000;
        boolean[] booleans=new boolean[target+1];
        int index=1;
        int res=0;

        while(index<=target){
            res=selfNumber(index);
            if(res>target){index++; continue;}
            booleans[selfNumber(index)]=true;
            index++;

        }
        for(int i=1;i<=target; i++){
            if(booleans[i]==false) bw.write(String.valueOf(i)+"\n");
        }
        bw.close();

    }
    public static int selfNumber(int n){
        String stringN = String.valueOf(n);
        int sum=n;
        for(int i=0; i<stringN.length(); i++){
            sum+=Integer.parseInt(String.valueOf(stringN.charAt(i)));
        }
        return sum;
    }
}