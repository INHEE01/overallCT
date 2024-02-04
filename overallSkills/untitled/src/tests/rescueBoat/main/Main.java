package tests.rescueBoat.main;

import tests.rescueBoat.problem.RescueBoat;

public class Main {
    public static void main(String[] args) {
        RescueBoat rb = new RescueBoat();
        int[] people = {40, 70, 40, 70, 120};
        int limit = 120;
        System.out.println(rb.solution(people, limit));
    }
}
