package tests.failRate;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어수 >> 실패율
        // N:5 / stages: 2,1,2,6,2,4,3,3 / result : 3,4,2,1,5
        // 1:1/8 2:3/7 3:2/4 4:1/2 5:0/1
        // 스테이지 별 실패율 구하기
        HashMap<Integer, Double> fail_rate_map = new HashMap<>(); // 스테이지별 실패율 key:스테이지 value:실패율
        int[] result = new int[N];

        for(int i=1; i<=N; i++) {
            fail_rate_map.put(i, count(stages, i));
        }

        List<Map.Entry<Integer, Double>> fail_rate_list = new ArrayList<>(fail_rate_map.entrySet());
        fail_rate_list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int idx = 0;
        for(Map.Entry<Integer, Double> map : fail_rate_list) {
            result[idx++] = map.getKey();
        }

        return result;
    }
    // 실패율 구하기
    public double count(int[] stages, int stage_num) {
        int failCount = 0;
        int user = 0;

        for(int stage : stages) {
            if(stage == stage_num) {
                failCount++;
            }

            if(stage > stage_num) {
                user++;
            }
        }

        if(failCount + user == 0) {
            return 0;
        }

        double result = (double) failCount / (failCount + user);
        return result;
    }
}