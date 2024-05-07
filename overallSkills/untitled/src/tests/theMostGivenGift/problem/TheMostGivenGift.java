package tests.theMostGivenGift.problem;

import java.util.Arrays;
import java.util.List;

public class TheMostGivenGift {
    // Step 1. 친구에게 index 부여
    // Step 2. 선물을 주고 받은 기록 저장
    // Step 3. 선물 지수 계산
    // Step 4. i와 j의 선물을 주고 받은 개수 확인
    // Step 5. 선물을 주고 받은 개수가 같으면 선물 지수 확인
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] giftGraph = new int[friends.length][friends.length]; // 선물 누가 누구한테 줬는지에 대해 기록하는 배열
        int[] giftDegree = new int[friends.length]; // 선물 지수
        List<String> giftList = Arrays.asList(friends); // firends 배열을 List로 변환
        // 선물지수는 선물 준만큼 플러스, 선물 받은만큼 마이너스. giftGraph는 누가 누구에게 선물을 줬는지에 대해 마찬가지로 준만큼 플러스
        for(String gift : gifts) {
            String[] tmp = gift.split(" ");
            giftDegree[giftList.indexOf(tmp[0])]++;
            giftDegree[giftList.indexOf(tmp[1])]--;
            giftGraph[giftList.indexOf(tmp[0])][giftList.indexOf(tmp[1])]++;
        }
        // 선물을 더 많이 해줬으면 선물을 받고, 선물을 둘다 똑같이 해줬는데 선물지수가 상대보다 더 높다면 선물 받는 cnt 1 UP
        // 정답은 가장 선물을 많이 받는 사람이 선물을 몇 개 받는지에 대한 계산이므로, cnt와 기존 answer 중에 더 높은 값을 answer 로 정한다.
        for(int i=0; i<friends.length; i++) {
            int cnt=0;
            for(int j=0; j<friends.length; j++) {
                if(i==j) continue;
                if((giftGraph[i][j] > giftGraph[j][i]) || ((giftGraph[i][j] == giftGraph[j][i] && (giftDegree[i] > giftDegree[j])))) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
