import java.util.Arrays;

/*

    문제가 이해하기 어려웠지만 제시한 사항에 맞춰 따라서 만들면 됩니다.
    문제 접근:
    h를 점점 늘려가면서 조건을 만족하는지 확인하고, 만족하지 않는다면 만족했었던 마지막 h를 반환합니다.

    어려웠던점:
    1. 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
        여기에서 '나머지 논문이 h번 이하 인용되었다면' 이라는 조건이있는데, 이 조건은 사실상 무의미한 조건이라 코딩을 하는데 발목을 붙잡혔습니다.

        h번 이상 인용된 논문이 h편 이상라면,
        나머지(h번 미만 인용된)논문이 h번 이하 인용되었다면 이라는 말로 바꿀 수 있습니다.
        당연히 h번 미만 인용된 논문은 h번 이하 인용되었습니다....

    시간복잡도: O(n^2)

 */


public class HIndex2 {
    public static void main(String[] args){
        int[] citations ={3, 0, 6, 1, 5};
        Arrays.sort(citations);                                         // h번 이상 인용된 논문의 갯수를 세기위해 오름차순 정렬
        int h=0;
        while(true){
            int i=0;
            while(i<citations.length){if(citations[i]>=h)break;i++;}    // (h번 미만 인용된 논문의)수를 찾기위해
            int citation_More_Than_H = citations.length-i;              // (h번 이상 인용된 논문의 수) == 전체길이 - (h번 미만 인용된 논문의수)
            if(h>citation_More_Than_H ){ h--; break;}                   // h가 (h번 이상 인용된 논문의 수) 보다 크다면 이전 h값이 정답이 됩니다.
            h++;
        }
        System.out.println(h);
    }
}

// 테스트 케이스 추가
//const data = [
//        { input: [3, 0, 6, 1, 5], answer: 3 },
//        { input: [0, 0, 0, 0, 0], answer: 0 },
//        { input: [0, 0, 0, 0, 1], answer: 1 },
//        { input: [9, 9, 9, 12], answer: 4 },
//        { input: [9, 7, 6, 2, 1], answer: 3 }, // from Wikipedia
//        { input: [10, 8, 5, 4, 3], answer: 4 }, // from Wikipedia
//        { input: [25, 8, 5, 3, 3], answer: 3 }, // from Wikipedia
//        { input: [1, 1, 5, 7, 6], answer: 3 },
//        { input: [0], answer: 0 },
//        { input: [0, 0], answer: 0 }
//        ]