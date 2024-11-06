package bakjoon.E1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 0;
        String s = br.readLine();
        String[] str = s.split("-");

        for(int i=0 ;i<str.length; i++) {
            int nextSum = getSum(str[i]);

            if(i==0) {
                min = min + nextSum;
            } else {
                min = min - nextSum;
            }
        }

        System.out.println(min);
    }

    public static int getSum(String s) {
        int sum = 0;
        String[] tmp = s.split("[+]");

        for(int i=0; i<tmp.length; i++) {
            sum += Integer.parseInt(tmp[i]);
        }

        return sum;
    }
}
