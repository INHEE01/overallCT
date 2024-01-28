package tests.targetNumber;

public class targetNumber {
    static int count=0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0); // int[] numbers, depth=0, target=target, sum=0 DFS start
        return count;
    }
    // DFS start
    public void dfs(int[] numbers, int depth, int target, int sum) {
        // dfs 종료 조건
        if(depth == numbers.length) {
            if(sum == target) {
                count++;
            }
            return;
        }

        int plusSum = sum + numbers[depth];
        int minusSum = sum - numbers[depth];

        dfs(numbers, depth+1, target, plusSum);
        dfs(numbers, depth+1, target, minusSum);
    }
    // DFS end
}
