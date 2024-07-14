package tests.findPrime;

import java.util.*;

class Solution {
    public static Set<Integer> set;
    public static boolean visited[] = new boolean[7];

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers, "", 0);

        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(String numbers, String s, int depth) {
        if(depth > numbers.length()) {
            return;
        }

        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for(int i=2; i<=(int) Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;
    }
}