package tests.notCompletedRacer;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        int num = 1;
        for(String p : participant) {
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        for(String c : completion) {
            if(map.get(c)-1 == 0) {
                map.remove(c);
            } else {
                map.put(c, map.get(c)-1);
            }
        }
        String answer = "";
        for(String key : map.keySet()) {
            answer = key;
        }

        return answer;
    }
}