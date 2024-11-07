package bakjoon.E1456;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // 1. 소수 먼저
    // 2. N 제곱 
    static boolean[] prime;
    static boolean[] almostPrime;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        setPrime(B);
        System.out.println(setAlmostPrime(A, B));
    }
    // 소수, false = 소수, true = 소수가 아님
    public static void setPrime(int M) {
        prime = new boolean[M+1];
        for(int i=2; i<=Math.sqrt(M); i++) {
            if(prime[i]) {
                continue;
            }
            
            for(int j=i+i; j<=M; j=j+i) {
                prime[j] = true;
            }
        }
    }
    // 거의 소수
    public static int setAlmostPrime(int N, int M) {
        almostPrime = new boolean[M+1];
        int count = 0;

        for(int i=2; i<=Math.sqrt(M); i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=M; j*=i) {
                    almostPrime[j] = true;
                }
            }
        }

        for(int i=N; i<=M; i++) {
            if(almostPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
