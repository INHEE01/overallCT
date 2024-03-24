package tests.integerTriangle.problem;

class IntegerTriangle {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length]; // Dynamic Programming 사용
        dp[0][0] = triangle[0][0]; // 맨 위 원소 고정
        // Step 1. 아래로 이동
        for(int i = 1; i < triangle.length; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0]; // 초기값 설정 첫 번째 원소
            // Step 2. 옆으로 이동하면서 숫자가 가장 큰 경우를 dp 배열에 저장
            for(int j = 1; j < i + 1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]); // 최대값 저장
            }
        }
        int max = 0;
        // Step 3. 거쳐간 숫자의 합이 가장 큰 경우를 찾기
        for(int i = 0; i < triangle.length; i++){
            // Step 4. 맨 밑줄을 통해 최대값 찾기
            if(dp[triangle.length-1][i] > max)
                max = dp[triangle.length-1][i];
        }
        return max;
    }
}