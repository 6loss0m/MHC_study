package BOJ.PS_0526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
/*
    그리디 문제로 조건에 따른 처리가 어려운 문제였습니다.

    생각해야 될 조건
    1. 양수(양수가 짝수개 있을 때) : 내림차순으로 정렬했을 때 큰 값 2개씩 곱해야 됨.
    2. 양수(양수가 홀수개 있을 때) : 내림차순으로 정렬했을 때 큰 값 2개씩 곱한 후 마지막 숫자를 더해야 됨.
    3. 1이 존재할때 : 1은 다른수와 곱하지 않고 더해야 됨.
    4. 음수 : 오름차순으로 정렬했을 때 작은 값 2개씩 묶어서 계산해야됨 (음수는 작은수 두개를 곱했을 떄 수가 더 커지므로)
    5. 0이 존재 하면서 음수의 개수가 홀수개일때 : 마지막 음수를 0과 곱해서 지워야 함.

 */

public class boj1744_NumTie {
    static int N;
    static ArrayList<Integer> plus, minus;
    static boolean hasZero = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        plus = new ArrayList<>();
        minus = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp<0) {minus.add(tmp);}
            else if(tmp==0) {hasZero = true;}
            else {plus.add(tmp);}
        }

        plus.sort(Comparator.reverseOrder());
        minus.sort(null);
        System.out.println(process());
    }

    static int process(){
        int ret= 0;
        int size = plus.size();

        for(int i=0; i<size-1; i+=2){
            if(plus.get(i)==1 || plus.get(i+1)==1){ ret += plus.get(i)+plus.get(i+1); } // 양수 중에 1이 존재한다면 1*x 보다 1+x 가 더 크므로
            else{ ret+=plus.get(i)*plus.get(i+1); }                                     // 1이 아닌경우에는 곱하는게 더 큼
        }

        if(size%2!=0){ret+= plus.get(size-1);} // 양수가 홀수개 있을 경우 마지막 숫자를 처리해줘야 함.

        if(hasZero){
            if(minus.size()%2==1){ size = minus.size()-1;}  // 음수가 홀수개일 경우, 마지막은 음수 혼자 남으므로 0으로 곱해줘서 지워야함.
            else {size = minus.size();}
       } else {
            size = minus.size();
        }

        for(int i=0;i<size-1; i+=2){ ret+= minus.get(i)*minus.get(i+1); }

        if(size%2!=0){ret+=minus.get(size-1);}  // 음수도 홀수개라면 마지막 음수를 더해줘야 됨.

        return ret;
    }
}
