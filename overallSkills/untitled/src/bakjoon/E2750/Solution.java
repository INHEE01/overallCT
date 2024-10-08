package bakjoon.E2750;

import java.util.Scanner;

public class Solution {
    // 정렬 직접 구현
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sortArr = new int[n];
        for(int i=0; i<n; i++) {
            sortArr[i] = scanner.nextInt();
        }

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1-i; j++) {
                if(sortArr[j] > sortArr[j+1]) {
                    int tmp = 0;
                    tmp = sortArr[j+1];
                    sortArr[j+1] = sortArr[j];
                    sortArr[j] = tmp;
                }
            }
        }

        for(int i=0; i<n; i++) {
            System.out.println(sortArr[i]);
        }
    }
}
