package tests.hallOfFame;

import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);

            // 큐의 크기가 k를 넘으면 최솟값 제거
            if (queue.size() > k) {
                queue.poll();
            }

            // 명예의 전당의 최하위 점수 기록
            answer[i] = queue.peek();
        }

        return answer;
    }
}
