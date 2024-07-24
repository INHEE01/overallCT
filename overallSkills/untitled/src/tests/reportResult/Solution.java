package tests.reportResult;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> reportMap = new HashMap<>();
        // Map<String, Integer> noticeMap = new HashMap<>();
        int[] result = new int[id_list.length];
        // 중복 신고 처리
        for(int i=0; i<report.length; i++) {
            String[] tmp = report[i].split(" ");
            map.put(tmp[0], tmp[1]);
        }
        // 신고당한 횟수 카운트 & 신고횟수가 k를 넘어가면 리폿당함
        for(String key : map.keySet()) {
            String value = map.get(key);
            reportMap.put(value, reportMap.getOrDefault(value, 0)+1);
        }
        // 신고당한 횟수 Map 순회
        for(String reportedPerson : reportMap.keySet()) {
            // 신고받은 횟수가 k 이상이라면
            if(reportMap.get(reportedPerson) >= k) {
                // 해당 유저를 신고한 사람들이 통보를 받는 횟수가 1 증가한다
                for(int i=0; i<id_list.length; i++) {
                    if(map.get(id_list[i]).equals(reportedPerson)) {
                        result[i]++;
                    }
                }
            }
        }

        return result;
    }
}