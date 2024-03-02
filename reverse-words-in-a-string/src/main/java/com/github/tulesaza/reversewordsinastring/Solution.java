package com.github.tulesaza.reversewordsinastring;

import java.util.Arrays;


// TODO do it cool and hard way without built-in functions
class Solution {
    public String reverseWords(String s) {
        return String.join(" ", Arrays.asList(s.trim().split("\\s+")).reversed());
    }
}