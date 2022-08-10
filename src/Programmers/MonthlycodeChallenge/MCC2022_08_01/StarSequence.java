package Programmers.MonthlycodeChallenge.MCC2022_08_01;


public class StarSequence {
    public int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];//a 원소의 등장횟수
        for (int k : a) {
            count[k]++;
        }
        for (int i = 0; i < count.length; i++) {//공통된 원소로 선택할 값
            if(count[i]==0) continue;//배열에 없으면 공통된 원소가 아님
            if(count[i]<=answer) continue;//가장 많이 사용된 횟수보다 작으면 긴 스타수열 만들수 x
            int tmp = 0;//해당 숫자가 사용된 횟수

            for (int j = 0; j < a.length-1; j++) {//배열 탐색 반복
                //인접한 2개의 값을 봤을 때 ,어느 하나라도 공통된 원소를 가지고 있어야한다.
                if(a[j] != i && a[j+1] !=i)continue;
                //인접한 2개의 값이 동일하지는 않은지 - 스타수열의 조건 3
                if(a[j] == a[j+1])continue;
                tmp++; j++;
            }
            answer = Math.max(answer, tmp);//현재까지 스타수열을 만드는데 가장 많이 사용된 횟수
        }return answer*2;//공통된 원소가 사용될 때마다, 인접한 값 하나씩을 더 가지고 있으므로
    }
    public static void main(String[] args) {

    }
}
