package personalityType;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // MBTI
        String answer = "";
        Map<String, Integer> surveyMap = new HashMap<>();
        String[] category = {"R", "T", "C", "F", "J", "M", "A", "N"};
        // List<String> category = Arrays.asList(new String[]{"R", "T", "C", "F", "J", "M", "A", "N"});
        // MBTI 별 점수 hashmap으로 점수 구현
        for(String s : category) {
            surveyMap.put(s, 0);
        }
        // 문항 검사 후 점수 부여
        for(int i=0; i<survey.length; i++) {
            String[] tmp = survey[i].split("");

            if(choices[i] == 4) {
                continue;
            }

            if(choices[i] >= 5) {
                surveyMap.put(tmp[1], surveyMap.get(tmp[1])+choices[i]-4);
            } else {
                surveyMap.put(tmp[0], surveyMap.get(tmp[0])+4-choices[i]);
            }
        }
        // 점수 체크 후 성격 유형 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i+=2) {
            if(surveyMap.get(category[i]) >= surveyMap.get(category[i+1])) {
                sb.append(category[i]);
            }  else {
                sb.append(category[i+1]);
            }
        }
        answer = sb.toString();

        return answer;
    }
}