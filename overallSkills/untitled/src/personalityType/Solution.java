package personalityType;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // Map 구현
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++) {
            int value = choices[i];

            if(value > 0 && value < 4) {
                char ch = survey[i].charAt(0);
                map.put(ch, map.getOrDefault(ch, 0)+4-value);
            } else if (value > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.getOrDefault(ch, 0)+value-4);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');

        return sb.toString();
    }
}