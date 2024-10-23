package bakjoon.E1715;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // 우선순위큐로 높은 순서대로 정렬이 됨.
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            pq.offer(scanner.nextInt());
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        while(pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            sum += data1 + data2;
            pq.add(sum);

        }

        System.out.println(sum);
    }
}
