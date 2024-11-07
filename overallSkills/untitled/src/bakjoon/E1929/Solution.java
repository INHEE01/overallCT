package bakjoon.E1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        // Initialize array's element
        for(int i=2; i<=N; i++) {
            arr[i] = i;
        }
        // Sieve of Eratosthenes
        for(int i=2; i<=Math.sqrt(N); i++) {
            if(arr[i] == 0) {
                continue;
            }

            for(int j=i+i; j<=N; j=j+i) {
                arr[j] = 0;
            }
        }
        // output
        for(int i=M; i<=N; i++) {
            if(arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }
}
