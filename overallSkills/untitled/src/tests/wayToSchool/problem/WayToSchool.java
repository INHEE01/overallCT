package tests.wayToSchool.problem;

public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1]; // DP 배열 생성
        int div = 1000000007; // 최단 경로의 개수를 1,000,000,007 로 나눠야함
        dp[1][1] = 1; // 가장 왼쪽 위, 즉 집이 있는 곳의 좌표
        // 웅덩이 생성
        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        // n 증가 : 오른쪽, m 증가 : 아래
        // 진행 : 웅덩이를 마주친다면, 웅덩이를 건너뛴다.
        // 오른쪽과 아래로만 움직이기
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                // (i, j)로 갈 수 있는 최단거리 경우의 수를 구한다.
                if (!(i == 1 && j == 1)) {
                    int left = 0;
                    int up = 0;

                    if (j > 1)
                        left = dp[i][j - 1];
                    if (i > 1)
                        up = dp[i - 1][j];

                    dp[i][j] = (left + up) % div;
                }
            }
        }

        return dp[n][m];
    }
}
