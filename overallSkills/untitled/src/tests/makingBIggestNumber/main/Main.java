package tests.makingBIggestNumber.main;

import tests.makingBIggestNumber.problem.MakingBiggestNumber;

public class Main {
    public static void main(String[] args) {
        MakingBiggestNumber mbn = new MakingBiggestNumber();
        String number = "1824";
        int k=2;
        System.out.println(mbn.solution(number, k));
    }
}
