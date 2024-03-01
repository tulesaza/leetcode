package com.github.tulesaza.issubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            if (t.charAt(tPointer) != s.charAt(sPointer)) {
                tPointer++;
            } else {
                sPointer++;
                tPointer++;
            }
        }

        return sPointer == s.length();
    }
}
