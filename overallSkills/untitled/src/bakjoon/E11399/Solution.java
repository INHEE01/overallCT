package bakjoon.E11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        for(int i=0; i<num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort(arr, Collections.reverseOrder());
        int result = 0;
        for(int i=0; i<arr.length; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
