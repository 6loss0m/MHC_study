package BOJ.PS_0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
    아이디어
    오름차순 정렬을 한 뒤,
    num1.append (arr[i-1])
    num2.append (arr[i])
    번갈아가며 숫자를 붙여줍니다.

    주의
    시작 숫자로 0이 올 수 없으므로 예외처리를 해줘서 해결하였습니다.

 */

public class boj9440_SumNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        String input;
        while ( !"0".equals(input = br.readLine())){
            String[] in = input.split(" ");
            int N = Integer.parseInt(in[0]);

            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(in[i+1]));
            }
            Collections.sort(arr);
            num1.setLength(0);
            num2.setLength(0);

            if(N%2==1){
                for(int i=0;i<arr.size();i++){
                    if(arr.get(i)!=0){
                        num1.append(arr.get(i));
                        arr.remove(i);
                        break;}
                }
                for(int i=0;i<arr.size();i++){
                    if(arr.get(i)!=0){
                        num2.append(arr.get(i));
                        arr.remove(i);
                        break;}
                }
                for (int i = 1; i < arr.size(); i+=2) {
                    num1.append(arr.get(i-1));
                    num2.append(arr.get(i));
                }
                num1.append(arr.get(arr.size()-1));
            }
            else{
                for(int i=0;i<arr.size();i++){
                    if(arr.get(i)!=0){
                        num1.append(arr.get(i));
                        num2.append(arr.get(i+1));
                        arr.remove(i);
                        arr.remove(i);
                        break;
                    }
                }
                for (int i = 1; i < arr.size(); i+=2) {
                    num1.append(arr.get(i-1));
                    num2.append(arr.get(i));
                }
            }
//            System.out.println(arr.toString());
//            System.out.println("num1:"+num1);
//            System.out.println("num2:"+num2);
            System.out.println(Integer.parseInt(num1.toString())+Integer.parseInt(num2.toString()));
        }
    }
}
