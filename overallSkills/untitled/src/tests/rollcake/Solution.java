package tests.rollcake;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer=0;
        HashSet<Integer> m1 = new HashSet<>();
        HashSet<Integer> m2 = new HashSet<>();

        int idx=1;
        for(int i=0; i<topping.length-1; i++) {
            for(int j=0; j<topping.length; j++) {
                if(j < idx) {
                    m1.add(topping[j]);
                } else {
                    m2.add(topping[j]);
                }
            }

            int c1 = m1.size();
            int c2 = m2.size();
            if(c1 == c2) {
                answer++;
            }

            idx++;
        }

        return answer;
    }
}