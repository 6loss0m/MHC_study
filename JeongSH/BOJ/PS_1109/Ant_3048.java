package BOJ.PS_1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/*
    문제 접근
    T의 범위가 좁기때문에, 단순 구현문제라 생각하였습니다.
    저는 각각의 개미가 속한 집단을 검사하여 점프를 해야하는 경우에는 두 개미의 위치를 바꾸는식으로 생각하였습니다.
    예상 시간 복잡도는 O(TxN))  // N : N1+N2

    풀이
    Set<char> leftAnt, rightAnt
    각각을 선언하여 각각 집단에 속하는 개미를 넣어줍니다.

    Arraylist<> ants
    선언하여 개미들의 모든 위치를 넣어줍니다.
    ex) CBA/DEF

    1. "자신의 앞에 반대 방향으로 움직이던 개미가 있는 경우."
        = i 의 개미가 왼쪽 집단에 속하고, i+1의 개미가 오른쪽 집단에 속할 경우.
        문제의 조건을 풀어서 설명하면 이런 조건을 만족할 경우 두 개미의 위치를 바꿔줍니다.
        두 개미의 위치를 바꿨으므로 i+1

    2. 시간 T = min(개미의 총마리수,t)
        두 집단의 개미가 모두 자리를 바꾸어 지나쳐간다면 더이상의 시간은 무의미하기 때문.

    테스트 케이스
    3 4
    JLA
    CRUO
    0 ~ 50 // 임의의 수


 */

public class Ant_3048 {
    static ArrayList<Character> ants = new ArrayList<>();
    static Set<Character> leftAnt = new HashSet<>();
    static Set<Character> rightAnt = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int leftLen = Integer.parseInt(input[0]);
        int rightLen = Integer.parseInt(input[1]);

        String in = br.readLine();
        for(int i=leftLen-1;i>=0;i--){
            ants.add(in.charAt(i));
            leftAnt.add(in.charAt(i));
        }
        in = br.readLine();
        for(int i=0;i<rightLen; i++){
            ants.add(in.charAt(i));
            rightAnt.add(in.charAt(i));
        }

        int T = Integer.parseInt(br.readLine());

        int len = ants.size();
        T = Math.min(T,len);
        for(int t=0; t<T; t++){
            for(int i=0;i<len-1;i++){
                // i 가 왼쪽 집단에 속하고, i+1 가 오른쪽 집단에 속한다면
                if(leftAnt.contains(ants.get(i)) && rightAnt.contains(ants.get(i+1))){
                    swap(i,i+1);    // 자리 바꾸기
                    i++;
                    continue;
                }
            }
        }
        print();
        return;


    }
    static void swap(int index, int index2){
        Character a = ants.get(index);
        ants.set(index,ants.get(index2));
        ants.set(index2,a);
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(Character c: ants){ sb.append(c); }
        System.out.println(sb);
    }
}
