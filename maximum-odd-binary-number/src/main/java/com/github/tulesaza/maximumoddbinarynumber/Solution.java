package com.github.tulesaza.maximumoddbinarynumber;

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int nextIndex = n - 1;
        StringBuilder sb = new StringBuilder("0".repeat(n));
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                sb.setCharAt(nextIndex, '1');
                nextIndex = (nextIndex + 1) % n;
            }
        }
        return sb.toString();
    }
}