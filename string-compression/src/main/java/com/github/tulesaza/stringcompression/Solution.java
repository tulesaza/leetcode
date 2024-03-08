package com.github.tulesaza.stringcompression;

class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int current = 0, next = current + 1, newIndex = 0, length = 0;
        while (current < chars.length) {
            while (next < chars.length && chars[current] == chars[next]) {
                next++;
            }
            chars[newIndex++] = chars[current];
            length++;
            if (next - current > 1) {
                String count = String.valueOf(next - current);
                for (char digit : count.toCharArray()) {
                    chars[newIndex++] = digit;
                    length++;
                }
            }
            current = next;
            next = current + 1;
        }

        return length;
    }
}