package tests.integerTriangle.problem;

public class Main {
    public static void main(String[] args) {
        IntegerTriangle it = new IntegerTriangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        it.solution(triangle);
    }
}
