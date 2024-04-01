package com.github.tulesaza.lengthoflastword;

class Solution {
    // Two pointers - exclusive boundaries of word.
    // Time O(n), space O(1)
    public int lengthOfLastWord1(String s) {
        int lengthOfWord = 0;
        for (int l = -1, r = 0; r <= s.length(); ++r) {
            if (r == s.length() || s.charAt(r) == ' ') {
                lengthOfWord = r - l - 1 > 0 && Character.isLetter(s.charAt(l + 1)) ? r - l - 1 : lengthOfWord;
                l = r;
            }
        }
        return lengthOfWord;
    }

    // Iterate from the end, faster
    // Time O(n), space O(1)
    public int lengthOfLastWord2(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') length++;
            else if (length > 0) break;
        }
        return length;
    }
}