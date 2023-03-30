package BOJ.PS_0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
    조건이 많아 보이지만
    막상 조건을 잘 파악하면 그대로 구현만 하면 되는문제 입니다.

    1. 사진틀에 사진이 있다.
        1-1. 투표수 +1

    2. 사진틀에 사진이 없다.
        2-1. 사진틀 자리가 남음.
            2-1-1. 사진을 추가.
        2-2. 사진틀 자리가 없음.
            2-2-1. 정렬한 뒤 가장 우선순위가 낮은 사진자리에 추가

 */

public class boj1713_Candidate {
    static int N;
    static int voteCnt;
    static ArrayList<Candidate> frames;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        voteCnt = Integer.parseInt(br.readLine());
        frames = new ArrayList<>();

        String[] split = br.readLine().split(" ");
        for(int i=0;i<voteCnt;i++) {
            int currVoteNum = Integer.parseInt(split[i]);
            boolean isInFrames = false;

            //  1. 사진틀에 사진이 있다.
            for (int j = 0; j < frames.size(); j++) {
                if (frames.get(j).num == currVoteNum) {
                    frames.set(j, new Candidate(currVoteNum, frames.get(j).votesGot + 1, frames.get(j).turn));
                    isInFrames = true;
                    break;
                }
            }

            //  2. 사진틀에 사진이 없다.
            if (!isInFrames) {
                //  2-1. 사진틀 자리가 남음.
                if (frames.size() < N) frames.add(new Candidate(currVoteNum, 1, i));

                //  2-2. 사진틀 자리가 없음.
                else {
                    // 시간오름차순
                    Collections.sort(frames, Comparator.comparing(Candidate::getTurn));
                    // 득표오름차순
                    Collections.sort(frames, Comparator.comparing(Candidate::getVotesGot));

                    frames.set(0, new Candidate(currVoteNum, 1, i));
                }
            }
        }
        Collections.sort(frames, Comparator.comparing(Candidate::getNum));
        for (int i = 0; i < frames.size(); i++) {
            if (i == 0) System.out.print(frames.get(0).num + "");
            else System.out.print(" " + frames.get(i).num);
        }
    }
    static class Candidate {
        int num;
        int votesGot;
        int turn;

        public Candidate(int num, int votesGot, int turn) {
            this.num = num;
            this.votesGot = votesGot;
            this.turn = turn;
        }
        public int getNum() {
            return num;
        }

        public int getVotesGot() {
            return votesGot;
        }

        public int getTurn() {
            return turn;
        }
    }
}
