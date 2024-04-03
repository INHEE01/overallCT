package tests.undestroyedConstruction.problem;

public class UndestroyedConstruction {
    public int solution(int[][] board, int[][] skill) {
        for (int[] cast : skill) {
            int type = cast[0];
            int r1 = cast[1];
            int c1 = cast[2];
            int r2 = cast[3];
            int c2 = cast[4];
            int degree = cast[5];

            if (type == 1) {
                degree *= -1;
            }

            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    board[i][j] += degree;
                }
            }
        }

        int answer = 0;
        for (int[] row : board) {
            for (int col : row) {
                if (col > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}