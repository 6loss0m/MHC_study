package Programmers.BlindRecruitment_2018;

import java.util.Arrays;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer;
        answer= new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            str1 = makestr(n,str1);
            str2 = makestr(n,str2);
            for (int j = 0; j < n; j++) {
                if(str1.charAt(j)=='1'||str2.charAt(j)=='1'){
                    sb.append("#");
                }
                else{
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public static String makestr(int n , String str){
        StringBuilder sb = new StringBuilder();
        if(n==str.length()){
            return str;
        }
        else {
            sb.append("0".repeat(n - str.length()));
            sb.append(str);
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        SecretMap sm = new SecretMap();
        System.out.println(Arrays.toString(sm.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
    }
}
