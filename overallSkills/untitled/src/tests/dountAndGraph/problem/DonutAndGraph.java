package tests.dountAndGraph.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DonutAndGraph {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodeCnt = new HashMap<>();
        int[] answer = {0, 0, 0, 0}; //
        int[] cnts;
        for(int key : nodeCnt.keySet()) {
            cnts = nodeCnt.get(key);

            if(cnts[0] >= 2 && cnts[1] == 0 ) {
                answer[0] = key;
            }else if(cnts[0] == 0 && cnts[1] > 0) {
                answer[2]++;
            }else if(cnts[0] >= 2 && cnts[1] >= 2) {
                answer[3]++;
            }

        }
        return answer;
    }
}
