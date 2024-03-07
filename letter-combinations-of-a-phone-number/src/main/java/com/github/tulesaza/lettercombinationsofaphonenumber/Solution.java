package com.github.tulesaza.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    private final static String[] LETTERS_PER_BUTTON = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // Iterative solution
    // Time: O(3(4)^N)
    // Space: O(3(4)^N)
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        result.add("");
        for (char digit : digits.toCharArray()) {
            char[] letters = LETTERS_PER_BUTTON[digit - '0' - 2].toCharArray();
            List<String> level = new ArrayList<>();
            for (char letter : letters) {
                for (String combination : result) {
                    level.add(combination + letter);
                }
            }
            result = level;
        }
        return result;
    }

    // Time O(4^n)
    // Space O(n)
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, result, sb);
        return result;
    }

    private void dfs(String digits, int level, List<String> result, StringBuilder current) {
        if (level >= digits.length()) {
            result.add(current.toString());
            return;
        }
        for (char letter: LETTERS_PER_BUTTON[digits.charAt(level) - '0' - 2].toCharArray()){
            current.append(letter);
            dfs(digits, level + 1, result, current);
            current.deleteCharAt(current.length() - 1);
        }


    }
}