package com.github.tulesaza.reversevowelsofastring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "hello, holle",
            "leetcode, leotcede",
            "leeticode, leoticede"
    })
    void reverseVowels(String s, String expected) {
        assertEquals(expected, solution.reverseVowels(s));
    }
}