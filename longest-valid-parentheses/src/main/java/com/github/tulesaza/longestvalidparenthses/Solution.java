package com.github.tulesaza.longestvalidparenthses;

import java.util.LinkedList;

class Solution {

    public int longestValidParentheses(String s) {
        LinkedList<Item> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(Item.from(s, i));
                continue;
            }
            if (isParentheses(stack.peek().value(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(Item.from(s, i));
            }
        }
        //System.out.println(stack);

        if (stack.isEmpty()) {
            return s.length();
        }

        stack.add(new Item('t', -1));
        int endIndex = s.length();
        int maxLength = 0;
        while (!stack.isEmpty()) {
            int startIndex = stack.pop().index();
            maxLength = Math.max(maxLength, endIndex - startIndex - 1);
            endIndex = startIndex;
        }


        return maxLength;
    }

    private boolean isParentheses(char a, char b) {
        return a == '(' && b == ')';
    }

    record Item(char value, int index) {
        static Item from(String s, int index) {
            return new Item(s.charAt(index), index);
        }

        @Override
        public String toString() {
            return "s[%d]=%s".formatted(index, value);
        }
    }
}