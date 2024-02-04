package tests.connectingIslands.main;

import tests.connectingIslands.problem.ConnectingIslands;

public class Main {
    public static void main(String[] args) {
        ConnectingIslands ci = new ConnectingIslands();
        int n=4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(ci.solution(n, costs));
    }
}
