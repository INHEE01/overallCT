package tests.triangleSnail.problem;

public class TriangleSnail {
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int sum =0;

        for(int i=1; i<=n; i++){
            sum += i;
            matrix[i-1] = new int[i];
        }

        int x = -1;
        int y = 0;
        int index = 1;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3 == 0){
                    x++;
                }

                else if(i%3 == 1){
                    y++;
                }
                else{
                    x--;
                    y--;
                }
                matrix[x][y] = index++;
            }
        }

        int[] answer = new int[sum];
        int num = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<matrix[i].length; j++){
                answer[num++] = matrix[i][j];
            }
        }

        return answer;
    }
}
