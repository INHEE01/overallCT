package tests.process.problem;

import java.util.*;

public class ProblemProcess {
    private int[] priorities;
    private int location;
    public ProblemProcess() {

    }
    public ProblemProcess(int[] priorities, int location) {
        this.priorities = priorities;
        this.location = location;
    }
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder()); // 선입선출 큐. 가장 큰 값부터 나오게 됨. PriorityQueue 는 Heap으로 구성된 이진트리 구조이다. 시간복잡도는 O(NlogN)
        int result=0;
        for(int priority : priorities) { // 큐에 priorities 배열 값들 삽입
            p.add(priority);
        }
        while(!p.isEmpty()) { // Queue p 가 비어있을 때 까지 반복. 즉, 모든 프로세스가 전부 수행될 때까지 반복
            for(int i=0; i<priorities.length; i++) {
                if(p.peek() == priorities[i]) { // 우선순위 큐 p 는 가장 큰 값부터 나오는 선입선출 큐인데, 기존의 priorities 배열과 비교해서 poll 시킴. 이 때, i가 의미하는 것은 정렬되기 전 상태, 즉 원래의 인덱스 값을 뜻함.
                    p.poll();
                    result++;
                    if(location == i) { // location(위치 인덱스)이 i와 값이 같다면, 내가 원하는 위치의 프로세스의 결과값이 나온 것이므로 반환 후 종료
                        return result;
                    }
                }
            }
        }
        return result;
    }
}