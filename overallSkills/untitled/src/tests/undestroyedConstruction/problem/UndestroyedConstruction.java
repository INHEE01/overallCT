package tests.undestroyedConstruction.problem;

public class UndestroyedConstruction {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] map = new int[n + 2][m + 2];

        for (int[] sk : skill) {
            int type = sk[0], r1 = sk[1], c1 = sk[2], r2 = sk[3], c2 = sk[4], degree = sk[5];
            if (type == 1) {
                degree *= -1;
            }

            map[r1 + 1][c1 + 1] += degree; // 왼쪽 상단
            map[r1 + 1][c2 + 2] -= degree; // 오른쪽 상단 경계 뒤
            map[r2 + 2][c1 + 1] -= degree; // 왼쪽 하단 경계 아래
            map[r2 + 2][c2 + 2] += degree; // 오른쪽 하단 경계 뒤
        }
        // 변화계산
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= m + 1; j++) {
                map[i][j] += map[i - 1][j] + map[i][j - 1] - map[i - 1][j - 1];
            }
        }
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                board[i - 1][j - 1] += map[i][j];
                // 변화가 적용된 board의 값이 양수라면 answer 증가
                if (board[i - 1][j - 1] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}