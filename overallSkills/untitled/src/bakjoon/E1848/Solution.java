package bakjoon.E1848;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    // 해당 자연수 pop 할 수 있을 때 까지 스택에 push
    // 과정 진행 도중 불가능 판정 받으면 NO 출력하고 종료
    // push는 +로, pop은 -로
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();
        int[] A = new int[size];

        for(int i=0; i<size; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        // 
        for(int i=0; i<size; i++) {
            int elem = A[i];
            if(elem >= num) {
                while(elem >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.pop();
                if(n > elem) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result) System.out.println(sb.toString());
    }
}
