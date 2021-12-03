
/*
    문제 아이디어:
    연속된 A가 나올 경우 왼쪽으로 이동하는 경우와 직진하는경우 더 작은 이동을 선택합니다.
    시간복잡도: O(n^2)

 */



public class Joystick {
    public static void main(String args[]) {
        String name = "BBAAB";
        int answer = 0;
        int len = name.length();
        int min = len-1;                                                            // 직진하는 경우
        for(int i=0; i<name.length(); i++){
            answer += Math.min((name.charAt(i) - 'A'),('Z' - name.charAt(i)+1));    // 문자 변환.
                                                                                    // i는 현재 위치
            int next = i+1;
            while(next < len && name.charAt(next)=='A'){next++;}                    // i+1부터 연속된 A의 끝 위치를 알기위해
            min = Math.min(min,(i*2)+ (len- next));                                 // i+1부터 연속된 A의 끝 위치 전까지만 이동하면 됩니다.

        }
        answer+=min;


        System.out.println(answer);

    }

}
