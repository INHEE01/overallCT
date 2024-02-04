package tests.rescueBoat.problem;

import java.util.Arrays;

public class RescueBoat {
    public int solution(int[] people, int limit) {
        int minIdx=0, count=0;
        Arrays.sort(people);
        // 최대값과 최소값을 비교하면서, 두개의 합이 limit 을 넘지 않는다면 최소값의 인덱스를 하나씩 올려주면서 반복하게 된다.
        for(int maxIdx=people.length-1; maxIdx >= minIdx; maxIdx--) {
            if(people[minIdx] + people[maxIdx] <= limit) {
                minIdx++;
            }
            count++;
        }
        return count;
    }
}
