package bakjoon.E1253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    // Step 1 : Two Point 사용
    // Step 2 : A[i] + A[j] > num 이면 j--; / A[i] + A[j] < num 이면 i++ / A[i] + A[j] == num 이면 count 증가, i++, j--
    // Condition : 서로 다른 두 수의 합이여야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Initialize Array
        long[] A = new long[num];
        for(int i=0; i<num; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        // ascending order
        Arrays.sort(A);
        // Initialize index
        int count = 0;

        for(int i=0; i<num; i++) {
            long n = A[i];
            int startIdx = 0;
            int endIdx = num-1;
            while(startIdx < endIdx) {
                if(A[startIdx] + A[endIdx] == n) {
                    if(startIdx != i && endIdx != i) {
                        count++;
                        break;
                    } else if(startIdx == i) {
                        startIdx++;
                    } else if(endIdx == i) {
                        endIdx--;
                    }
                } else if(A[startIdx] + A[endIdx] > n) {
                    endIdx--;
                } else {
                    startIdx++;
                }
            }

        }

        System.out.println(count);
    }
}
