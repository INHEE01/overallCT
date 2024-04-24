package tests.removeInPairs.problem;

import java.util.Stack;

public class RemoveInPairs {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
