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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] sectionSum = new long[N];
        long[] remainArr = new long[M];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sectionSum[i] = sectionSum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            int remainer = (int) (sectionSum[i] % M);
            if(remainer == 0) {
                answer++;
            }
            remainArr[remainer]++;
        }

        for(int i=0; i<M; i++) {
            if(remainArr[i] > 1) {
                answer = answer + (remainArr[i] * (remainArr[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
