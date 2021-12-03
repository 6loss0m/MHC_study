
/*

    테스트케이스가 통과안되서 코드를 고치다보니 조금 더럽게 풀었습니다.
    문제 아이디어 :
        여벌이 있는 사람이 도난당한 사람에게 빌려주면 그 옷을 -1로 바꿔줍니다.(0이 아닌 -1로 한 이유 : 0으로하면 1번친구가 도난 당했을 때 잘못된 결과값이 나옴)
    시행착오 :
        제한사항에 여벌이있는 사람이 도난당했을 경우 자기가 먼저 가져가게됩니다.
        때문에 n=5 lost={1,2,3} reserve={2,3,4}
        최적의 답: 5
        제한사항 준수 답: 4

    1. 기존의 아이디어에서 여벌이있는 사람이 도난당했을 경우 자기가 먼저 가져가게 합니다.
        reserve 는 -2 , lost 는 0 으로 넣어줌 :   이중계산을 피하기 위해. reserve 가 -2인 이유는 lost 에 0을 넣기 때문에
    2. 기존의 아이디어에서 reserve 는 -2 로 바꾸어줍니다.

    시간복잡도 : O(n^2)

 */

public class TrainingClothes {
    public static void main(String args[]){
        int n=5;
        int[] lost={1,2,3};
        int[] reserve={2,3,4};
        int answer=0;
        int sol =0;

        for(int i=0; i<lost.length; i++){                                           // 여벌이있고 도난당한 사람.
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){ lost[i]=0;reserve[j]=-2; sol++;}
            }
        }

        loop:
        for(int i=0; i<lost.length; i++ ){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-reserve[j])==-1 || (lost[i]-reserve[j])==1){reserve[j]=-2; sol++; } // 자기 앞뒤 사람에게 빌려주는 경우.
                if(sol == lost.length){break loop;}                                             // 무의미한 반복문 탈출
            }
        }
        answer=n-lost.length+sol;       // 답 = 전체인원 - 잃어버린사람 + 빌린사람
        System.out.println(answer);
    }
}
