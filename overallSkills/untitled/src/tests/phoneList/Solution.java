package tests.phoneList;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean solution(String[] phone_book) {
        return isPrefixExist(phone_book);
    }

    public boolean isPrefixExist(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();
        for(int i=0; i<phone_book.length; i++) {
            set.add(phone_book[i]);
        }

        for(String num : phone_book) {
            for(int i=1; i<num.length(); i++) {
                if(set.contains(num.substring(0, i)))
                    return false;
            }
        }
        return answer;
    }
}