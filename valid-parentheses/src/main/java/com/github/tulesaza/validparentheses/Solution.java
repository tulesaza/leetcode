package com.github.tulesaza.validparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (validParentheses(stack.peek(), c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static boolean validParentheses(char opener, char closer) {
        return (opener == '(' && closer == ')')
                || (opener == '{' && closer == '}')
                || (opener == '[' && closer == ']');
    }
}