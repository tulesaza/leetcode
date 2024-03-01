package com.github.tulesaza.removingstarsfromastring;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
