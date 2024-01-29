package tests.developFunction;
import java.util.*;

public class developFunction {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> pQueue = new LinkedList<>(); // progress Queue
        Queue<Integer> sQueue = new LinkedList<>(); // speed Queue
        ArrayList<Integer> arr = new ArrayList<>(); // 결과값을 담는 ArrayList 생성
        for(int i=0; i<progresses.length; i++) { // 큐에 원소들을 각각 담는 과정
            pQueue.offer(progresses[i]);
            sQueue.offer(speeds[i]);
        }
        while(!pQueue.isEmpty()) {
            // 하루가 지난 후의 진행도를 계산
            int count = 0, pSize = pQueue.size(), sSize = sQueue.size();
            for(int i=0; i<pSize; i++) {
                int pValue = pQueue.poll();
                int sValue = sQueue.poll();
                pQueue.offer(pValue + sValue);
                sQueue.offer(sValue);
            }
            // 가장 앞에 있는 작업이 끝난 것을 순차적으로 확인
            while(!pQueue.isEmpty() && pQueue.element() >= 100) {
                pQueue.poll();
                sQueue.poll();
                count++;
            }
            // count 값이 0이 아니라면 완료된 작업이 있다는 뜻이므로 결과값을 담는 ArrayList인 arr에 count 값을 추가
            if(count != 0) {
                arr.add(count);
            }
        }

        int[] result = new int[arr.size()];
        int idx=0;
        for(int a : arr) {
            result[idx++] = a;
        }
        return result;
    }
}