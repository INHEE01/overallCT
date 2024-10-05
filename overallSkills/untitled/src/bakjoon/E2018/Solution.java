package bakjoon.E2018;

import java.util.Scanner;

public class Solution {
    // Step 1 : startIdx 와 endIdx 를 설정.
    // Step 2 : endIdx 를 우측으로 이동하면서 sum에 더함. / sum이 N과 같아진다면 count 1 증가시킨 후 startIdx를 1 증가시킨 후 startidx = endIdx 로 만들기
    // Step 3 : N/2 범위 까지만 진행 후 1 더하기. (자기자신)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int startIdx = 1;
        int endIdx = 1;
        int count = 1;
        int sum = 1;

        while (endIdx != num) {
            if (sum == num) {
                count++;
                endIdx++;
                sum = sum +endIdx;
            } else if(sum > num) {
                sum = sum - startIdx;
                startIdx++;
            } else {
                endIdx++;
                sum = sum + endIdx;
            }
        }

        System.out.println(count);
    }
}

