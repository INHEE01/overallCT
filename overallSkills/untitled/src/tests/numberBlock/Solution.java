package tests.numberBlock;

public class Solution {
    public int[] solution(long begin, long end) {
        int len = Long.valueOf(end-begin+1).intValue();
        int[] answer = new int[len];

        int arrIdx = 0;
        for(long i=begin; i<=end; i++) {
            if(i == 1){
                answer[arrIdx++] = 0;
                continue;
            } else {
                answer[arrIdx++] = (int) block(i);
            }
        }

        return answer;
    }

    public long block(long n){
        for(long i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                if(n/i > 10000000){
                    continue;
                }
                return n/i;
            }
        }
        return 1;
    }
}
