package com.github.tulesaza.reversevowelsofastring;

import java.util.Set;

class Solution {
    private final static Set<Character> VOWELS = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

    public String reverseVowels(String s) {
        if (s.length() < 2) return s;
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(sb.charAt(left))) left++;
            while (left < right && !isVowel(sb.charAt(right))) right--;
            if (isVowel(sb.charAt(left)) && isVowel(sb.charAt(right))) {
                swap(sb, left, right);
                right--;
                left++;
            }
        }
        return sb.toString();
    }

    private void swap(StringBuilder sb, int p, int q) {
        char tmp = sb.charAt(p);
        sb.setCharAt(p, sb.charAt(q));
        sb.setCharAt(q, tmp);
    }

    private boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}