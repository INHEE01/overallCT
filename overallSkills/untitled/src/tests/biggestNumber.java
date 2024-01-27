package tests;

import java.util.Arrays;
import java.util.Comparator;

public class biggestNumber {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        int idx=0;
        for(int num : numbers) {
            nums[idx++] = String.valueOf(num);
        }
        // Comparator Override 를 통해 nums 배열 재정렬
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o2 + o1;
                String s2 = o1 + o2;

                return s1.compareTo(s2);
            }
        });
        // 맨 앞 원소가 0이면 계산 x
        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String n : nums) {
            sb.append(n);
        }

        return sb.toString();
    }
}
