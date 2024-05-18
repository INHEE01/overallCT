package tests.wardrobe.problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Wardrobe {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] w : clothes) {
            map.put(w[1], map.getOrDefault(w[1], 0) + 1);
        }

        Iterator<Integer> it = map.values().iterator();

        while (it.hasNext()) {
            answer *= it.next() + 1;
        }

        return answer-1;
    }
}
