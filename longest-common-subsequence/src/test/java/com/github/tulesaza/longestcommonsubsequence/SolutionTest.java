package com.github.tulesaza.longestcommonsubsequence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    final Solution solution = new Solution();

    @ParameterizedTest
    @CsvSource(value = {
            "abc, gdhdh, 0",
            "akiobpfdsc, atybxtc, 3",
            "abcd, abcd, 4"

    })
    void longestCommonSubsequence(String p, String q, int expected) {
        assertEquals(expected, solution.longestCommonSubsequence(p, q));
    }
}