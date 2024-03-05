package com.github.tulesaza.minimumlengthofstringafterdeletingsimilarends;

class Solution {


    public int minimumLength(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            char current = s.charAt(left);
            while (left <= right && s.charAt(left) == current) {
                left++;
            }
            while (left <= right && s.charAt(right) == current) {
                right--;
            }
        }
        return right - left + 1;
    }
}
