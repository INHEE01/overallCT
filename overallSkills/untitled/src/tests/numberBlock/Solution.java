package tests.numberBlock;



public class Solution {
    public int[] solution(long begin, long end) {
        public int[] solution(long begin, long end) {
            int first = (int) begin;
            int last = (int) end;
            int[] answer = new int[last-first+1];

            for (int i = first; i < last + 1; i++) {
                answer[i-first] = 1;

                for (int div = 2; div <= Math.floor(Math.sqrt(i)); div++) {
                    if (i % div == 0 && i / div <= 10000000) {
                        answer[i - first] = i / div;
                        break;
                    }
                }
            }

            if (first == 1)
                answer[0] = 0;

            return answer;
        }
    }
}
