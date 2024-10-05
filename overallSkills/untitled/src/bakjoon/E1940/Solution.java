package bakjoon.E1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] elem = new int[size+1];
        for(int i=1; i<=size; i++) {
            elem[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 1;
        int endIdx = size;
        int count = 0;
        Arrays.sort(elem);

        while(startIdx < endIdx) {
            int sum = elem[startIdx] + elem[endIdx];
            if(sum < num) {
                startIdx++;
            } else if(sum > num) {
                endIdx--;
            } else {
                count++;
                startIdx++;
                endIdx--;
            }
        }

        System.out.println(count);
    }
}
