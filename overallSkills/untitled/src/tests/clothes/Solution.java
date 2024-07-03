package tests.clothes;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clothesMap = new HashMap<>();
        // 옷종류- 개수를 구하기
        for(String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0)+1);
        }
        // key 순회
        for(String key : clothesMap.keySet()) {
            int count = clothesMap.get(key);
            answer *= (count+1);
        }
        // 아무것도 입지 않는 경우 제외
        return answer-1;
    }
}