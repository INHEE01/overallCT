package tests.makingBIggestNumber.problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakingBiggestNumber {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            while (!deque.isEmpty() && deque.peekLast() < number.charAt(i) && k > 0) {
                deque.removeLast();
                k--;
            }
            deque.addLast(number.charAt(i));
        }

        while(deque.size() > number.length() - k) {
            deque.removeLast();
        }

        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
