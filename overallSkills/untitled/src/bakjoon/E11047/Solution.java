package bakjoon.E11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] coins = new int[num];
        int count = 0;

        // 동전 입력
        for (int i = 0; i < num; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 그리디 알고리즘: 큰 동전부터 사용
        for (int i = num - 1; i >= 0; i--) {
            if (coins[i] <= target) {
                count += target / coins[i];
                target %= coins[i];
            }
            if (target == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}