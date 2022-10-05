package BLIND_2020;
/*
    생각보다 문자열처리가 햇갈려서 시간이 질질끌렸던 문제입니다.
    문자열을 1~문자열최대길이/2 까지 검사합니다.

    문자열을 n 단위로 나누어보며
    현재 기준 문자열과 같다면 count 를 늘리고,
    다르다면 count 를 초기화하고 기준 문자열도 현재 문자열로 바꾸어줍니다.

    문자열 범위를 초과한다면
    나머지 문자열은 뒤에 붙여줍니다.

 */
public class Compression{
    public static void main(String[] args) {
        String s="abcabcabcabcdededededede";
        int min = s.length();

        for(int i=1;i<=s.length()/2; i++){
            String str = s.substring(0,i);              // 압축 기준 문자열
            StringBuilder tmp = new StringBuilder();    // 압축 기준과 비교할 문자열
            int cnt = 1;

            for(int j=i; j<=s.length(); j+=i){
                String next;
                if( j+i>s.length()){ next = s.substring(j);}    // 문자열이 더 남았다면 나머지를 그냥 붙여줍니다.
                else{ next = s.substring(j,j+i); }              // 문자열 자르기


                if(str.equals(next)){ cnt++; }                  // 기준 문자열과 같다면
                else{
                    if(cnt>1){ tmp.append(cnt); }
                    tmp.append(str);
                    str = next;
                    cnt=1;
                }
            }
            tmp.append(str);        //  for 문 범위를 벗어난 문자열은 그냥 붙여주기
            min = Math.min(min,tmp.length());
        }
        System.out.println(min);
    }
}
