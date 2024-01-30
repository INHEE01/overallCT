package tests.exercisingUniform.main;

import tests.exercisingUniform.problem.ExercisingUniform;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        ExercisingUniform eu = new ExercisingUniform();
        System.out.println(eu.solution(n, lost, reserve));
    }
}
