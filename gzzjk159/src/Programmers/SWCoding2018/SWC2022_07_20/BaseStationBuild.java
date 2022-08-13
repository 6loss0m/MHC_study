package Programmers.SWCoding2018.SWC2022_07_20;

public class BaseStationBuild {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 1;//기지국을 설치할 현재 위치
        int idx = 0;//설치된 기지국 인덱스

        while(location <= n) {//위치가 전체 갯수보다 작거나 같을 때까지
            //설치된 기지국 범위 안에 있으면서, 현재 위치가 설치된 기지국의 범위보다 클 때,
            if (idx < stations.length && location >= stations[idx]-w) {
                location = stations[idx]+w+1;//설치된 기지국의 범위보다 +1 큰 위치로 이동
                idx++;//다음 인덱스로 이동
            } else {//설치된 기지국 범위 밖일 때,
                location += 2*w+1;//양쪽으로 범위를 가질 최댓값 +1을 해준다.
                answer++;//기지국을 설치했으므로, 결과값을 추가
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}