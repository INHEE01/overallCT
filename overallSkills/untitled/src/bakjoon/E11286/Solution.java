package bakjoon.E11286;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // x=0 이면 절대값이 가장 작은 수를 출력하고 절대값이 같을 경우 작은 수를 출력
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) {
                return o1> o2 ? 1 : -1;
            } else {
                return first_abs - second_abs;
            }
        }); // 우선순위 큐에 정렬 기준 적용

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i=0; i<n; i++) {
            int elem = scanner.nextInt();
            if(elem == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(elem);
            }
        }
    }
}
