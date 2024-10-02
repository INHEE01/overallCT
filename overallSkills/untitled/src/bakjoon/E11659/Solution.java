package bakjoon.E11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // Step 1 : Enter Number of Data & Questions
    // Step 2 : Enter List
    // Step 3 : Enter Questions
    // Step 4 : Print Result
    // 구간합 : S[j] - S[i-1] / i에서 j까지 구간 합
    public static void main(String[] args) throws IOException {
        // Enter Number of Data & Questions
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dNum = Integer.parseInt(st.nextToken());
        int qNum = Integer.parseInt(st.nextToken());

        long[] sectionSum = new long[dNum+1];
        // Enter List
        st = new StringTokenizer(br.readLine());
        // Enter Questions
        for(int i=1; i<=dNum; i++) {
            sectionSum[i] = sectionSum[i - 1] + Integer.parseInt(st.nextToken());
            System.out.println("sectionSum[" + i + "] : " + sectionSum[i]);
        }
        // Print Result
        for(int i=0; i<qNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(sectionSum[b] - sectionSum[a-1]);
        }
    }

}
