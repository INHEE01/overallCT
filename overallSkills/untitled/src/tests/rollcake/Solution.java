package tests.rollcake;

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> m1 = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();

        for(int elem : topping) {
            m2.put(elem, m2.getOrDefault(elem, 0)+1);
        }
        // 1=4, 2=2, 3=1, 4=1
        for(int elem : topping) {
            m1.put(elem, m1.getOrDefault(elem, 0)+1);
            if(m2.get(elem)-1 == 0) {
                m2.remove(elem);
            } else {
                m2.put(elem, m2.get(elem)-1);
            }

            if(m1.size() == m2.size()) {
                answer++;
            }
        }

        return answer;
    }
}