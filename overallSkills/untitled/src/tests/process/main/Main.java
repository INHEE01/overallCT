package tests.process.main;

import tests.process.problem.ProblemProcess;

public class Main {
    public static void main(String[] args) {
        ProblemProcess p = new ProblemProcess();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(p.solution(priorities, location));
    }
}
