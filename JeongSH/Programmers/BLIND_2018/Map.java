package BLIND_2018;
/*
    구현 문제입니다.
    두 지도를 겹쳐놓는 방식이 비트연산의 or 연산과 같아
    or 연산으로 두 지도를 바로 겹쳐서 보고 결과값을 만들었습니다.

 */

public class Map {
    public static void main(String[] args) {
        int n =5;
        int[] arr1={9, 20, 28, 18, 11};
        int[] arr2={30, 1, 21, 17, 28};
        String[] ret = new String[n];

        for(int i=0;i<n;i++){
            String binary = Integer.toBinaryString(arr1[i]|arr2[i]);    // 겹치기
            binary = "0".repeat(n-binary.length())+binary;                // 지도 칸 수 맞추기
            binary = binary.replaceAll("1","#");        // 1 -> "#"
            binary = binary.replaceAll("0"," ");        // 0 -> " "
            ret[i]= binary;
        }
        for(String s : ret){ System.out.println(s); }
    }
}
