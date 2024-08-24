package tests.Plus;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        List<Integer> tmp = new ArrayList<>(); // tmp : 답을 저장해두는 List
        // 시간 복잡도 O(n^2)
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                // List에 해당 값이 존재하지 않는다면 List에 추가
                if(!tmp.contains(sum)) {
                    tmp.add(sum);
                }
            }
        }
        // 오름차순 정렬
        Collections.sort(tmp); // Arrays.sort(int : parameter) >> 배열을 정렬하는 method. Collections.sort(int : parameter) >> Collections을 정렬하는 method
        answer = tmp.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}