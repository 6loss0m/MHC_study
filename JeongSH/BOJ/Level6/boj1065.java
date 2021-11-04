import java.io.*;

public class boj1065 {
    /*

    풀이요령:
    1~1000 까지의 한수를 미리 구한다.

     */

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int target = 1000;
        int[] arr= new int[target+1];
        arr[1]=1;
        for(int i=2; i<=target ;i++){
            arr[i]=arr[i-1];
            if(isHanSu(i)){arr[i]+=1;}
        }
        int n = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(arr[n]));
        bw.close();
    }
    public static boolean isHanSu(int input){
        String stringInput;
        if(input<100){return true;}
        stringInput = String.valueOf(input);
        int befor = Integer.parseInt(String.valueOf(stringInput.charAt(0)));
        int after = Integer.parseInt(String.valueOf(stringInput.charAt(1)));
        int dif=befor-after;
        for(int i=2; i<stringInput.length(); i++){
            befor = Integer.parseInt(String.valueOf(stringInput.charAt(i-1)));
            after = Integer.parseInt(String.valueOf(stringInput.charAt(i)));
            if(dif!=(befor-after))return false;
        }
        return true;
    }
}
