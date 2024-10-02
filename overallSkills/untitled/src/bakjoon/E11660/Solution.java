package bakjoon.E11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // Step 1 : Enter Size of Array & Number of Questions
    // Step 2 : Enter element of Array
    // Step 3 : Enter Quesetions
    // Step 4 : Print Result

    // 구간합 : S[j] - S[i-1] / i부터 j까지의 구간합
    public static void main(String[] args) throws IOException {
        // Enter Size of Array & Number of Questions
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // Enter element of Array
        int arrSize = Integer.parseInt(st.nextToken());
        int qNum = Integer.parseInt(st.nextToken());

        long[][] sectionSum = new long[arrSize+1][arrSize+1];
        for(int i=1; i<=arrSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=arrSize; j++) {
                sectionSum[i][j] = sectionSum[i][j-1] + Integer.parseInt(st.nextToken());
                System.out.print(sectionSum[i][j] + " ");
            }
            System.out.println();
        }
        // Enter Quesetions & Print Result
        for(int i=0; i<qNum; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            long result = 0;
            for(int n=x1; n<=x2; n++) {
                result += sectionSum[n][y2] - sectionSum[n][y1-1];
            }

            System.out.println(result);
        }
    }
}
