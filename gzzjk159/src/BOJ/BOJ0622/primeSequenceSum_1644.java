package BOJ.BOJ0622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class primeSequenceSum_1644 {
    static boolean[] prime = new boolean[4000001];
    static ArrayList<Integer> primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 4000000;
        prime[0] = prime[1] = true;
        for (int i = 2; i*i <= max ; i++) {
            if(!prime[i]){
                for (int j = i*i; j <= max ; j+=i) {
                    prime[j] = true;
                }
            }
        }
        primes = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            if(!prime[i]){
                primes.add(i);
            }
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        int answer = 0;
        while(true){
            if(sum>=n){
                sum -= primes.get(start++);
            }
            else if(end==primes.size()){
                break;
            }
            else{
                sum += primes.get(end++);
            }
            if(sum == n){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
//        int answer = 0;
//        for (int i = 2; i <= max; i++) {
//            int sum = 0;
//            if(n<i){
//                break;
//            }
//            for (int j = i; j <= max; j++) {
//                if(!prime[j]){
//                    sum+=j;
//                }
//                if(sum==n){
//                    ++answer;
//                }
//                if(sum>n){
//                    break;
//                }
//            }
//        }
