    package tests.moreSpicy.problem;

import java.util.PriorityQueue;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        // scoville 배열에 있는 모든 언소를 스코빌 지수 K 이상이 되도록 만들기
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(); // 역순으로 나가기 : new PriorityQueue<>(Collections.reverseOrder())
        for(int i=0; i<scoville.length; i++) {
            q.add(scoville[i]);
        }

        while(q.element() < K) {
            if(q.size() == 1) {
                return -1;
            }

            q.add(q.poll() + (q.poll() * 2));
            answer++;
        }

        return answer;
    }
}
