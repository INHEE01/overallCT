package tests.reservingHotels;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        // 예약 시작 시간을 기준으로 정렬
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));

        // 종료 시간을 기준으로 하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);

        for (String[] book : book_time) {
            String[] starts = book[0].split(":");
            String[] ends = book[1].split(":");

            int start_time = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);
            int end_time = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 10; // 청소 시간 10분 추가

            if (!pq.isEmpty() && pq.peek()[1] <= start_time) {
                // 현재 예약의 시작 시간보다 이전 예약의 종료 시간이 빠르거나 같으면 해당 방을 재사용
                pq.poll();
            } else {
                // 새로운 방이 필요함
                answer++;
            }

            // 현재 예약의 시작 시간과 종료 시간을 큐에 추가
            pq.offer(new int[]{start_time, end_time});
        }

        return answer;
    }
}
