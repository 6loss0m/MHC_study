import java.util.Arrays;

/*
    조건에 따라 배열을 자른 뒤, Arrays.sort 를 사용하여 오름차순으로 정렬하고
    k번 째 수를 찾아냅니다.
    시간복잡도: O(n)
 */


public class KNumber2 {
    public static void main(String args[]){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int arr[] = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
            Arrays.sort(arr);
            answer[i]=arr[commands[i][2]-1];
        }
        for(int i: answer)
            System.out.println(i);
    }
}
