package com.github.tulesaza.longestvalidparenthses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "(), 2",
            "'', 0",
            ")(, 0",
            "()()), 4",
            "(()()), 6",
            ")()()), 4",
            ")()()))(()()()), 8"
    })
    void longestValidParentheses(String s, int expected) {
        assertEquals(expected, solution.longestValidParentheses(s));
    }
}