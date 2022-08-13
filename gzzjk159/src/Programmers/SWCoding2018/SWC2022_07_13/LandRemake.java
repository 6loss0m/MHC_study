package Programmers.SWCoding2018.SWC2022_07_13;

public class LandRemake {
    public static class Solution {
        public long solution(int[][] land, int P, int Q) {
            long answer = 0;
            long end = land[0][0];
            long start = land[0][0];
            for(int i=0; i<land.length; i++){
                for(int j=0; j<land.length; j++){
                    end = Math.max(end, land[i][j]);
                    start = Math.min(start, land[i][j]);
                }
            }
            long mid;
            while(start<=end){
                mid = (start+end)/2;

                long leftcost = Cost(land,mid,P,Q);
                long rightcost = Cost(land, mid+1,P,Q);
                if(leftcost> rightcost){
                    answer = rightcost;
                    start = mid + 1;
                }
                else{
                    answer = leftcost;
                    end = mid -1;
                }
            }
            return answer;
        }
        static long Cost(int[][] land, long height,int P, int Q){
            long res = 0;
            for(int i=0; i<land.length; i++){
                for(int j=0; j<land.length; j++){
                    if(land[i][j]<height){
                        res += (height-land[i][j])*P;
                    }
                    else if(land[i][j]>height){
                        res += (land[i][j]-height)*Q;
                    }
                }
            }
            return res;
        }
    }
}
