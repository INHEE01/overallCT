package tests.theMostGivenGift.main;

import tests.theMostGivenGift.problem.TheMostGivenGift;

public class Main {
    public static void main(String[] args) {
        TheMostGivenGift c = new TheMostGivenGift();
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(c.solution(friends, gifts));
    }
}
