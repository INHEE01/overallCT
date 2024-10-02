package bakjoon.E10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N];
        long[] C = new long[M];

        long answer = 0;

        S[0] = scanner.nextInt();
        for(int i=1; i<N; i++) {
            S[i] = S[i-1] + scanner.nextInt();
        }

        long start = System.currentTimeMillis();

        for(int i=0; i<N; i++) {
            int remainer = (int) (S[i] % M);
            if(remainer == 0) {
                answer++;
            }

            C[remainer]++;
        }

        for(int i=0; i<M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(answer);

        long end = System.currentTimeMillis();
        System.out.println("수행시간: " + (end - start) + " ms");
    }
}
