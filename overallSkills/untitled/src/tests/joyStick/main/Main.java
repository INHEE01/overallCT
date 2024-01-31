package tests.joyStick.main;

import tests.joyStick.problem.JoyStick;

public class Main {
    public static void main(String[] args) {
        int a1 = (int) 'C';
        int a2 = (int) 'X';
        int subtraction = Math.abs(a1 - a2);
        System.out.println(subtraction);
        System.out.println((25-subtraction));

        String name = "JAAAEAN"; // AAAAAA
        JoyStick j = new JoyStick();
        System.out.println(j.solution(name));

    }
}
