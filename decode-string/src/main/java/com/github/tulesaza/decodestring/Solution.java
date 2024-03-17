package com.github.tulesaza.decodestring;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public String decodeString(String s) {
        Deque<Integer> repeats = new ArrayDeque<>();
        Deque<Character> symbols = new ArrayDeque<>();
        int number = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == ']') {
                List<Character> list = new ArrayList<>();
                while (symbols.peek() != '[') {
                    list.add(symbols.pop());
                }
                symbols.pop(); // remove '['
                int repeat = repeats.pop();
                for (int i = repeat; i > 0; --i) {
                    for (int j = list.size() - 1; j >= 0; --j) {
                        symbols.push(list.get(j));
                    }
                }
            } else if (c == '[') {
                repeats.push(number);
                number = 0;
                symbols.push(c);
            } else {
                symbols.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!symbols.isEmpty()) {
            sb.append(symbols.pop());
        }
        return sb.reverse().toString();
    }
}