package tests.relatedSpace.problem;

public class RelatedSpace {
    public int solution(String[][] board, int h, int w) {
        int cnt = 0;
        int n = board.length;
        int[] x = {0, 1, -1, 0};
        int[] y = {1, 0, 0, -1};

        for (int i=0; i<x.length; i++) {
            int h_check = h + x[i];
            int w_check = w + y[i];

            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n){
                if (board[h][w].equals(board[h_check][w_check])){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
