package com.github.tulesaza.greatestcommondivisorofstrings;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str2 + str1).equals(str1 + str2)) {
            return "";
        }
        String longer = str1, shorter = str2;
        if (str2.length() > str1.length()) {
            longer = str2;
            shorter = str1;
        }
        while (!shorter.isEmpty()) {
            String tmp = longer.substring(shorter.length());
            if (tmp.length() > shorter.length()) {
                longer = tmp;
            } else {
                longer = shorter;
                shorter = tmp;
            }
        }
        return longer;
    }

    // More elegant
    public String gcdOfStrings2(String str1, String str2) {
        if (!(str2 + str1).equals(str1 + str2)) {
            return "";
        }
        int commonLength = gcd(str1.length(), str2.length());
        return str1.substring(0, commonLength);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
