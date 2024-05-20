package tests.diskController.problem;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        // end : 수행 직후의 시간, index : jobs 배열의 인덱스, count : 수행 작업 개수
        int answer = 0, index = 0, end = 0, count = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 시작 시간을 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); // 종료 시간을 기준으로 정렬
        // 모든 작업을 수행할 때까지 반복
        while(count < jobs.length) {

            while(index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }

            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;

            }
        }

        int result = (int) Math.floor(answer / jobs.length);
        return result;
    }
}
