package com.tulesaza.longestsubstringwithoutrepeatingcharacters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3",
            "abcdefghijklmnopqrstuvwxyz, 26",
            "bcaaaaaaaabcdef, 6"
    })
    void lengthOfLongestSubstring(String input, int expected) {
        assertEquals(expected, solution.lengthOfLongestSubstring(input));
    }
}