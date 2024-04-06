package tests.lifeboat.problem;

import java.util.Arrays;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        // 40 ,40, 40, 60, 80, 100
        int minIdx=0, count=0;
        Arrays.sort(people);
        // 무게 초과하면 새로운 보트 보내주기
        for(int maxIdx=people.length-1; maxIdx >= minIdx; maxIdx--) {
            if(people[minIdx] + people[maxIdx] <= limit) {
                minIdx++;
            }
            count++;

        }
        return count;
    }
}
