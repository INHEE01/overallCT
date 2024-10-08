package bakjoon.E2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll(); // 맨 앞의 숫자 버리기
            int elem = queue.poll();
            queue.offer(elem);
        }

        System.out.println(queue.peek());
    }
}
