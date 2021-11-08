import java.util.HashSet;
import java.util.Set;
/*
    시행착오한 내용.
    1. 생각못한 것.
        - 예를 들어 N을 4개 가지고 사칙연산했을 때 가능한 조합은
            1. (N=3) 에서 사칙연산한 경우.
            2. (N=2)와 (N=2) 와 사칙연산한 경우.
            와 같이 두 가지 이상이 존재 할 수 있음.
            
        - 기존 방식.
            bottomUp 1 부터 ~ N 까지 연산하는  과정에서 n으로 n+1 채워넣고 , n+1로 n+2 를 채워넣고 , n+3로 n+4를 채워넣음
            이는 잘못된 방식.
            반례 ) N=5, number=80
            (5x5)+(55) = 80   , N=4
            n+2 와 n+2 로 최적의 n+4를 만들 수 있음.
            n+3에서 사칙연산을 통해 n+4는 만들수 없음.
            
            
    2. 바꾼 방식
        - count == N사용 횟수.
        - count = 3 을 구하기 위해.
            count =1 , count =2 모두사용
          count = 4 을 구하기 위해.
            count =1, count =2 , count =3 모두 사용.
            ...
            ..
            .
            
 */
public class Nnumber2 {
    static int MAX_N = 8;

    public static void main(String args[]) {
        int N = 5;
        int number = 80;
        int answer = -1;
        Set<Integer>[] setArr = new Set[9];

        int d = N;
        for (int i = 1; i <= MAX_N; i++) {
            setArr[i] = new HashSet<>();
            setArr[i].add(d);
            d = d * 10 + N;
        }
        for(int i=1; i<=MAX_N; i++){
            for(int j=1; j<i; j++){
                for(Integer a : setArr[j]){
                    for(Integer b: setArr[i-j]){
                        setArr[i].add(a+b);
                        if(a-b>0)
                        {setArr[i].add(a-b);}
                        if(b-a>0)
                        {setArr[i].add(b-a);}
                        setArr[i].add(a*b);
                        if(b!=0){
                            setArr[i].add(a/b);
                        }
                        if(a!=0){
                            setArr[i].add(b/a);
                        }
                    }
                }
            }
        }
        for(int i=1; i<=MAX_N; i++){
            if(setArr[i].contains(number)){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
